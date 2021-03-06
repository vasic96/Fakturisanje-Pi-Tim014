package tim014.pi.fakturisanje.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim014.pi.fakturisanje.model.StavkaFakture;

import java.util.List;

@Repository
public interface StavkaFaktureRepository extends JpaRepository<StavkaFakture, Long>{
    List<StavkaFakture> findAllByFakturaId(Long id);
    void deleteAllByFakturaId(Long id);
}
