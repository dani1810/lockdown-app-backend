package org.lockdown.app.services;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import org.lockdown.app.jpa.TicketPayloadRepository;
import org.lockdown.app.jpa.User;
import org.modelmapper.ModelMapper;
import org.openapitools.model.TicketPayload;
import org.openapitools.model.TicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by @author Jorge Machado on 21.03.20.
 */
@Service
public class TicketPayloadService implements ITicketPayloadService{

    @Autowired
    TicketPayloadRepository ticketPayloadRepository;

    @Autowired
    UserService userService;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public TicketRequest addNewLeaveRequestToUser(TicketPayload payload) {

        TicketPayload TicketPayload = modelMapper.map(payload, TicketPayload.class);
        Optional<User> dbUser = userService.getUserById(payload.getHashIdentityNumber(), payload.getUserPin());
        if(!dbUser.isPresent()){
            userService.createUser(payload.getHashIdentityNumber(), payload.getUserPin());
        }
        TicketPayload.setUser(dbUser.get());
        final TicketPayload save = ticketPayloadRepository.save(TicketPayload);
        return createTRequestFromLTicket(save);
    }

    @Override
    public Set<TicketPayload> getByHashAndPin(String hash, int pin) {
        final Optional<User> userById = userService.getUserById(hash, pin);
        if (!userById.isPresent()){
            return Collections.emptySet();
        }
        return ticketPayloadRepository.findByUser(userById.get());
    }

    private TicketRequest createTRequestFromLTicket(TicketPayload save) {
        return modelMapper.map(save, TicketRequest.class);
    }
}
