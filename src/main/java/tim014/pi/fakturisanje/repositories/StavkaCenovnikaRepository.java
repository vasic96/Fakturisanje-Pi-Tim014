package tim014.pi.fakturisanje.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim014.pi.fakturisanje.model.StavkaCenovnika;

@Repository
public interface StavkaCenovnikaRepository  extends JpaRepository<StavkaCenovnika, Long>{

}
