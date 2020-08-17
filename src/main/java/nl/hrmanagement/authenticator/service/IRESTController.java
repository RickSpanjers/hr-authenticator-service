package nl.hrmanagement.authenticator.service;

import nl.hrmanagement.authenticator.dto.*;
import org.springframework.http.ResponseEntity;
import javax.ejb.Local;

@Local
public interface IRESTController {
    ResponseEntity loginUser(LoginDTO dto);
}
