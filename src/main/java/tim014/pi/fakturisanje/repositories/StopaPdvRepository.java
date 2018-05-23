package tim014.pi.fakturisanje.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim014.pi.fakturisanje.model.StopaPDV;

@Repository
public interface StopaPdvRepository extends JpaRepository<StopaPDV, Long> {
    public StopaPDV findStopaPDVByPdvId(Long id);
}
