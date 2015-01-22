/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static servlet.inscrire.ConnecterDB;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author BALTI
 */
public class aa extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
         public static Connection ConnecterDB()
{
    try{
        Class.forName("com.mysql.jdbc.Driver");
        String url;
        url="jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull";
        String user;
        user="root";
        String password;
        password="";
        Connection cnx = DriverManager.getConnection(url,user,password);
        System.out.println("connection etablie");
        return cnx;
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }

}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             ResultSet rs;
            /* TODO output your page here. You may use following sample code. */
 
         try
        {
               Connection con = ConnecterDB();   
       
        String req="select  FROM per ";
        Statement st;
      PreparedStatement statement =con.prepareStatement("select * from per ");
        ResultSet result=statement.executeQuery();
       out.print(" <div style=\"margin:auto;background-color:whitesmoke;padding-bottom:15px;\">\n" +
"        <fieldset>\n" +
"           \n" +
"                <legend style=\"color:red;\">liste des cours</legend>\n" +
"                <br>  <br>  \n" +
"       \n" +
"    <img src=\"bannire.jpg\" width=\"200\" alt=\"200\" />\n" +
"    <hr>\n" +
"         <h1 style=\"text-align:center;color:blue;\">consulter les cours des diferents etudaint - administrateur- enseignant</h1>\n" +
"         <hr><br>");
              out.print("<br>");
         out.print("<br>");
         out.print("<center>");
         out.print("  <table id=\"rounded-corner\" border=\"2\" >\n" +
"    <thead>\n" +
"    	<tr>\n" +
"            \n" +
"            <th scope=\"col\" class=\"rounded\">Nom</th>\n" +
"            <th scope=\"col\" class=\"rounded\">Prenom</th>\n" +
"            <th scope=\"col\" class=\"rounded\">CIN</th>\n" +
"            <th scope=\"col\" class=\"rounded\">Login</th>\n" +
"            <th scope=\"col\" class=\"rounded\">Password</th>\n" +
"        </tr>\n" +
"    </thead>\n" +
"      \n" +
"    <tbody>\n" +
"    	<tr>\n" +
"        	\n" );
         while(result.next())
       { out.println("<tr>");
         out.println("<td>"+result.getString(1)+"</td>");
         out.println("<td>"+result.getString(2)+"</td>");
         out.println("<td>"+result.getString(3)+"</td>");
         out.println("<td>"+result.getString(4)+"</td>");
         out.println("<td>"+result.getString(5)+"</td>");
   out.println("<inpute type=\"text\">");
        out.println("</tr>");
                 out.print("</center>");
      }
         
        out.println("</div>");      
        
        
        }catch(Exception ex)
       {
        out.println("<h1>la personne demandé n'existe pas  !!</h1>");
        out.print("<br>");
         out.print("<br>");
        out.print("Retourner ver la page d'acceuill      <a href='index.jsp'>retour</a>");   
       }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
