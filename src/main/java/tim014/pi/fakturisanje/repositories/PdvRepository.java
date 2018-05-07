package tim014.pi.fakturisanje.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim014.pi.fakturisanje.model.PDV;

@Repository
public interface PdvRepository extends JpaRepository<PDV, Long> {

}
