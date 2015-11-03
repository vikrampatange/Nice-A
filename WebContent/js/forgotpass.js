$(document).ready(function() {
	
   $("#hidden").hide();
   $("#fp").click(function(){
	   $("#loginDiv").hide();
	   $("#hidden").show();
   });
   
  
   
   
   $('#forgotpassword').formValidation({
       message: 'This value is not valid',
       icon: {
           valid: 'fa fa-ok fw',
           invalid: 'fa fa-remove fw',
           validating: 'fa fa-refresh fw'
       },
       fields: {
       	
           
           
              
           
           userEmail: {
               validators: {
                   notEmpty: {
                       message: 'The email address is required'
                   },
                   emailAddress: {
                       message: 'The input is not a valid email address'
                   }
               }
           } ,
           
           
           
          
           
			
       }
   });
   
});