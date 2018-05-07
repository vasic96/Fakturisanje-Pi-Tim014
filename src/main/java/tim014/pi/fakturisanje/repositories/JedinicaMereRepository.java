package tim014.pi.fakturisanje.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim014.pi.fakturisanje.model.JedinicaMere;

@Repository
public interface JedinicaMereRepository  extends JpaRepository<JedinicaMere, Long>{

}
