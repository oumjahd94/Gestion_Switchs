package ma.oumjahd.ocp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.oumjahd.ocp.entities.Commutateur;
import ma.oumjahd.ocp.entities.Site;

public interface CommutateurRepository extends JpaRepository<Commutateur, String>{
	 
	@Query("select C from Commutateur C where C.Nom=:x ")
	public Commutateur FindSwitchByName(@Param("x")String name); 
		
	@Modifying 
    @Query("update Commutateur set localTechnique.Nom =:x where Serie=:y")
    public void ChangerLocalSwitch(@Param("y")String serie,@Param("x")String locale);  
	
	@Modifying
	@Query(nativeQuery=true,value="insert into liaison values(:a,:b)")	
	public void LiserSwitches(@Param("a") String sw1,@Param("b") String sw2) ;    
	
	@Modifying
	@Query(nativeQuery=true,value="insert into stacking values(:c,:d)")	
	public void StackerSwitches(@Param("c") String sw1,@Param("d") String sw2) ;  
	
	@Query("select c from Commutateur c where  (c.Nom like :x ) OR (c.Serie like :x ) OR (c.niveau like :x) OR (c.NbrePorts like :x) OR (c.Marque like :x)  ")   
	Page<Commutateur> chercher(@Param("x")String motCle, Pageable p);

}  