package ma.oumjahd.ocp.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	   @Id 
	   private String Nom; 
	   
	   private String Prenom;
	   private String Mdp;
	   private String Email ; 
	   private String Tel ; 
	   private String Fonction ;  
	   private Boolean Statut= true;      
	   
	   @ManyToMany( mappedBy = "users", fetch = FetchType.LAZY)   
	   private Collection<Role>roles ;      
	   
	   @ManyToOne      
	   @JoinColumn(name="Site")    
	   private Site site ;       
	   
	   @OneToMany( mappedBy = "pk.user", fetch = FetchType.LAZY)  
	   private 	Collection<Event> events ;  
	   
	   @OneToMany(mappedBy="user",fetch = FetchType.LAZY )  
	   private Collection<Action> actions ;   
	   
      public User() {
		super();
	  } 


	public User(String nom, String prenom, String mdp, Site site,
			String email, String tel, String fonction) {
		super();
		Nom = nom;
		Prenom = prenom;
		Mdp = mdp;
		Email = email;
		Tel = tel;
		Fonction = fonction;
		this.site = site;
	}


	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getMdp() {
		return Mdp;
	}

	public void setMdp(String mdp) {
		Mdp = mdp;
	}


	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getFonction() {
		return Fonction;
	}

	public void setFonction(String fonction) {
		Fonction = fonction;
	}

	public Boolean getStatut() {
		return Statut;
	}

	public void setStatut(Boolean statut) {
		Statut = statut;
	}	    
	
	
	  
}
