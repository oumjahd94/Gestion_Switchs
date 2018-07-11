package ma.oumjahd.ocp.dao;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.oumjahd.ocp.entities.Local_technique;

public interface LocalTechniqueRepository extends JpaRepository<Local_technique, String>{ 
	@Query("select l from Local_technique l where l.batiment.Denomination =:x")
    public Collection<Local_technique>ListelocauxParBatim(@Param("x") String batiment) ; 
    
	@Query("select l from Local_technique l where  (l.Nom like :x ) OR (l.batiment.Denomination like :x ) OR (l.Etage like :x)")   
	public Page<Local_technique> chercherLocalMc(@Param("x") String motCle, Pageable p);     
	
}
