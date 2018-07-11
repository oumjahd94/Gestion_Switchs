package ma.oumjahd.ocp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.oumjahd.ocp.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
       
}
