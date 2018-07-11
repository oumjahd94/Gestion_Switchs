package ma.oumjahd.ocp.entities;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
@AssociationOverrides({
		@AssociationOverride(name = "pk_conn.local_techniqueA",
			joinColumns = @JoinColumn(name = "localA")),
		@AssociationOverride(name = "pk_conn.local_techniqueB",
			joinColumns = @JoinColumn(name = "localB")) })
public class Connection implements Serializable {   
	
	private static final long serialVersionUID = 1L;

	@Id 
	   private ConnectionId pk_conn ;     
	   
	   private Double Distance;
	   private String Type;
	   private int Nbre_de_brins;   
 

	public Connection(Double distance, String type, int nbre_de_brins,ConnectionId pk_conn) {
		super();
		Distance = distance;
		Type = type;
		Nbre_de_brins = nbre_de_brins; 
		this.pk_conn = pk_conn ; 

	}
	

	public Double getDistance() {
		return Distance;
	}

	public Connection() {
		super();
	}


	public void setDistance(Double distance) {
		Distance = distance;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getNbre_de_brins() {
		return Nbre_de_brins;
	}

	public void setNbre_de_brins(int nbre_de_brins) {
		Nbre_de_brins = nbre_de_brins;
	}
	   
}
