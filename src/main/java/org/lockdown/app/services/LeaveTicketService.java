package org.lockdown.app.services;

import java.util.Optional;

import org.lockdown.app.jpa.LeaveTicket;
import org.lockdown.app.jpa.LeaveTicketRepository;
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
public class LeaveTicketService implements ILeaveTicketService{

    @Autowired
    LeaveTicketRepository leaveTicketRepository;

    @Autowired
    UserService userService;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public TicketRequest addNewLeaveRequestToUser(TicketPayload payload) {

        LeaveTicket leaveTicket = modelMapper.map(payload, LeaveTicket.class);
        Optional<User> dbUser = userService.getUserById(payload.getHashIdentityNumber(), payload.getUserPin());
        if(!dbUser.isPresent()){
            userService.createUser(payload.getHashIdentityNumber(), payload.getUserPin());
        }
        leaveTicket.setUser(dbUser.get());
        final LeaveTicket save = leaveTicketRepository.save(leaveTicket);
        return ;
    }
}
