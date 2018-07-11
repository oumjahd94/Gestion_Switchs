package ma.oumjahd.ocp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.oumjahd.ocp.entities.Batiment;

public interface BatimentRepository extends JpaRepository<Batiment, String>{
	@Query("select count(sw) from Commutateur sw where sw.localTechnique.Nom =:x ")  
	public Long  NombreDeSwotches(@Param("x")String locale);   
	
	@Query("select count(L) from Local_technique L  where L.batiment.Denomination =:x ")
   public Long nbreLocalBat(@Param("x")String local); 
	
	@Query("select b from Batiment b where  (b.Denomination like :x ) OR (b.site.Ville like :x ) ")   
	public Page<Batiment> chercherBatimentMc(@Param("x")String motCle,  Pageable p);   
		
	@Modifying 
	@Query(nativeQuery=true,value="insert into vlan_batiment values(:x,:y)")	
	public void affecterVlaNBatiment( @Param("x") String batiment, @Param("y") String vlan);  	
}
