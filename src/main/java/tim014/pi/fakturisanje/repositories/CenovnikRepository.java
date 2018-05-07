package tim014.pi.fakturisanje.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim014.pi.fakturisanje.Fakturisanje.model.Cenovnik;

@Repository
public interface CenovnikRepository extends JpaRepository<Cenovnik, Long>{

}
