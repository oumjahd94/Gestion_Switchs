package ma.oumjahd.ocp.entities;
import java.io.Serializable;
import java.util.Collection ;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Vlan implements Serializable{   
	
	private static final long serialVersionUID = 1L;
	@Id 
	   private String Nom;  
 	   private int Niveau;    
	   @ManyToOne 
	   @JoinColumn(name="Switch")
 	   private Commutateur Sw ; 
 	   
 	   @ManyToMany( mappedBy = "vlan", fetch = FetchType.LAZY)
       private Collection<Batiment> listeBat ; 
 	   
       public Vlan() {
		super();
	}

	public Vlan(String nom, int niveau, Commutateur Sw) {
		super();
		Nom = nom;
		Niveau = niveau;    
		this.Sw = Sw ; 
	}    

	
	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public int getNiveau() {
		return Niveau;
	}


	public void setNiveau(int niveau) {
		Niveau = niveau;
	}


	public Collection<Batiment> getListeBat() {
		return listeBat;
	}


	public void setListeBat(Collection<Batiment> listeBat) {
		this.listeBat = listeBat;
	}

	public Commutateur getSw() {
		return Sw;
	}

	public void setSw(Commutateur sw) {
		Sw = sw;
	}

            

}
