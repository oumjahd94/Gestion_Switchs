package ma.oumjahd.ocp.security;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class SecurityController {   
	
	@RequestMapping(value="/login")
	public String login(){	 
		
		return "login";          	        
	}      
	
	/*
	  
	  	public String login(Model model,  String username){	   
		
				System.err.println(username);  
		        model.addAttribute("username",username) ;   
		        return "login";          	        
	}  
	  
	  
	  */
	@RequestMapping(value="/")
	public String acceuil(){     
		
		return "redirect:/switch";     		
	}           
/*		
	public void doPost(HttpServletRequest  req, HttpServletResponse res) { 
	              HttpSession session = req.getSession() ; 
        String userSession = (String) session.getAttribute("username");  
         System.err.println("++++++++++++"+userSession+"+++++++++++++++"); 
      }  */
	
	@RequestMapping(value="/403")     
	public String accesDenied(){		
		return "403";
	} 
	
}
