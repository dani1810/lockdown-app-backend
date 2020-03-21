package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-03-21T14:31:13.518Z[GMT]")

@Controller
@RequestMapping("${openapi.lockdownApp.base-path:/api}")
public class LeaverequestApiController implements LeaverequestApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LeaverequestApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
