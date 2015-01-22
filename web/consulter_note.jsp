
            <%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
       
         <div style="margin:auto;background-color:whitesmoke;padding-bottom:15px;">
        <fieldset>
           
                <legend style="color:red;">liste des cours</legend>
                <br>  <br>  
       
    <img src="bannire.jpg" width="200" alt="200" />
    <hr>
         <h1 style="text-align:center;color:blue;">consulter les notes des diferents matieres</h1>
         <hr><br>
         
           <%
                
    try{
        Class.forName("com.mysql.jdbc.Driver");
        String url;
        url="jdbc:mysql://localhost:3306/test";
        String user;
        user="root";
        String password;
        password="";
        Connection cnx = DriverManager.getConnection(url,user,password);
       String var="note";
        ResultSet rst,rst2;
            //out.println("la liste du cours ");  
        PreparedStatement ps = cnx.prepareStatement("Select * from doc where type_doc='"+var+"'");
        
        rst=ps.executeQuery();
        out.println(" <h2>la liste des notes présents</h2>");out.println(" <br>");out.println(" <br>");
                    while (rst.next())
                    {out.println("<b> <---- les informations du chaque note ---></b>");out.println(" <br>");
                       out.println("Nom du cour : "+rst.getString("nom_doc"));  out.println(" <br>");
                     out.println("Chemain vers ce cours: "+rst.getString("chemain"));out.println(" <br>");
                     out.println("l'utilusateur qui l'oploder :"+rst.getString("nom_per"));out.println(" <br>");
                       
                      out.println("<a href ="+ rst.getString("nom_doc")+".pdf > ouvrir </a>  ");
                       out.println(" <br>");
                    }
                    
                    
                   
    }catch(Exception e){
        e.printStackTrace();
       System.out.println("connection echouée");
    }


        
                %>
        
       
         <a href="index.jsp">deconnecter  votre compte </a> 
        </fieldset>
    </body>
</html>
