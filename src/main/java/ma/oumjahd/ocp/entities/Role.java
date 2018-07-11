package ma.oumjahd.ocp.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role implements Serializable{ 
	 @Id 
     private String Nom_Role ;     
	 
	 @ManyToMany
	 @JoinTable(name = "UsersRoles", joinColumns = @JoinColumn(name = "roles", referencedColumnName="Nom_Role"),
	                 inverseJoinColumns = @JoinColumn(name = "users", referencedColumnName="Nom"))	   
	 private Collection<User> users ; 

	public Role(String nom_Role) {
		super();
		Nom_Role = nom_Role;
	}

	public Role() {
		super();
 	}

	public String getNom_Role() {
		return Nom_Role;
	}

	public void setNom_Role(String nom_Role) {
		Nom_Role = nom_Role;
	}   
	 
	 
}
