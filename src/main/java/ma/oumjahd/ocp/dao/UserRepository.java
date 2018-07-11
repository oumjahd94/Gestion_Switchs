package ma.oumjahd.ocp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.oumjahd.ocp.entities.User;

public interface UserRepository extends JpaRepository<User, String> { 
	
	@Modifying
	@Query("update User set Statut=:y  where Nom =:x")
    public void MiseAjourUser(@Param("x")String nom, @Param("y")Boolean statut) ;     
	
	@Modifying
	@Query(nativeQuery=true,value="insert into users_roles values(:x,:y)")	
	public void affecterRole(@Param("x")String roles,@Param("y")String users) ;

	@Query("select u from User u where  (u.Nom like :x ) OR (u.Prenom like :x ) OR (u.Email like :x) OR (u.Fonction like :x) OR (u.site.Ville like :x)  ")   
	public Page<User> chercherUserMc(@Param("x")String motCle,  Pageable p);   
	
}
