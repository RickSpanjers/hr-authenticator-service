package nl.hrmanagement.authenticator.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Cacheable
@Table(name = "users")
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Column(name = "mail")
    private String mail;
    @Column(name = "password")
    private String password;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "phone")
    private String telephone;
    @Column(name = "address")
    private String address;
    @Column(name = "country")
    private String country;
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "place")
    private String place;
    @Column(name="functionId")
    private UUID functionId;
    @Column(name="companyId")
    private UUID companyId;
    @Column(name="archived")
    private boolean archived;

    @ManyToOne
    @JoinColumn(name="role_id", nullable=true)
    private Role role;

    public User(){
    }

    public User(int id, UUID uuid, String firstName, String lastName, UUID companyId, UUID functionId){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uuid = uuid;
        this.companyId = companyId;
        this.functionId = functionId;
    }

    public User(String mail, String password, String firstName, String lastName, String telephone, String address, String country, String zipcode, String place, UUID functionId, UUID companyId, Role role) {
        this.mail = mail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
        this.country = country;
        this.zipcode = zipcode;
        this.place = place;
        this.functionId = functionId;
        this.companyId = companyId;
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public UUID getFunctionId() {
        return functionId;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public void setFunctionId(UUID functionId) {
        this.functionId = functionId;
    }
}
