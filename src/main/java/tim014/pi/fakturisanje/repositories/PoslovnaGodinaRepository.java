package tim014.pi.fakturisanje.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim014.pi.fakturisanje.model.PoslovnaGodina;

@Repository
public interface PoslovnaGodinaRepository extends JpaRepository<PoslovnaGodina, Long>{

}
