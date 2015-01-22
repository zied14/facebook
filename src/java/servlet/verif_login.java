/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static javafx.scene.paint.Color.color;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BALTI
 */
public class verif_login extends HttpServlet {
Connection con;
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
        PrintWriter out = response.getWriter();
         try
        {
        Connection con = ConnecterDB();    
        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");
       PreparedStatement statement =con.prepareStatement("select * from per where nom ='"+login+"' and prenom ='"+pwd+"'");
        ResultSet result=statement.executeQuery();
       int i=0;
         while(result.next())
       {
           i++;
       }
         if(i==0)
         {
          out.println("<h1>login et mot de passe incorrect  !!</h1>");
          out.print("<br>");
         out.print("<br>");
        out.print("Retourner ver la page d'acceuill      <a href='index.jsp'>retour</a>");
         }
         else {    
           if (login.equals("admin"))
           {
                out.print("<div style=margin:auto;background-color:whitesmoke;padding-bottom:15px;>");
        out.print("<fieldset>");
        out.print("<img src=bannire.jpg width=200 alt=200 />");
          
               out.print(" <legend style=color:red;>espace admistrateur</legend>");
              out.print("<hr>");
        out.print("<h1 style=\"text-align:center;color:blue;\">Menu Administrateur</h1>");out.print("<hr>");
        out.print("<br>");out.print("<div style=\"text-align:center;\"><img src=per.jpeg width=200 alt=200 /></div>");
        out.print("<br>");
      
        out.print("<h2 style=\"text-align:center;>Menu</h2>");
        out.print("<br>");
        out.print("<div style=\"text-align:center; > saisie information etudiant     ");
        
       out.print(" <a href='inscription.jsp'>ajouter_etudiant</a>");
        out.print("<br>");
        out.print("saisie information d'un enseignant                  ");
    
        out.print("<a href='inscription.jsp'>ajouter_enseignant</a>");
        out.print("<br>");
       
         
        out.print("uploder  emploi de temps        ");
        
                out.print("<a href='Ajoutercours.jsp'>uploder_emploi</a>");
                out.print("<br>");
        out.print("produire la liste des notes   ");
        
                out.print("<a href='Ajoutercours.jsp'>produire_note</a>");
              out.print("<br>");
                
               out.print("consulter la liste des etulisateurs        ");
        
                out.print("<a href='aa'>consulter</a>");
                out.print("<br>");
               
           }        
           else 
               if (login.equals("root"))
           {
                out.print("<div style=margin:auto;background-color:whitesmoke;padding-bottom:15px;>");
        out.print("<fieldset>");
        out.print("<img src=bannire.jpg width=200 alt=200 />");
          
               out.print(" <legend style=color:red;>espace enseignant</legend>");
                out.print("<br>    ");
       
               
           
     
           out.print("<hr>");
        out.print("<h1 style=\"text-align:center;color:blue;\">Menu enseigant</h1>");out.print("<hr>");
        out.print("<br>");out.print("<div style=\"text-align:center;\"><img src=ee.jpeg width=200 alt=200 /></div>");
        out.print("<br>");
        out.print("<h2 style=\"text-align:center;>Menu</h2>");
        out.print("<br>");
        out.print("<div style=\"text-align:center; > consulter l'emploi de temps     ");
        
       out.print(" <a href='consulter_emploi.jsp'>consulter_emploi</a>");
        out.print("<br>");
        out.print("consulter un sujet td ou tp                  ");
        
        out.print("<a href='consulter_td.jsp'>consulter_td</a>");
        
       
         out.print("<br>");
        out.print("mettre a disposition les cours     ");
        
                out.print("<a href='Ajoutercours.jsp'>mettre_cour</a>");
               out.print("<br>");
        out.print("saisir un tp, td    ");
        
                out.print("<a href='Ajoutercours.jsp'>uploder</a>");
               
               
             out.print("<br>");   
        out.print("consulter les cours ");
        
                out.print("<a href='consulter_cour.jsp'>consulter_cour</a></div>");
           }        
         else {
                    out.print("<div style=margin:auto;background-color:whitesmoke;padding-bottom:15px;>");
        out.print("<fieldset>");
        out.print("<img src=bannire.jpg width=200 alt=200 />");
          
                out.print("<hr>");
        out.print("<h1 style=\"text-align:center;color:blue;\">Menu Etudiant</h1>");out.print("<hr>");
        out.print("<br>");out.print("<div style=\"text-align:center;\"><img src=ad.jpeg width=200 alt=200 /></div>");
        out.print("<br>");
       
              out.print(" <div style=\"width:50%;margin:auto;background-color:whitesmoke;padding-bottom:15px;\">");
           
        
       
        out.print("<h2 style=\"text-align:center;>Menu</h2>");
        out.print("<br>");
        out.print("<div style=\"text-align:center; > consulter l'emploi de temps     ");
        
       out.print(" <a href='consulter_emploi.jsp'>consulter_emploi</a>");
        out.print("<br>");
        out.print("consulter un sujet td ou tp                  ");
       
        out.print("<a href='consulter_td.jsp'>consulter_td</a>");
        out.print("<br>");
       
         
        out.print("consulter les cours     ");
       
                out.print("<a href='consulter_cour.jsp'>consulter_cour</a>");
                out.print("<br>");
        out.print("rendre un tp, td    ");
     
                out.print("<a href='Ajoutercours.jsp'>uploder</a>");
                out.print("<br>");
               
                
        out.print("consulter tous notes ");
        
                out.print("<a href='consulter_note.jsp'>consulter notes</a></div>");
               
                
         }
       }
        }catch(Exception ex)
       {
       out.println("<h1>impossible de se connecter a la base  !!</h1>");
          out.print("<br>");
         out.print("<br>");
        out.print("Retourner ver la page d'acceuill      <a href='index.jsp'>retour</a>");
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