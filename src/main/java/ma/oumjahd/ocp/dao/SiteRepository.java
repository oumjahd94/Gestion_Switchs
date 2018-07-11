package ma.oumjahd.ocp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.oumjahd.ocp.entities.Site;

public interface SiteRepository extends JpaRepository<Site, String>{
   @Query("select count(U) from User U where U.site.Ville=:x ")
	public Long nbreUserSite(@Param("x")String site);   
  	
	@Query("select count(B) from Batiment B where B.site.Ville=:y ")
   public Long nbreBatimentSite(@Param("y")String site);    
	
	@Query("select s from Site s where  (s.Ville like :x ) OR (s.Url like :x ) ")   
	public Page<Site> chercherSiteMc(@Param("x")String string,  Pageable p);  
}
