	
package ma.oumjahd.ocp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
import ma.oumjahd.ocp.entities.ConnectionId;
import ma.oumjahd.ocp.entities.Event;
import ma.oumjahd.ocp.entities.EventId;
import ma.oumjahd.ocp.entities.Local_technique;
import ma.oumjahd.ocp.entities.Role;
import ma.oumjahd.ocp.entities.Site;
import ma.oumjahd.ocp.entities.User;
import ma.oumjahd.ocp.entities.Vlan;
import ma.oumjahd.ocp.metier.IMetier;
import ma.oumjahd.ocp.metier.IMetierImpl;

@SpringBootApplication
public class OcpSwitchManagementApplication implements CommandLineRunner{    
	
  @Autowired	
  private UserRepository  userRepository ;  	
  @Autowired	
  private BatimentRepository batimentRepositor ;
  @Autowired		
  private LocalTechniqueRepository localTechniqueRepository ;  
  @Autowired	
  private VlanRepository vlanRepository ;  
  @Autowired	
  private CommutateurRepository commutateurRepository ;  
  @Autowired	
  private SiteRepository siteRepository ;   
  @Autowired	
  private EventRepository eventRepository ;  
  @Autowired	
  private ConnectionRepository connectionRepository ;    
  @Autowired	
  private RoleRepository roleRepository ; 
  
  
  public static void main(String[] args) {
		SpringApplication.run(OcpSwitchManagementApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// insertion des données 
/*		
		Site s1 = siteRepository.save(new Site("Jorf Lasfer", "www.ocp.ma/Jorf_Lasfer")) ; 
		Site s2 = siteRepository.save(new Site("Boukraa", "www.ocp.ma/boukraa")) ;  
		Site s3 = siteRepository.save(new Site("Khribga", "www.ocp.ma/boukraa")) ;    
		 
		User u1 = userRepository.save(new User("oumjahd", "med", "aksachli",  s1,"oumj@outlook.fr","0612594875","chef de projet"));  
		User u2 = userRepository.save(new User("alaoui", "sami", "5555",  s2, "alaoui@outlook.fr", "0645168726","developpeur")) ; 
		User u3 = userRepository.save(new User("saadi", "karima", "1245", s3, "saadi@outlook.fr", "0648795621", "technicien")) ;  
		User u4 = userRepository.save(new User("samadi", "hadi", "1234",  s3,"samadi@outlook.fr", "0612558794","developpeur")) ;  
		User u5 = userRepository.save(new User("ghyti", "mostafa", "789",  s1,"ghyti@outlook.fr","0644896136", "developpeur")) ;  
		User u6 = userRepository.save(new User("bnnani", "hamid", "456",  s2, "bnnani@outlook.fr","0614669857", "technicien")) ;   
			
					
		Batiment b1 = batimentRepositor.save(new Batiment("batîment1", s1,6)); 
		Batiment b2 = batimentRepositor.save(new Batiment("batîment2", s1,7)); 
		Batiment b3 = batimentRepositor.save(new Batiment("batîment3", s2,10)); 
		Batiment b4 = batimentRepositor.save(new Batiment("batîment4", s2,4));   
		Batiment b5 = batimentRepositor.save(new Batiment("batîment5", s3,6)); 
		Batiment b6 = batimentRepositor.save(new Batiment("batîment6", s3,4));   
		
		Local_technique lt1 = localTechniqueRepository.save(new Local_technique("local1", b1,2)) ; 
		Local_technique lt2= localTechniqueRepository.save(new Local_technique("local2", b1,1)) ; 
		Local_technique lt3 = localTechniqueRepository.save(new Local_technique("local3", b4,3)) ;   
		
		ConnectionId connId= new ConnectionId(lt1, lt2) ;
        Connection c1 = connectionRepository.save(new Connection(123.0, "cable", 20, connId)) ; 
       
		Commutateur sw1 = commutateurRepository.save(new Commutateur("switch1", "Nouvmarque", "1234GGF", 24, lt1,"superieur")); 
		Commutateur sw2 = commutateurRepository.save(new Commutateur("switch2", "Model1", "4526FKK", 24, lt1,"bas")); 
		Commutateur sw3 = commutateurRepository.save(new Commutateur("switch3", "Model2", "8845QDSER", 24, lt2,"moyen")); 
		Commutateur sw4 = commutateurRepository.save(new Commutateur("switch4", "Model3", "1002FHKE", 24, lt3,"bas"));   
		
		Vlan vlan1 = vlanRepository.save(new Vlan("vlan1", 1, sw1)), 
				vlan2  = vlanRepository.save(new Vlan("vlan2", 2, sw2)), 
	            vlan3  = vlanRepository.save(new Vlan("vlan3", 1,sw1)),
			    vlan4  = vlanRepository.save(new Vlan("vlan4", 3, sw3));  
		
		EventId evId = new EventId(u4, sw3);  
		Event event1 = eventRepository.save(new Event(evId,new Date(), "ajout d'un swich")) ;  
		*/
		// tester la couche métier  
	/*	Site s4 = siteRepository.save(new Site("Laayoune", "www.ocp.ma/laayoune")) ;    
		User user = new User("polate", "alemdar", "abiii", "Guest", s4) ;
		iMetierImpl.ajouterUser(user);      
		*/  
		/*User u = iMetierImpl.consulterUser("hghgj");   
		System.out.println("Prenom : "+u.getPrenom()+" Type de l'utilisateur : "+u.getType()); */ 
	    /*Collection<User> listeU = userRepository.findAll() ;
		for(User u : listeU) 
				System.out.println("nom  "+u.getNom()+" Prenom "+u.getPrenom());   */    
		
/*		Event event11 = eventRepository.save(new Event(new EventId(u6, sw1),new Date(), "deplacer switch")) ; 
		Event event2 = eventRepository.save(new Event(new EventId(u2, sw3),new Date(), "changer switch")) ;
		Event event3 = eventRepository.save(new Event(new EventId(u1, sw2),new Date(), "ajout de switch")) ;
		Event event4 = eventRepository.save(new Event(new EventId(u4, sw4),new Date(), "suppr de switch")) ;
   
	    IMetierImpl im = new IMetierImpl() ; 	*/        
	    
	    

	/*	try {
	    Event ev = im.FindEvent("oumjahd", "switch2");    
      } catch (Exception e) { 
	      e.printStackTrace();   
      }*/ 
	/*	try {
			    Event ev = eventRepository.findOne(
        		new EventId(userRepository.findOne("oumjahd"),
        				commutateurRepository.findOne("switch2")));  
        
        System.out.println("Type de cet event est : "+ ev.getTypeEvent());   
		} catch (Exception e) { 
			e.printStackTrace();
   		} */      
/*		
      roleRepository.save(new Role("ADMIN")) ; 
      roleRepository.save(new Role("GUEST")) ;    */      
		    
		
}    
	
}   
