function validateForm() {
    var champ = document.forms["myForm"]["url"].value;
    if (champ == "") {
        alert("Veuillez saisir l'url de site");
        return false;
    }
} 

function confirmer(message){
	return(confirm(message));
}

function validerSwitches() {
    var sw1 = document.forms["swc"]["sw1"].value; 
    var sw2 = document.forms["swc"]["sw2"].value; 
    
    if (sw1 == sw2) {
        alert("Vous ne pouvez pas lier le switch à lui-même");
        return false;
    }
}  

function Positive(){  
    var etage = document.forms["ajouterL"]["etage"].value ;      
    if(etage<=0) {
    	alert("le numéro d'étage est un nombre positif"); 
    	return false ;
    }
}  


function VerifierValPositive(){
	
	var NbreBrins = document.forms["formLier"]["brins"].value ;  
	var distance = document.forms["formLier"]["dist"].value ;  
    var locale1 = document.forms["formLier"]["locale1"].value ; 
    var locale2 = document.forms["formLier"]["locale2"].value ; 

	if(NbreBrins <=0 ){
				alert("le nombre de brins ne doit pas être négatif");
             return false ; 
             
	} 

	if(distance <=0 ){
				alert("la distance ne doit pas être négative");
             return false ; 
             
	} 
	if(locale1 == locale2){
		alert("Vous ne  pouvez pas lier un local avec lui-même");
        return false ; 

	}  
}
