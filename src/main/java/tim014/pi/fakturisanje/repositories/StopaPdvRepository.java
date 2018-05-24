package tim014.pi.fakturisanje.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim014.pi.fakturisanje.model.StopaPDV;

import java.util.List;

@Repository
public interface StopaPdvRepository extends JpaRepository<StopaPDV, Long> {
    List<StopaPDV> findAllStopaPDVByPdvId(Long id);
}
