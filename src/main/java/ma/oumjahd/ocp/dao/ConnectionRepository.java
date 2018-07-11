package ma.oumjahd.ocp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.oumjahd.ocp.entities.Connection;
import ma.oumjahd.ocp.entities.ConnectionId;

public interface ConnectionRepository extends JpaRepository<Connection, ConnectionId>{
    @Query("select count(conn) from Connection conn where conn.pk_conn.local_techniqueA.Nom =:x or conn.pk_conn.local_techniqueB.Nom =:x")
	public Long NbreConnections(@Param("x")String locale);    
  
}
