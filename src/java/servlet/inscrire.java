/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static servlet.verif_login.ConnecterDB;


/**
 *
 * @author BALTI
 */
public class inscrire extends HttpServlet {
Connection con;
    
 
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
        PrintWriter out = response.getWriter();
       
         try
        {
         Connection con = ConnecterDB();   
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String cin = request.getParameter("num");
        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");
       
        String req="Insert into per(nom,prenom,nic,login,pwd) values('"+nom+"','"+prenom+"','"+cin+"','"+login+"','"+pwd+"');";
        Statement st;
        st = con.createStatement();
        st.executeUpdate(req);
        
        out.println("<h1>insertion effectuée !!</h1>");
         out.print("<br>");
         out.print("<br>");
        out.print("Retourner ver la page d'acceuill      <a href='index.jsp'>retour</a>");   
        }catch(Exception ex)
       { 
          out.println("<h1>impossible d'inserer dans la base  !!</h1>");
         out.print("<br>");
         out.print("<br>");
        out.print("Retourner ver la page d'acceuill      <a href='inscription.jsp'>retour</a>");   
       }
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
