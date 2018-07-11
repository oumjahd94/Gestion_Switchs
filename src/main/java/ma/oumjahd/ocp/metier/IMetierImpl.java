package ma.oumjahd.ocp.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.oumjahd.ocp.dao.BatimentRepository;
import ma.oumjahd.ocp.dao.CommutateurRepository;
import ma.oumjahd.ocp.dao.ConnectionRepository;
import ma.oumjahd.ocp.dao.EventRepository;
import ma.oumjahd.ocp.dao.LocalTechniqueRepository;
import ma.oumjahd.ocp.dao.RoleRepository;
import ma.oumjahd.ocp.dao.SiteRepository;
import ma.oumjahd.ocp.dao.UserRepository;
import ma.oumjahd.ocp.dao.VlanRepository;
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

@Service //implémenter la classe au démarrage de l'app par spring 
@Transactional // pour gérer les transactions      
//soit les opérations s'exécutent d'un seu coup soit j'annule le tout 

public class IMetierImpl implements IMetier{ 
	
  @Autowired // pour faire l'injection des dépendances  
	private UserRepository userRepository ;     
  @Autowired 
   private SiteRepository siteRepository ; 
  @Autowired 
  private BatimentRepository  batimentRepository ;  
  
  @Autowired 
  private LocalTechniqueRepository  localTechniqueRepository ; 
  
  @Autowired 
  private ConnectionRepository   connectionRepository; 
 
  @Autowired 
  private CommutateurRepository   commutateurRepository;   
  
  @Autowired 
  private VlanRepository  vlanRepository;  
  
  @Autowired 
  private EventRepository  eventRepository;  
  
  @Autowired
  private RoleRepository roleRepository ; 

  
	@Override
	public User consulterUser(String nom) {   
		return userRepository.findOne(nom) ; 
	}	

	@Override
	public void ajouterUser(User user) {
	 userRepository.save(user); 
	}

	@Override
	public void supprimerUser(String nom) {
		User user = userRepository
				.findOne(nom) ;  
		userRepository.delete(user);
		
	}	

	@Override
	public void changerpwdUser(String nom, String nouvPwd) {
		User user = consulterUser(nom);  
		user.setMdp(nouvPwd);    
	}

	@Override
	public Page<User> listeUsers(int page, int size) {
		return userRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public Site FindSite(String ville) {
		return siteRepository.findOne(ville);   
	}

	@Override
	public void ajouterSite(Site site) {
        siteRepository.save(site); 	
	}

	@Override
	public void supprimerSite(String ville) {  
		
		siteRepository.delete(FindSite(ville)); 
		
	}


	@Override
	public Page<Site> listeSites(int page, int size) { 		
		return siteRepository.findAll(new PageRequest(page, size));  
	}

	@Override
	public void ajouterBatiment(Batiment b) {
	     batimentRepository.save(b) ; 
	} 
	
@Override
	public Batiment TrouverBatiment(String denom) {
 		return batimentRepository.findOne(denom);  
	} 

	@Override
	public void supprimerBatiment(String denom) {
     batimentRepository.delete(TrouverBatiment(denom));	   
	}


	@Override
	public Page<Batiment> listeBatiments(int page, int size) {
		return batimentRepository.findAll(new PageRequest(page, size));  
	}

	@Override
	public List<Site> collectionSites() {	
		return siteRepository.findAll();
	}

	@Override
	public void ajouterLocal(Local_technique L) {
	     localTechniqueRepository.save(L); 
		
	}

	@Override
	public void supprimerLocal(String nom) {
       	localTechniqueRepository.delete(TrouverLocal(nom));
	}

	@Override
	public Local_technique TrouverLocal(String nom) {
		return localTechniqueRepository.findOne(nom);
	}

	@Override
	public Page<Local_technique> listeLocaux(int page, int size) {
		return localTechniqueRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public ArrayList<Batiment> collectionBatiments() {
		return (ArrayList<Batiment>) batimentRepository.findAll();   
	}

	@Override
	public Long countSwitches(String locale) {	
		return batimentRepository.NombreDeSwotches(locale) ;
	}

	@Override
	public Collection<Local_technique> FindLocBat(String batiment) {
		
		return localTechniqueRepository.ListelocauxParBatim(batiment);   
	}

	@Override
	public void LierdesLocaux(Connection conn) {
		connectionRepository.save(conn) ; 		
	}

	@Override
	public Long NbreConnLocaux(String locale) {
		return connectionRepository.NbreConnections(locale);
	}

	@Override
	public Vlan FindVlan(String nom) {
		return vlanRepository.findOne(nom);
	}

	@Override
	public void ajouterVlan(Vlan vlan) {
      vlanRepository.save(vlan); 	
	}

	@Override
	public void supprimerVlan(String nom) {
       vlanRepository.delete(FindVlan(nom));	    	
	}

	@Override
	public Page<Vlan> listeVlans(int page, int size) {
		return vlanRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public List<Vlan> collectionVlans() {
		return vlanRepository.findAll();   
	}

	@Override
	public Long NbreAffectation(String vlan) {
		
		return null ;/*vlanRepository.NbreBatimAffecte(vlan)*/   
	}

	@Override
	public Commutateur FindSwitch(String serie) { 

		return commutateurRepository.findOne(serie);    
	}

	@Override
	public List<Commutateur> collectionSwitches() {
	
		return commutateurRepository.findAll();
	}

	@Override
	public void ajouterSwitch(Commutateur sw) {
       commutateurRepository.save(sw); 	
	}

	@Override
	public Page<Commutateur> listeSwich(int page, int size) {
		return commutateurRepository.findAll(new PageRequest(page, size));   
	}

	@Override
	public void supprimerSwitch(String serie) {   
			      commutateurRepository.delete(FindSwitch(serie));      
	}

	@Override
	public List<Local_technique> listeDesLocaux() {

		return localTechniqueRepository.findAll();   
	}

	@Override
	public Page<Event> listeEvent(int page, int size) {
		return eventRepository.findAll(new PageRequest(page, size));  
	}

	@Override
	public Event FindEvent(String user, String sw) {  
		
		EventId evId = new EventId(consulterUser(user), FindSwitch(sw)) ; 
		return eventRepository.findOne(evId);      
	}

	@Override
	public void supprimerEvent(String user, String sw) {
		  eventRepository.delete(FindEvent(user, sw));   
	}

	@Override
	public List<User> collecUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public void supprEventById(EventId id) {
	      eventRepository.delete(FindEventById(id));	    
	}

	@Override
	public Event FindEventById(EventId id) {
		return eventRepository.findOne(id);    
	}

	@Override
	public void ajouterEvent(Event ev) {
	   eventRepository.save(ev);    
	}

	@Override
	public void UpdateUser(String nom, Boolean statut) {  
		try {
			       	userRepository.MiseAjourUser(nom, statut);  

		} catch (Exception e) {  
			e.printStackTrace();
		}
	}

	@Override
	public Long NbreUsers(String site) {
		
		return siteRepository.nbreUserSite(site);
	}

	@Override
	public Long NbreBat(String site) {
		return siteRepository.nbreBatimentSite(site);
	}

	@Override
	public Long NbreLocaux(String local) {
		
		return batimentRepository.nbreLocalBat(local);  
	}

	@Override
	public Commutateur FindComm(String nom) {
		return commutateurRepository.FindSwitchByName(nom);     
	}

	@Override
	public void updateLocal(String serie, String local) {
		commutateurRepository.ChangerLocalSwitch(serie, local); 
	}

	@Override
	public void ajouterRole(Role r) {
           	roleRepository.save(r)	; 
	}

	@Override
	public void affectRoleUser(String role, String user) {
		userRepository.affecterRole(role, user);
	}

	@Override
	public void stackerSwitches(String sw1, String sw2) {  
		try {
			 commutateurRepository.StackerSwitches(sw1, sw2);
		} catch (Exception e) { 
			e.printStackTrace();  
   		}
	}

	@Override
	public void LierSwitches(String sw1, String sw2) {
		commutateurRepository.LiserSwitches(sw1, sw2);
	}

	@Override
	public Page<Commutateur> listeSwichParMC(String mc, int page, int size) {
		
		return commutateurRepository.chercher("%" + mc + "%", new PageRequest(page, size)) ;  
	}

	@Override
	public Page<Site> listeSites(String mc, int page, int size) {
		return siteRepository.chercherSiteMc("%" + mc + "%", new PageRequest(page, size)) ;  
		
	}

	@Override
	public Page<Batiment> listeBatimentsParMc(String mc, int page, int size) {		
		return batimentRepository.chercherBatimentMc("%" + mc + "%", new PageRequest(page, size)) ;  
	}

	@Override
	public Page<Local_technique> listeLocauxParMc(String mc, int page, int size) {
		return localTechniqueRepository.chercherLocalMc("%" + mc + "%", new PageRequest(page, size)) ;  
	}

	@Override
	public Page<Vlan> listeVlansParMc(String mc, int page, int size) {
		
		 		return vlanRepository.chercherVlanMc("%" + mc + "%", new PageRequest(page, size)) ;  

	}

	@Override
	public void affecterVlanBatim(String batiment, String vlan) { 
		
		 batimentRepository.affecterVlaNBatiment(batiment, vlan); 	
	}

	@Override
	public Page<User> listeUsersParMc(String mc, int page, int size) {
		
 		return userRepository.chercherUserMc("%" + mc + "%", new PageRequest(page, size)) ;  
	}

	@Override
	public Page<Event> listeEventParMc(String mc, int page, int size) {
		
 		return eventRepository.chercherEventMc("%" + mc + "%", new PageRequest(page, size)) ;  
	} 
	

}
