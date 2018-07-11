package ma.oumjahd.ocp.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
@Embeddable
public class EventId implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	@ManyToOne
    private User user ;  
	@ManyToOne
	private  Commutateur commutateur;    
	
	
	public EventId() {
		super();
	}
	public EventId(User user, Commutateur commutateur) {
		super();
		this.user = user;
		this.commutateur = commutateur;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Commutateur getCommutateur() {
		return commutateur;
	}
	public void setCommutateur(Commutateur commutateur) {
		this.commutateur = commutateur;
	}  
	

}
