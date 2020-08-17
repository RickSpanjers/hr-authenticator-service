package nl.hrmanagement.authenticator.dto;

import nl.hrmanagement.authenticator.model.User;

import java.util.UUID;

public class UserLoggedInDTO {
    private UUID id;
    private String firstname;
    private String lastname;
    private UUID role;
    private String mail;
    private String token;
    private UUID companyId;
    private UUID functionId;

    public UserLoggedInDTO(){

    }

    public UserLoggedInDTO(User user, String token){
        this.id = user.getUuid();
        this.firstname = user.getFirstName();
        this.lastname = user.getLastName();
        this.role = user.getRole().getUuid();
        this.mail = user.getMail();
        this.companyId = user.getCompanyId();
        this.functionId = user.getFunctionId();
        this.token = token;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public UUID getRole() {
        return role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setRole(UUID role) {
        this.role = role;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public UUID getFunctionId() {
        return functionId;
    }

    public void setFunctionId(UUID functionId) {
        this.functionId = functionId;
    }
}
