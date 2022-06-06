package manageClient2.repository;
import manageClient2.entities.Client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long>{
    List<Client> findByFirstnameLike(String firstname);
    List<Client> findByLastname(String lastname);

}
