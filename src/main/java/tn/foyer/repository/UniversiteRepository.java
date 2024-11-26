package tn.foyer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.foyer.entity.Universite;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long>
{


}
