
package com.emergentes.controlador;
import com.emergentes.dao.avisoDAO;
import com.emergentes.dao.avisoDAOompl;
import com.emergentes.modelo.Aviso;
import com.sun.xml.ws.server.ServerRtException;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.weld.module.web.HttpServletRequestBean;

@WebServlet(name = "inicio", urlPatterns = {"/inicio"})
public class inicio extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      try{
          avisoDAO dao = new avisoDAOompl();
          int id;
          Aviso avi = new Aviso();
          String action =(request.getParameter("acction") != null)? request.getParemeter("action"): "view";
          switch(action){
              case"add":
                  request.setAttribute("aviso", avi);
                  request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
         break;
              case "edit":
                id = Integer.parseInt(request.getParamter("id"));
                avi = dao.getById(id);
                  System.out.println(avi);
                 request.setAttributeDispacher("frmaviso.jsp").forward(request, response); 
         break;
              case "delete":
                  id = Integer.parseInt(request.getParemeter("id"));
                  dao.delete(id);
                  response.sendRedirect(request.getContextPath()+"/inicio");
                  break;
              case "view":
                  List <Aviso> lista = dao.getAll();
                  request.setAtributeDispacher("index.jsp").forward(request, response);
              default:
                  break;
          }
      }  catch (Exception ex){
          System.out.println("error"+ ex.getMessage());
      }
    }
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServerRtException, IOException{
         try{
             avisoDAO dao = new avisoDAO();
             int id;
             Aviso avi = (request.getParameter("action")!=null)? request.getParameter("action"): "view";
         switch(action){
             case "add":
                 request.setAttribute("aviso", avi);
                 request.getRequestDispacher("frmaviso.jsp").forward(request, response);
        break;
             case "edit":
                 id = Integer.parseInt(request.getParameter("id"));
                 avi= dao.getById(id);
                 System.out.println("aviso"+avi);
                 request.getRequestDispacher("frmaviso.jsp").forward (request, response);
                 break;
             case "delete":
                 id = Integer.parseInt(request.getParameter("id"));
                 dao.delete(id);
                 response.sendRedirect (request.getParameter("id"));
                 dao.delete(id);
                 response.sendRedirect(request.getContextPath()+"/inicio");
                 break;
             case "view":
                 List<Aviso> lista= dao.getAll();
                 request.setAttribute("aviso", lista);
                 request.getRequestDispacher("index.jsp").forward(request, response);
                 default:
                     break;
                 
         }
         }catch(Exception ex){
             System.out.println("error"+ ex.getMessage());
         }
         
     }
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    int id  = Integer.parseInt(request.getParameter("id"));
    String titulo = request.getParameter("titulo");
    String contenido = request.getParameter("contenido");
    Aviso avi = new Aviso();
    if (id == 0) {
        try{
            AvisoDAO dao = new avisoDAOompl();
            dao.insert(avi);
            response.sendRedirect(request.getContextPath()+ "/inicio");
        }catch (exception ex){
            System.out.println("error"+ ex.getMessage());
        }
    }
    else{
        try{
            avisoDAO dao = new avisoDAOompl();
            dao.update (avi);
            response.sendRedirect(request.getContesxtPath()+"/inicio");
        }catch (Exception ex)
        {
            System.out.println("error"+ ex.getMessage());
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
