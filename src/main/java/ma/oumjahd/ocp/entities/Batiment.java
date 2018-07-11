package ma.oumjahd.ocp.entities;
import java.io.Serializable;
import java.util.Collection ;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;  
@Entity
public class Batiment implements Serializable {  
	
	private static final long serialVersionUID = 1L;    
	@Id  
	   private String Denomination;   
	   private int NbreEtages;  
	  
	   @OneToMany(mappedBy="batiment", fetch=FetchType.LAZY) 
	   private Collection<Local_technique> local_technique;   
	   
	   @ManyToMany
	   @JoinTable(name = "VlanBatiment", joinColumns = @JoinColumn(name = "batiment", referencedColumnName="Denomination"),
	                 inverseJoinColumns = @JoinColumn(name = "vlan", referencedColumnName="Nom"))	    
	   private Collection<Vlan> vlan ;    
	   
	   @ManyToOne 
	   @JoinColumn(name="Site")
	   private Site site ;      
	   
	public Batiment() {
		super();
	} 

	public Batiment(String denomination,Site site, int NbreEtages) {
		super(); 
		Denomination = denomination;
		this.site = site; 
		this.NbreEtages = NbreEtages ; 
	}  
    

	public String getDenomination() {
		return Denomination;
	}


	public void setDenomination(String denomination) {
		Denomination = denomination;
	}


	public Collection<Local_technique> getLocal_technique() {
		return local_technique;
	}


	public void setLocal_technique(Collection<Local_technique> local_technique) {
		this.local_technique = local_technique;
	}


	public Collection<Vlan> getVlan() {
		return vlan;
	}


	public void setVlan(Collection<Vlan> vlan) {
		this.vlan = vlan;
	}


	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}

	public int getNbreEtages() {
		return NbreEtages;
	}

	public void setNbreEtages(int nbreEtages) {
		NbreEtages = nbreEtages;
	}   
	   
}
