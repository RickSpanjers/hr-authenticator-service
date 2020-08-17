package nl.hrmanagement.authenticator.service;

import org.springframework.stereotype.Service;
import javax.ejb.Local;

@Local
@Service
public interface IPasswordEncoder {
    String encryptPassword(String password);
    boolean validatePassword(String originalPassword, String storedPassword);
}
