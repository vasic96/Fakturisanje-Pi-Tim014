package tim014.pi.fakturisanje.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim014.pi.fakturisanje.Fakturisanje.model.Preduzece;

@Repository
public interface PreduzeceRepository extends JpaRepository<Preduzece, Long> {

}
