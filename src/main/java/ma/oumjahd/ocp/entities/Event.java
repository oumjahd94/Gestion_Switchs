package ma.oumjahd.ocp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn; 

@Entity 
@AssociationOverrides({
		@AssociationOverride(name = "pk.commutateur",
			joinColumns = @JoinColumn(name = "NomSw")),
		@AssociationOverride(name = "pk.user",
			joinColumns = @JoinColumn(name = "NomUser")) })  

public class Event implements Serializable {     
	  
	private static final long serialVersionUID = 1L;
	@Id
       private EventId pk;    	
	   private Date date;      
	   private String TypeEvent ;  
	   
	   
	   
	public Event() {
		super();   
	}

	public Event( EventId pk, Date date, String TypeEvent) {
		super();  
        this.pk = pk ; 
		this.date = date; 
		this.TypeEvent = TypeEvent ; 
	} 
	
	public EventId getPk() {
		return pk;
	}

	public void setPk(EventId pk) {
		this.pk = pk;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTypeEvent() {
		return TypeEvent;
	}

	public void setTypeEvent(String typeEvent) {
		TypeEvent = typeEvent;
	}   
	   
}
