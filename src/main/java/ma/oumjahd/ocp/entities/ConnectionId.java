package ma.oumjahd.ocp.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
@Embeddable
public class ConnectionId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@ManyToOne 
	   private  Local_technique local_techniqueA;         
	@ManyToOne  
	   private  Local_technique local_techniqueB;  
	
	
	public ConnectionId() {
		super();
	}
	public ConnectionId(Local_technique local_techniqueA, Local_technique local_techniqueB) {
		super();
		this.local_techniqueA = local_techniqueA;
		this.local_techniqueB = local_techniqueB;
	}
	public Local_technique getLocal_techniqueA() {
		return local_techniqueA;
	}
	public void setLocal_techniqueA(Local_technique local_techniqueA) {
		this.local_techniqueA = local_techniqueA;
	}
	public Local_technique getLocal_techniqueB() {  
		return local_techniqueB;
	}
	public void setLocal_techniqueB(Local_technique local_techniqueB) {
		this.local_techniqueB = local_techniqueB;
	}     
	
	

}
