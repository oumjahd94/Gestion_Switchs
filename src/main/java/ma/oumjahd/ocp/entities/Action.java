package ma.oumjahd.ocp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Action {   
	@Id   @GeneratedValue
  private int IdAct ; 
  private String TypeAct ;   
  private Date date ; 
  @ManyToOne 
  @JoinColumn(name="id_user")
  private User user;

  public Action() {
	super();
} 

public Action(String typeAct, Date date, User user) {
	super();
	TypeAct = typeAct;
	this.date = date;
	this.user = user;
}

public int getIdAct() {
	return IdAct;
}

public void setIdAct(int idAct) {
	IdAct = idAct;
}

public String getTypeAct() {
	return TypeAct;
}

public void setTypeAct(String typeAct) {
	TypeAct = typeAct;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
} 
    
  
}
