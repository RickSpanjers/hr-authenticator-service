package nl.hrmanagement.authenticator.service.impl;

import com.google.gson.Gson;
import nl.hrmanagement.authenticator.dto.*;
import nl.hrmanagement.authenticator.service.IRESTController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;


@RestController
@Stateless
public class AuthenticatorController implements IRESTController {

    @Autowired
    private AuthenticatorServiceProvider userServiceProvider;
    private Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Tries to log the user into the service
     * @param dto is the search the user does
     * @return {@link String} is the JSON result of the request
     * @throws NullPointerException in case something went wrong while executing the request
     */
    @Override

    @PostMapping(
            path = "/login",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity loginUser(@NotNull @RequestBody LoginDTO dto){
        String body = gson.toJson(userServiceProvider.loginUser(dto));
        return generateRequestResponse(body);
    }

    private ResponseEntity generateRequestResponse(String body){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        headers.add("Responded", "User Management Service");
        if(body != null){
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(body, headers, status);
    }



}
