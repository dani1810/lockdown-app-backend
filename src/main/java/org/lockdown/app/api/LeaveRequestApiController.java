package org.lockdown.app.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.lockdown.app.exceptions.LeaveRequestOnFuture;
import org.lockdown.app.exceptions.UserNotFound;
import org.lockdown.app.jpa.LeaveRequestRepository;
import org.lockdown.app.jpa.UserJPA;
import org.lockdown.app.jpa.UserRepository;
import org.lockdown.app.model.LeaveRequest;
import org.lockdown.app.model.NewLeaveRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-03-21T14:31:13.518Z[GMT]")

@Controller
@RequestMapping("${openapi.lockdownApp.base-path:/api}")
public class LeaveRequestApiController implements LeaverequestApi {

    private final NativeWebRequest request;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    LeaveRequestRepository leaveRequestRepo;

    @Autowired
    UserRepository userRepo;

    @org.springframework.beans.factory.annotation.Autowired
    public LeaveRequestApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<LeaveRequest> addLeaveRequest(@Valid NewLeaveRequest newLeaveRequest) {
        LeaveRequest converted = modelMapper.map(newLeaveRequest, LeaveRequest.class);

        if (converted.getLeaveTime().isAfter(OffsetDateTime.now())){
            throw new LeaveRequestOnFuture();
        }
        long userPin = converted.getUserPin();
        String userHas = converted.getHashIdentityNumber();

        final Optional<UserJPA> userExists = userRepo.findByHashIdentityNumberAndUserPin(
                userHas,
                userPin);

        //Create a user on the fly for the pin
        if (!userExists.isPresent()){
            createUser(newLeaveRequest);
        }

        final LeaveRequest save = leaveRequestRepo.save(converted);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(save);
    }

    private void createUser(NewLeaveRequest lq){
        UserJPA user = new UserJPA();
        user.setUserPin(lq.getUserPin());
        user.setHashIdentityNumber(lq.getHashIdentityNumber());
        userRepo.save(user);
    }

    @Override
    public ResponseEntity<Void> deletePet(Long id, Long pin) {
        return null;
    }

    @Override
    public ResponseEntity<List<LeaveRequest>> findLeaveRequestsByPin(Long pin, String hashIdentityNumber) {
        Optional<UserJPA> user = userRepo.findByHashIdentityNumberAndUserPin(hashIdentityNumber, pin);
        if (!user.isPresent()){
            throw new UserNotFound();
        }
        final Set<LeaveRequest> byUser = leaveRequestRepo.findByUser(user.get());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ArrayList<>(byUser));
    }

    @Override
    public ResponseEntity<LeaveRequest> getLeaveRequest(Long id, @NotNull @Valid Long pin) {
        return null;
    }

}
