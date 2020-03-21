package org.lockdown.app.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.lockdown.app.services.ILeaveTicketService;
import org.lockdown.app.services.IUserService;
import org.openapitools.api.TicketApi;
import org.openapitools.model.TicketPayload;
import org.openapitools.model.TicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-03-21T20:43:12.797Z[GMT]")

@Controller
@RequestMapping("${openapi.lockdownApp.base-path:/api}")
public class TicketApiController implements TicketApi {

    @Autowired
    ILeaveTicketService leaveTicketService;

    @Autowired
    IUserService userService;

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TicketApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<TicketRequest> addTicketRequest(@Valid TicketPayload ticketPayload) {

        final TicketRequest ticketRequest = leaveTicketService.addNewLeaveRequestToUser(ticketPayload);
        return ResponseEntity.ok().body(ticketRequest);
    }

    @Override
    public ResponseEntity<List<TicketPayload>> findTicketRequestsByPin(Long pin, String hash) {
        return null;
    }

}