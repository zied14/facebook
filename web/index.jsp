<%-- 
    Document   : index
    Created on : 10 févr. 2014, 12:27:58
    Author     : BALTI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
         <div style="margin:auto;background-color:whitesmoke;padding-bottom:15px;">
        <fieldset>
           
                <legend style="color:red;">Authentification</legend>
                <br>  <br>  
       
    <img src="bannire.jpg" width="200" alt="200" />
         <h1 style="text-align:center;color:blue;">École Nationale Supérieure d’Ingénieurs de Tunis</h1>
                 <br>
                  
                      <form method="post" name="Form" action="verif_login">
            <div style="text-align:center;">
     <img src=ll.jpeg width=200 alt=200 />
            </div>
  <p style="text-align:center;">Vous devez saisir votre login et votre mot passe pour acceder au site.</p>
                
        
  <p style="text-align:center;">Pseudonyme : <input type="text" name="login"  /></p>
  <p style="text-align:center;">Mot de passe : <input type="password" name="pwd" /></p>
  <p style="text-align:center;width:50%;margin:auto;"><input type="submit" name="connecter" value="Se connecter"/>
  </form>
      <form method="post" action="inscription.jsp">
      <input type="submit" name="inscrire" value="S'inscrire"/>
           </form>
                      
                      
</div>
        </fieldset>
    </body>
</html>
   
