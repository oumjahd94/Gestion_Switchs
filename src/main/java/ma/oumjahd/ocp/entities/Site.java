package ma.oumjahd.ocp.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection ;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany; 
@Entity
public class Site implements Serializable{  
	
	private static final long serialVersionUID = 1L;
	  @Id    
	   private String Ville;   
	   private String Url;   
	   
	   @OneToMany(mappedBy="site", fetch=FetchType.LAZY) 
	   private Collection<Batiment> batiment = new ArrayList<Batiment>(); // composition  
	   
	   @OneToMany(mappedBy ="site", fetch = FetchType.LAZY)
	   private Collection<User> user;     
	   
	public Site() {  
		super();
	}

	public Site(String ville, String url) {
		super();
		Ville = ville;
		Url = url;
	}


	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public Collection<Batiment> getBatiment() {
		return batiment;
	}

	public void setBatiment(Collection<Batiment> batiment) {
		this.batiment = batiment;
	}

	public Collection<User> getUser() {
		return user;
	}

	public void setUser(Collection<User> user) {
		this.user = user;
	}    
	
}
