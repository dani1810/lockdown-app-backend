package org.lockdown.app.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.lockdown.app.services.ITicketPayloadService;
import org.lockdown.app.services.IUserService;
import org.lockdown.app.api.TicketApi;
import org.lockdown.app.model.TicketPayload;
import org.lockdown.app.model.TicketRequest;
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
    ITicketPayloadService ticketPayloadService;

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

        final TicketRequest ticketRequest = ticketPayloadService.addNewLeaveRequestToUser(ticketPayload);
        return ResponseEntity.ok().body(ticketRequest);
    }


    @Override
    public ResponseEntity<List<TicketRequest>> findTicketRequestsByPin(Long pin, String hash) {
        final Set<TicketRequest> byHashAndPin = ticketPayloadService.getByHashAndPin(hash, Math.toIntExact(pin));
        return ResponseEntity.ok().body(byHashAndPin.stream().collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<TicketRequest> getTicketRequest(Long id, @NotNull @Valid Long pin) {
        final Optional<TicketRequest> byTicketRequestIdAndPin = ticketPayloadService.getByTicketRequestIdAndPin(id,
                Math.toIntExact(pin));
        return ResponseEntity.of(byTicketRequestIdAndPin);
    }

}
