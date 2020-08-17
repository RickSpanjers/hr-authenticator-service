package nl.hrmanagement.authenticator.repository;

import nl.hrmanagement.authenticator.model.User;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @QueryHints(@QueryHint(name= org.hibernate.annotations.QueryHints.CACHEABLE, value="true"))
    User findById(int id);

    @QueryHints(@QueryHint(name= org.hibernate.annotations.QueryHints.CACHEABLE, value="true"))
    User findByMail(String mail);

    @QueryHints(@QueryHint(name= org.hibernate.annotations.QueryHints.CACHEABLE, value="true"))
    User findByUuid(UUID id);


}
