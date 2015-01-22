<%-- 
    Document   : index
    Created on : 10 févr. 2014, 12:27:58
    Author     : BALTI
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Ajouter cours</title>

</head>
<body>
<div style="margin:auto;background-color:whitesmoke;padding-bottom:15px;">
        <fieldset>
           
                <legend style="color:red;">uploder</legend>
                <br>  <br>  
       
    <img src="bannire.jpg" width="200" alt="200" />
    <hr>
         <h1 style="text-align:center;color:blue;">Uploder un document </h1>
         <hr><br>

<form action="ajoutercours" method="post" enctype="multipart/form-data">
	<br>
        <label for="name">votre Nom :</label><br>
            <input type="text" size="40" id="name" name="nom_per"/>
        <br>
        <label for="name">vous etes ? etudiant , enseignant ou administrateur :</label><br>
            <input type="text" size="40" id="name" name="etat"/>
        <br>
    <label for="name">Nom Document:</label><br>
            <input type="text" size="40" id="name" name="nom_doc"/>
        <br>
        	<label for="name">Type Document:</label><br>
            <input type="text" size="40" id="name" name="type_doc"/>
            <br>
            <label>Upload a file:</label>
            <input type="file" name="fic" />
       <br>
    <p>
        <button type="submit" class="action">Uploader</button>
        
    </p>
</form>
</fieldset>
        
</body>
  

