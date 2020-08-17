package nl.hrmanagement.authenticator.service;

import nl.hrmanagement.authenticator.dto.*;

import javax.ejb.Local;
import java.util.UUID;

@Local
public interface IServiceProvider {
    GenericResponseDTO loginUser(LoginDTO dto);
}
