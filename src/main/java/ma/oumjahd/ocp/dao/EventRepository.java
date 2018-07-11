package ma.oumjahd.ocp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.oumjahd.ocp.entities.Event;
import ma.oumjahd.ocp.entities.EventId;

public interface EventRepository extends JpaRepository<Event, EventId>{

	
	@Query("select e from Event e where  (e.pk.user.Nom like :x ) OR (e.pk.commutateur.Nom like :x ) OR (e.TypeEvent like :x) OR (e.date like :x)  ")   
	Page<Event> chercherEventMc(@Param("x")String motCle, Pageable p);  
   
}
