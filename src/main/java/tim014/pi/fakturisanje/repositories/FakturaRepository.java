package tim014.pi.fakturisanje.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim014.pi.fakturisanje.model.Faktura;

import java.util.List;

@Repository
public interface FakturaRepository extends JpaRepository<Faktura, Long>{
    List<Faktura> findAllByPreduzeceEmail(String email);
    Page<Faktura> findAllByPreduzeceEmail(String email, Pageable pageable);
}
