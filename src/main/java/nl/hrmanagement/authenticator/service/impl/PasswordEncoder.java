package nl.hrmanagement.authenticator.service.impl;

import nl.hrmanagement.authenticator.service.IPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoder implements IPasswordEncoder {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean validatePassword(String originalPassword, String storedPassword) {
        return BCrypt.checkpw(originalPassword, storedPassword);
    }
}
