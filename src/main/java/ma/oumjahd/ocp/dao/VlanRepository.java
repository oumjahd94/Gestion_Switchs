package ma.oumjahd.ocp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.oumjahd.ocp.entities.Vlan;

public interface VlanRepository extends JpaRepository<Vlan, String>{
    
	@Query("select v from Vlan v where  (v.Nom like :x ) OR (v.Niveau like :x ) OR (v.Sw.Nom like :x)")   
	Page<Vlan> chercherVlanMc(@Param("x")String motCle, Pageable p);

	
/*	@Query("select count(vb) from VlanBatiment vb where vb.batiment =:x") 
	public Long NbreBatimAffecte(@Param("x")String vlan);   */     
} 
