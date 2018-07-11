 package ma.oumjahd.ocp.entities;
import java.io.Serializable;
import java.util.Collection ;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Local_technique implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	@Id 
	   private String Nom;    
	   private int Etage ; 
	   @OneToMany(mappedBy="localTechnique", fetch = FetchType.LAZY)
	   private Collection<Commutateur> commutateur;   
	   
	   @ManyToOne  
	   @JoinColumn(name="batiment")
	   private Batiment batiment ;     
	   
	   @OneToMany(mappedBy="pk_conn.local_techniqueA")
	   private Collection<Connection> conns ; 
	   
	public Local_technique(String nom,Batiment batiment, int Etage) {
		super();  
		Nom = nom;
		this.batiment = batiment; 
		this.Etage = Etage ; 
	}

	
	public Local_technique() {
		super();
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public Collection<Commutateur> getCommutateur() {
		return commutateur;
	}


	public void setCommutateur(Collection<Commutateur> commutateur) {
		this.commutateur = commutateur;
	}



	public Batiment getBatiment() {
		return batiment;
	}


	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}


	public int getEtage() {
		return Etage;
	}


	public void setEtage(int etage) {
		Etage = etage;
	}


}
