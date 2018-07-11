package ma.oumjahd.ocp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;	
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;   

@Entity
 public class Commutateur implements Serializable{  
	
	private static final long serialVersionUID = 1L;
	@Id 
	   private String Serie;    
	
	   private String Nom;   
	   private String Marque;
	   private int NbrePorts;    
	   private String niveau ;  
	   @ManyToOne 
	   @JoinColumn(name="Locale")
	   private Local_technique localTechnique ;  
	   
	   @OneToMany(mappedBy = "pk.commutateur", fetch = FetchType.LAZY )
	   private 	Collection<Event> events = new ArrayList<Event>() ;  
	   
	   @ManyToMany
	   @JoinTable(name = "stacking", joinColumns = @JoinColumn(name = "switch_stk", referencedColumnName="Serie"),
               inverseJoinColumns = @JoinColumn(name = "switch_stk_voisin", referencedColumnName="Serie"))	  
	    private Collection<Commutateur> stacked ; 	  
	   
        @ManyToMany
	    @JoinTable(name = "Liaison", joinColumns = @JoinColumn(name = "switch", referencedColumnName="Serie"),
	                 inverseJoinColumns = @JoinColumn(name = "switch_voisin", referencedColumnName="Serie"))	  
	   private Collection<Commutateur> liaisons  ;           	   
	   
        
 	   @OneToMany(mappedBy ="Sw", fetch = FetchType.LAZY)
       private Collection<Vlan>  listeVlans ;  
 	   
	public Commutateur(String nom, String marque, String serie, int nbrePorts, Local_technique localTechnique,String niveau) {
		super();
		Nom = nom;
		Marque = marque;
		Serie = serie;
		NbrePorts = nbrePorts;
		this.localTechnique = localTechnique ;  
		this.niveau = niveau ; 
	}

   
	public Commutateur() {
		super();
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public String getMarque() {
		return Marque;
	}


	public void setMarque(String marque) {
		Marque = marque;
	}


	public String getSerie() {
		return Serie;
	}


	public void setSerie(String serie) {
		Serie = serie;
	}


	public int getNbrePorts() {
		return NbrePorts;
	}


	public void setNbrePorts(int nbrePorts) {
		NbrePorts = nbrePorts;
	}


	public Local_technique getLocalTechnique() {
		return localTechnique;
	}


	public void setLocalTechnique(Local_technique localTechnique) {
		this.localTechnique = localTechnique;
	}


	public String getNiveau() {
		return niveau;
	}


	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}   
	     
	   
}
