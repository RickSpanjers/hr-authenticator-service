package nl.hrmanagement.authenticator.service.impl;

import nl.hrmanagement.authenticator.dto.*;
import nl.hrmanagement.authenticator.model.*;
import nl.hrmanagement.authenticator.repository.*;
import nl.hrmanagement.authenticator.security.jwt.JwtTokenUtil;
import nl.hrmanagement.authenticator.service.IServiceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;

@Service
@Stateless
public class AuthenticatorServiceProvider implements IServiceProvider {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    public GenericResponseDTO loginUser(@NotNull LoginDTO dto) {
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", null);
        if (dto.getMail() != null && dto.getPassword() != null) {
            User user = userRepository.findByMail(dto.getMail());
            if(!user.isArchived()){
                if (passwordEncoder.validatePassword(dto.getPassword(), user.getPassword())) {
                    result.setMessage("Success!");
                    String token = jwtTokenUtil.generateToken(user);
                    UserLoggedInDTO userDTO = new UserLoggedInDTO(user, token);
                    result.setSuccess(true);
                    result.setData(userDTO);
                }
            }
        } else {
            throw new NullPointerException();
        }
        return result;
    }

}
