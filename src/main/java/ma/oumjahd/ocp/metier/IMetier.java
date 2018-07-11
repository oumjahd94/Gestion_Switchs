package ma.oumjahd.ocp.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;

import ma.oumjahd.ocp.entities.Batiment;
import ma.oumjahd.ocp.entities.Commutateur;
import ma.oumjahd.ocp.entities.Connection;
import ma.oumjahd.ocp.entities.Event;
import ma.oumjahd.ocp.entities.EventId;
import ma.oumjahd.ocp.entities.Local_technique;
import ma.oumjahd.ocp.entities.Role;
import ma.oumjahd.ocp.entities.Site;
import ma.oumjahd.ocp.entities.User;
import ma.oumjahd.ocp.entities.Vlan;

public interface IMetier { 
	
	
	// le besion spécifié pour la gestion des utilisateurs 
     public User consulterUser(String nom) ;  
     public void ajouterUser(User user); 
     public void supprimerUser(String nom);   
     public void changerpwdUser(String nom, String nouvPwd);  
     public Page<User> listeUsers(int page, int size);   
     public List<User> collecUsers();
     public void UpdateUser(String nom, Boolean statut);    
     
     public Site FindSite(String ville);    
     public void ajouterSite(Site site);  
     public void supprimerSite(String ville);  
     public Page<Site> listeSites(int page, int size);   
     public Page<Site> listeSites(String mc,int page, int size);   

     public List<Site> collectionSites(); 
     public Long NbreUsers(String site);   
     public Long NbreBat(String site); 
     
     public void ajouterBatiment(Batiment b);   
     public void supprimerBatiment(String denom);   
     public Batiment TrouverBatiment(String denom);    
     public Page<Batiment> listeBatiments(int page, int size);     
     public Page<Batiment> listeBatimentsParMc(String mc,int page, int size);    

     public ArrayList<Batiment> collectionBatiments();  
     public Long NbreLocaux(String local) ; 
     
     public Long countSwitches(String locale) ; 
     public void ajouterLocal(Local_technique L);   
     public void supprimerLocal(String nom);   
     public Local_technique TrouverLocal(String nom);      
     public Page<Local_technique> listeLocaux(int page, int size);   
     public Collection<Local_technique> FindLocBat(String batiment);     
     public void LierdesLocaux(Connection conn);  
     public Long NbreConnLocaux(String locale) ;        
     public List<Local_technique> listeDesLocaux() ;    
  
     
     public Vlan FindVlan(String nom);    
     public void ajouterVlan(Vlan vlan);  
     public void supprimerVlan(String nom);  
     public Page<Vlan> listeVlans(int page, int size);   
     public List<Vlan> collectionVlans();     
     public  Long NbreAffectation(String vlan);   
     public Commutateur FindComm(String nom);
     
     public Commutateur FindSwitch(String serie);      
     public List<Commutateur> collectionSwitches();     
     public void ajouterSwitch(Commutateur sw);   
     public Page<Commutateur> listeSwich(int page, int size); 
     public Page<Commutateur> listeSwichParMC(String mc,int page, int size);  

     public void supprimerSwitch(String nom);   
     public void updateLocal(String serie, String local);   
     
     public Page<Event> listeEvent(int page, int size);      
     public Event FindEvent(String user, String sw); 
     public Event FindEventById(EventId id);  
     public void supprimerEvent(String user, String sw);    
     public void supprEventById(EventId id); 
     public void ajouterEvent(Event ev);  
     
     
     public void ajouterRole(Role r) ;  
     public void affectRoleUser(String role, String user);    
     public void stackerSwitches(String sw1, String sw2) ;  
     public void LierSwitches(String sw1, String sw2) ;
     public Page<Local_technique> listeLocauxParMc(String motCle, int page, int size);
	 public Page<Vlan> listeVlansParMc(String motCle, int page, int size);
	 public void affecterVlanBatim(String vlan, String batiment);
	 public Page<User> listeUsersParMc(String motCle, int page, int size);
	public Page<Event> listeEventParMc(String motCle, int page, int size);      

     
}
