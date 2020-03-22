package org.lockdown.app.services;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.lockdown.app.jpa.TicketRequestE;
import org.lockdown.app.jpa.TicketRequestloadRepository;
import org.lockdown.app.jpa.UserE;
import org.modelmapper.ModelMapper;
import org.lockdown.app.model.TicketPayload;
import org.lockdown.app.model.TicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
@Service
public class TicketPayloadService implements ITicketPayloadService{

    @Autowired
    TicketRequestloadRepository ticketRequestloadRepository;

    @Autowired
    UserService userService;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public TicketRequest addNewLeaveRequestToUser(TicketPayload payload) {

        TicketRequestE ticketRequest = modelMapper.map(payload, TicketRequestE.class);
        Optional<UserE> dbUser = userService.getUserById(payload.getHashIdentityNumber(), payload.getUserPin());
        if(!dbUser.isPresent()){
            userService.createUser(payload.getHashIdentityNumber(), payload.getUserPin());
        }
        ticketRequest.setUser(dbUser.get());
        final TicketRequestE save = ticketRequestloadRepository.save(ticketRequest);
        return createTRequestFromLTicket(save);
    }

    @Override
    public Set<TicketRequest> getByHashAndPin(String hash, int pin) {
        final Optional<UserE> userById = userService.getUserById(hash, pin);
        if (!userById.isPresent()){
            return Collections.emptySet();
        }
        return createTRFromTRE(ticketRequestloadRepository.findByUser(userById.get()));
    }

    @Override
    public Optional<TicketRequest> getByTicketRequestIdAndPin(long ticketId, int pin) {
        final Optional<TicketRequestE> byId = ticketRequestloadRepository.findById(ticketId);
        if (byId.isPresent() && byId.get().getUser().getUserPin() == pin){
            return Optional.of(createTRequestFromLTicket(byId.get()));

        }
        return Optional.empty();
    }

    private TicketRequest createTRequestFromLTicket(TicketRequestE save) {
        return modelMapper.map(save, TicketRequest.class);
    }

    private Set<TicketRequest> createTRFromTRE(Set<TicketRequestE> e){

        return e.stream().map(this::createTRequestFromLTicket).collect(Collectors.toSet());

    }
}
