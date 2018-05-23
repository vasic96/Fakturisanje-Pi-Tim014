package tim014.pi.fakturisanje.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim014.pi.fakturisanje.model.GrupaRobe;

@Repository
public interface GrupaRobeRepository extends JpaRepository<GrupaRobe, Long> {

	List<GrupaRobe> findAllByPdvId(Long id);
}
