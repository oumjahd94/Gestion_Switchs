package ma.oumjahd.ocp.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ma.oumjahd.ocp.entities.Batiment;
import ma.oumjahd.ocp.entities.Commutateur;
import ma.oumjahd.ocp.entities.Connection;
import ma.oumjahd.ocp.entities.ConnectionId;
import ma.oumjahd.ocp.entities.Event;
import ma.oumjahd.ocp.entities.EventId;
import ma.oumjahd.ocp.entities.Local_technique;
import ma.oumjahd.ocp.entities.Site;
import ma.oumjahd.ocp.entities.User;
import ma.oumjahd.ocp.entities.Vlan;
import ma.oumjahd.ocp.metier.IMetier;

@Controller
public class Controleur {  
   @Autowired
   private IMetier im ;    
     
   @RequestMapping("/user")
   public String index(){
	return "redirect:/listeUser";     	   
   }    
    
   @RequestMapping("/batiment")
   public String index2(){
	return "redirect:/listeBatiments";   	   
   }   
   
   @RequestMapping("/switch")
   public String index5(){
	return "redirect:/listeSwitches";    	   
   }   
   
   @RequestMapping("/site")
   public String index6(){
	return "redirect:/listeSites";   	   
   } 
   
   @RequestMapping("/local")
   public String index7(){
	return "redirect:/listeLocaux";   	   
   }
 
   @RequestMapping("/vlan")
   public String index9(){
	return "redirect:/listeVlans";    	   
   }  
   
   @RequestMapping("/inventaire")
   public String index10(){
	return "redirect:/listeEvents";    	     
   } 
   
	@RequestMapping("/listeUser")
   public String listeUser(Model model,String nomUser, String prenomUser, String motCle, 
		   String pwdUser,String emailUser, String telUser, String fctUser,
           String site, 
		   @RequestParam(name="page", defaultValue="0")int page,
			@RequestParam(name="size", defaultValue="6")int size
		   ){       
	  try {     
		  // charger la liste des sites  
   		  java.util.List<Site> collS = im.collectionSites() ; 
   		  model.addAttribute("collS", collS);   
   		  if(motCle ==null) motCle ="" ; 
	     Page<User> listeU = im.listeUsersParMc(motCle,page,size);      
	     
	     model.addAttribute("listeUsers",listeU.getContent()) ;  
	 	 int[] pages = new  int[listeU.getTotalPages()];
		 model.addAttribute("pages",pages);  
		 if(nomUser!=null){
			 if(prenomUser!=null){ 
				 // modification 
				    model.addAttribute("nomUser",nomUser);
					model.addAttribute("prenomUser",prenomUser);
					model.addAttribute("pwdUser",pwdUser); 
					model.addAttribute("emailUser",emailUser) ; 
					model.addAttribute("telUser",telUser); 
					model.addAttribute("fctUser",fctUser);  
					model.addAttribute("site",site);  
			 } 
			 else
			 {
				 // affi détails  
			     model.addAttribute("user",im.consulterUser(nomUser));  
			 }
			 
		 }
		 
	} catch (Exception e) {        
		model.addAttribute("Exception",e);            
	}   
	   return "user";         	   
   } 
   
   
	   @RequestMapping("/updateUser")
	   public String updateUser(Model model,String nomUser, Boolean etat){  

		   	  try {     
		   		   
			     im.UpdateUser(nomUser, etat);   

		     } catch (Exception e) {        
			   model.addAttribute("Exception",e);            
		     }   
		        return "redirect:/user";           	   
	  }  
	
   @RequestMapping("/ajouterUser")
   public String AjouterUser(Model model,String nomUser, String prenomUser,String pwdUser, 
		    String site, String emailUser, String telUser, String role, String fctUser){  
	   	  try {                	   		  
		  Site S  = im.FindSite(site);   
		  System.out.println("vérifier les infos de l'user ==+> nom : "+ nomUser +"\n role :"+ role);
	      im.ajouterUser(new User(nomUser, prenomUser,pwdUser,S,emailUser, telUser,fctUser));     
          im.affectRoleUser(role, nomUser);   

	     } catch (Exception e) {        
		   model.addAttribute("Exception",e);            
	     }   
	        return "redirect:/user";           	   
  }  
    
   
   
   @RequestMapping("/SupprUser")
   public String SupprUser(Model model,String nomUser ){  
	   	  try {         
		  im.supprimerUser(nomUser);
	} catch (Exception e) {        
		model.addAttribute("Exception",e);            
	}   
	   return "redirect:/user";           	   
   }   
 
   
   
   //manipulation des sites 
   
   @RequestMapping("/ajouterSite")
   public String ajouterSite(Model model,String ville, String url,
		   @RequestParam(name="page", defaultValue="0")int page,
			@RequestParam(name="size", defaultValue="4")int size){  
/*	    String[] t = {"Casablanca","Fes","Tanger","Marrakech",
				   "Salé","Meknès","Rabat","Témara","Agadir","	Oujda","Tétouan","Kénitra"}; 
		   List<String> listeVilles = (List) Arrays.asList(t);*/
	   	  try {        
	      im.ajouterSite(new Site(ville, url));   
/*	 	    model.addAttribute("listeVilles", listeVilles); 
*/	     } catch (Exception e) {        
		   model.addAttribute("Exception",e);            
	     }   
	        return "redirect:/listeSites";            	   
  }   
   
	@RequestMapping("/listeSites")
	   public String listeSites(Model model,String ville, String url, String motCle, 
			   @RequestParam(name="page", defaultValue="0")int page,
				@RequestParam(name="size", defaultValue="4")int size
			   ){       
		  try {     
			  // charger la liste des sites    
			 if(motCle == null) motCle ="" ;
			 Page<Site> listeS = im.listeSites(motCle, page, size)  ; 
			 model.addAttribute("listeS",listeS.getContent());     
		 	 int[] pages = new  int[listeS.getTotalPages()];
			 model.addAttribute("pages",pages);  
			 
			 if(ville!=null){
				 if(url!=null){
					 model.addAttribute("ville",ville);
					 model.addAttribute("url",url);   
				 }
				 else{  

					model.addAttribute("nbreBat", im.NbreBat(ville)) ; 
					model.addAttribute("nbreUsers", im.NbreUsers(ville)) ; 
				    model.addAttribute("site",im.FindSite(ville)) ; 
				    
				 }				
			 }
			 
		} catch (Exception e) {        
			model.addAttribute("Exception",e);            
		}   
		   return "site";         	   
	   }    
  
	   
	   
	   @RequestMapping("/SupprSite")
	   public String SupprSite(Model model,String ville ){  
		   	  try {         
			  im.supprimerSite(ville);  
		} catch (Exception e) {        
			model.addAttribute("Exception",e);            
		}   
		   return "redirect:/site";             	   
	   }    
	   
	   
	  // Manipulation de l'entité Batiment 
	   
	   @RequestMapping("/ajouterBatiment")
	   public String ajouterBatiment(Model model,String denom, String site){  
		   	  try {    		   	 
		      im.ajouterBatiment(new Batiment(denom, im.FindSite(site),10));  
		 	     
		     } catch (Exception e) {        
			   model.addAttribute("Exception",e);            
		     }   
		        return "redirect:/listeBatiments";            	   
	  }   
	   
		@RequestMapping("/listeBatiments")
		   public String listeBatiments(Model model,String denom, String site, String motCle, 
				   @RequestParam(name="page", defaultValue="0")int page, 
					@RequestParam(name="size", defaultValue="4")int size
				   ){         
			  try {   
				  
				  // remplir la liste des sites 
		   		  java.util.List<Site> collS = im.collectionSites() ; 
		   		  model.addAttribute("collS", collS);  
		   		  
				  // charger la liste des bâtiments  
		   		  if(motCle==null) motCle ="" ; 
				 Page<Batiment> listeB = im.listeBatimentsParMc(motCle, page, size); 		 
				 model.addAttribute("listeB",listeB.getContent());    			 
			 	 int[] pages = new  int[listeB.getTotalPages()];
				 model.addAttribute("pages",pages);   
				 
				 if(denom!=null){
					 
					 if(site!=null){
						 // modification 
					   		model.addAttribute("denom",denom);
							model.addAttribute("site",site); 
					 }
					 else{ 
						 // éditer  
						 model.addAttribute("nbreLoc", im.NbreLocaux(denom)) ; 
					     model.addAttribute("batiment",im.TrouverBatiment(denom));       
						 
					 }
				 }
			} catch (Exception e) {        
				model.addAttribute("Exception",e);            
			}   
			   return "batiment";         	   
		   }    
		   
		   @RequestMapping("/SupprBatiment")
		   public String SupprBatiment(Model model,String denomination){  
			   	  try {         
				  im.supprimerBatiment(denomination);  
			} catch (Exception e) {        
				model.addAttribute("Exception",e);            
			}   
			   return "redirect:/batiment";             	   
		   }    
		   
// Manipulation des locaux techniques 
		   
		   @RequestMapping("/ajouterLocal")
		   public String ajouterLocal(Model model,String nom, String batiment, int etage){  
			   	  try {    		  
			      im.ajouterLocal(new Local_technique(nom, im.TrouverBatiment(batiment),etage));			 	     
			     } catch (Exception e) {        
				   model.addAttribute("Exception",e);            
			     }   
			        return "redirect:/listeLocaux";            	   
		  }   
		   
			@RequestMapping("/listeLocaux")
			   public String listeLocaux(Model model,String nom, String batiment, Long etage, String motCle, 
					   @RequestParam(name="page", defaultValue="0")int page,
						@RequestParam(name="size", defaultValue="4")int size
					   ){         
				  try {   
					      if(motCle == null) motCle="" ; 
					     ArrayList<Batiment> collBat = im.collectionBatiments() ; 
			   		     model.addAttribute("collBat", collBat);     
			   		     
			   			 Page<Local_technique> listeLoc = im.listeLocauxParMc(motCle,page, size); 
						 model.addAttribute("listeLoc", listeLoc.getContent()) ; 
					 	 int[] pages = new  int[listeLoc.getTotalPages()];    
						 model.addAttribute("pages",pages);     
						 
						 // à traiter plutard ! 
				      //  ArrayList<Local_technique> collecLocaux = (ArrayList<Local_technique>) im.FindLocBat(batiment);  
						 ArrayList<Local_technique> collecLocaux = (ArrayList<Local_technique>) im.listeDesLocaux(); 
			   		    model.addAttribute("collecLocaux", collecLocaux);  
			   		    
			   		     if(nom!=null){			 
			   		    	 if(batiment!=null){
			   		  // pour la modif 
				   		model.addAttribute("nom",nom);
						model.addAttribute("batiment",batiment); 
						model.addAttribute("etage",etage); 		 
			   		    	 }	   		     
					// détails locaux  
			   		    	 else{		   		  
				   		  Long nbre = im.countSwitches(nom) ;  
				   		  model.addAttribute("nbre",nbre);       
				   		  Long nbreConn = im.NbreConnLocaux(nom) ;   
				   		  model.addAttribute("nbreConn",nbreConn);         
					     model.addAttribute("local",im.TrouverLocal(nom));  
					     
			   		     }  }   
			 
				} catch (Exception e) {        
					model.addAttribute("Exception",e);            
				}   
				   return "local";         	   
			   }    
			
			   
			   
			   @RequestMapping("/SupprLocal")
			   public String SupprLocal(Model model,String nom){  
				   	  try {         
					  im.supprimerLocal(nom);  
				} catch (Exception e) {        
					model.addAttribute("Exception",e);            
				}   
				   return "redirect:/local";             	   
			   }    	  
    
			   
			   @RequestMapping("/LierLocaux")
			   public String LierLocaux(Model model,String locale1, String locale2,double dist, 
					   String liaison, int brins){  

				   	  try {         
				   		  
				   		  ConnectionId conId = new ConnectionId(im.TrouverLocal(locale1) , im.TrouverLocal(locale2)) ; 
				   		  im.LierdesLocaux(new Connection(dist, liaison, brins, conId));    
				   		  
				     } catch (Exception e) {        
					   model.addAttribute("Exception",e);            
				     }   
				        return "redirect:/local";           	   
			  }  
			   
			   
			   //déplacer un switch   
			   
			   @RequestMapping("/deplacerSW")  
			   public String depSW(Model model,String serie, String localeSW){         
				  try {
					  im.ajouterEvent(new Event(new EventId(im.consulterUser("oumjahd"), im.FindSwitch(serie)), new Date(), "déplacer switch"));
		   		      im.updateLocal(serie,localeSW);	              

				} catch (Exception e) {
					model.addAttribute("Exception",e);  		  
					} 
				  return "redirect:/listeSwitches";      		
			}
			   
	// Manipulation des vlans  
			   
			   @RequestMapping("/listeSwitches")  
			   public String listeSwitches(Model model,String serie, String nom, String marque, Long nbreport,
					   String niveau, String locale, String deplacer, String  local, String motCle, 
					   @RequestParam(name="page", defaultValue="0")int page,
						@RequestParam(name="size", defaultValue="4")int size
					   ){         
				  try {   
					    // charger la page des switches  			   		  
			   			// Page<Commutateur> listeSw = im.listeSwich(page, size);   
					  if(motCle==null) motCle="" ; 
			   			 Page<Commutateur> listeSw = im.listeSwichParMC(motCle, page, size) ; 
						 model.addAttribute("listeSw", listeSw.getContent()) ;  
					 	 int[] pages = new  int[listeSw.getTotalPages()];    
						 model.addAttribute("pages",pages);  
						 
						 // remplir liste des locaux techniques 
						 List<Local_technique> collecLocaux = im.listeDesLocaux();  
			   		     model.addAttribute("collecLocaux", collecLocaux);  
			   		    
			   		     // remplir la liste des switches 
			   		     List<Commutateur> collSwitches = im.collectionSwitches() ; 
			   		     model.addAttribute("collSwitches",collSwitches) ; 
			   		     
			   		     if(serie !=null){			 
			   		    	 if(marque!=null){  
			   		  // pour changer le switch 

			     		model.addAttribute("serie",serie);	   		   		    		 
				   		model.addAttribute("nom",nom);
						model.addAttribute("marque",marque);  
						model.addAttribute("nbreport",nbreport);  
						model.addAttribute("niveau",niveau); 		 
						model.addAttribute("locale",locale);    
						
					   im.ajouterEvent(new Event(new EventId(im.consulterUser("oumjahd"), im.FindSwitch(serie)), new Date(), "changer switch"));

			   		    		   		    	 
			   		    }else if(deplacer !=null){  

			   		    		 // faire le déplacement !   
			   		    		 try {  
			   		   			/*im.ajouterEvent(new Event(new EventId(im.consulterUser("oumjahd"), im.FindSwitch(serie)), new Date(), "déplacer switch"));
	                           System.out.println("la valuer de local est: "+local); 
				   		    	im.updateLocal(serie,local);*/	 
			   		    			 model.addAttribute("dp",im.FindSwitch(serie));   
                                   // System.out.println(serie); 
								} catch (Exception e) { 
									e.printStackTrace();   
								}
			   		    		
			   		    	 }	   		     
					// détails des switches   
			   		    	 else{	  
					             model.addAttribute("swit",im.FindSwitch(serie));   
					     
			   		     }  }   
			 
				} catch (Exception e) {        
					model.addAttribute("Exception",e);            
				}   
				   return "switch";         	   
			   } 	   
			   
			  /* 
			   @RequestMapping("/deplacerSwitch")
			   public String deplacerSwitch(Model model, String serie, String local){     
				  if(local!=null){
	   		       im.updateLocal(serie,local);
	   		       }
				  else{ 
					  String dep = "active" ; 
				      model.addAttribute("deplacer",dep) ;  
				  }
				  
				  
			        return "redirect:/listeSwitches";             	   

			   }	*/	   
			   
   // Manipulation des events   
			   
			   
			   
			   @RequestMapping("/stackerSwitches")
			   public String stkSwitches(Model model,String sw1,String sw2, String stk, String lier){  
				   	  try {    		 
				   		  if(stk!=null)
				   			  im.stackerSwitches(sw1, sw2);  
				   		  
				   		  else  
				   			  im.LierSwitches(sw1, sw2);     
				   			  
				     } catch (Exception e) {        
					   model.addAttribute("Exception",e);             
				     }   
				        return "redirect:/listeSwitches";              	   
			  }    
			   
			   
			   
			   @RequestMapping("/AffecterVlan")
			   public String AffecterVlanBatiment(Model model,String batiment, String vlan){  
				   	  try {    		 				   		 
				   			  im.affecterVlanBatim(batiment, vlan);  
				   		    				   			  
				     } catch (Exception e) {        
					   model.addAttribute("Exception",e);             
				     }   
				        return "redirect:/listeVlans";               	   
			  }
	
			   @RequestMapping("/listeVlans")
			   public String listeVlans(Model model,String nom, Long niveau, String commutateur, String motCle, 
					   @RequestParam(name="page", defaultValue="0")int page,
						@RequestParam(name="size", defaultValue="4")int size
					   ){         
				  try {   
					  
					     List<Vlan> collVlan = im.collectionVlans();  
			   		     model.addAttribute("collVlan", collVlan);    
			   		     
					     ArrayList<Batiment> collBat = im.collectionBatiments() ; 
			   		     model.addAttribute("collBat", collBat);  
			   		     
			   		     List<Commutateur> collSwitches = im.collectionSwitches() ; 
			   		     model.addAttribute("collSwitches",collSwitches) ;  
			   		     
			   		     // récupérer la page des vlans 
			   			// Page<Vlan> listeVlan = im.listeVlans(page, size);  
			   		  if(motCle==null) motCle="" ; 
			   		  Page<Vlan> listeVlan = im.listeVlansParMc(motCle,page, size);
						 model.addAttribute("listeVlan", listeVlan.getContent()) ;   					 
					 	 int[] pages = new  int[listeVlan.getTotalPages()];
						 model.addAttribute("pages",pages);      
   		    
			   		     if(nom!=null){			 
			   		    	 if(niveau!= null){
			   		  // pour la modif 
				   		model.addAttribute("nom",nom);
						model.addAttribute("niveau",niveau); 
						model.addAttribute("commutateur",commutateur); 		 
			   		    	 }	   		     
					// détails locaux  
			   		    	 else{		   		  
				   		/*  Long nbre = im.countSwitches(nom) ;  
				   		  model.addAttribute("nbre",nbre);  */            
					      model.addAttribute("sw",im.FindVlan(nom));    
					     
			   		     }  }   
			 
				} catch (Exception e) {        
					model.addAttribute("Exception",e);            
				}   
				   return "vlan";         	   
			   }     
			   
			   @RequestMapping("/ajouterVlan")
			   public String ajouterVlan(Model model,String nom, int niveau, String commutateur){   
				   	  try {    
						
				      im.ajouterVlan(new Vlan(nom, niveau, im.FindComm(commutateur)));			 	     
				     } catch (Exception e) {        
					   model.addAttribute("Exception",e);             
				     }   
				        return "redirect:/listeVlans";            	   
			  }  
			   
			   @RequestMapping("/SupprVlan")
			   public String SupprVlan(Model model,String nom){  
				   	  try {         
					  im.supprimerVlan(nom);    
				} catch (Exception e) {        
					model.addAttribute("Exception",e);            
				}   
				   return "redirect:/vlan";             	   
			   }     
			   
			   
			   @RequestMapping("/ajouterSwitch")
			   public String ajouterSwitch(Model model,String serie, String nom, String marque, int nbreport,
					   String niveau, String locale){  
				   	  try {    		  
				   	 im.ajouterSwitch(new Commutateur(nom, marque, serie, nbreport, im.TrouverLocal(locale), niveau));  
				   	 
				   	 im.ajouterEvent(new Event(new EventId(im.consulterUser("oumjahd"), im.FindSwitch(serie)), new Date(), "ajouter switch"));
				   	  } catch (Exception e) {        
					   model.addAttribute("Exception",e);            
				     }   
				        return "redirect:/listeSwitches";             	   
			  }  
			    
			   
			   @RequestMapping("/SupprSwitch")
			   public String SupprSwitch(Model model,String serie){    
                 
				   	  try {  
				   	 // im.ajouterEvent(new Event(new EventId(im.consulterUser("oumjahd"), im.FindSwitch(serie)), new Date(), "supprimer switch"));
					  im.supprimerSwitch(serie);         

				} catch (Exception e) {          
					model.addAttribute("Exception",e);                
				}   
				   return "redirect:/listeSwitches";                	   
			   }  
			   
			   // Manipulation des events   
			    
				   
			   @RequestMapping("/listeEvents")  
			   public String listeEvents(Model model, String sw, String user, String motCle,  
					   @RequestParam(name="page", defaultValue="0")int page,
						@RequestParam(name="size", defaultValue="10")int size
					   ){         
				  try {   
				      if(motCle == null)  
				    	  motCle ="" ;  		  
			   			 Page<Event> listeEv = im.listeEventParMc(motCle,page, size);     
			   			 System.out.println("++++++++++++suis-je là+++++++++++");
					   
						 model.addAttribute("listeEv", listeEv.getContent()) ;  
					 	 int[] pages = new  int[listeEv.getTotalPages()];    
						 model.addAttribute("pages",pages);         
			   		     
			   		     if(sw!=null){ 
			   		    	 
							  Event ev = im.FindEvent(user, sw) ; 
						      model.addAttribute("editer",ev);       
			   		 
			   		     }   
			 
				} catch (Exception e) {        
					model.addAttribute("Exception",e);            
				}   
				   return "inventaire";         	   
			   }         
			   
			   
			   @RequestMapping("/SupprEvent")
			   public String SupprEvent(Model model,String sw, String user){    
                 
				   	  try {      
					  im.supprimerEvent(user, sw);             

				} catch (Exception e) {          
					model.addAttribute("Exception",e);                
				}   
				   return "redirect:/inventaire";                  	   
			   }  
			   
     	   
}  
