<%-- 
    Document   : inscrire
    Created on : 21 févr. 2014, 23:52:00
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
        <br><br>
                 
           <form method="post"  action="inscrire">
    
   <div style="margin:auto;background-color:whitesmoke;padding-bottom:15px;">
        <fieldset>
           
                <legend style="color:red;">inscription</legend>
                <br>  <br>  
       
    <img src="bannire.jpg" width="200" alt="200" />
    <hr>
         <h1 style="text-align:center;color:blue;">Inscription</h1>
         <hr><br>
         
   <p style="text-align:center;">Nom               : <input type="text" name="nom"  /></p>
   <p style="text-align:center;">Prenom            : <input type="text" name="prenom" /></p>
   <p style="text-align:center;">CIN: <input type="text" name="num" /></p>
  
   <p style="text-align:center;">Pseudoname        : <input type="text" name="login"  /></p>
   <p style="text-align:center;">Mot de passe      : <input type="password" name="pwd" /></p>
   <br>
   <p style="text-align:center;width:50%;margin:auto;"><input type="submit" name="Enregistrer" value="Enregistrer"/>
  <input type="submit" name="Annuler" value="Annuler"/>
                   </fieldset>
   </div>
  </form>
          
    </body>
</html>
