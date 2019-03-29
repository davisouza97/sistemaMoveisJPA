/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;


import dao.PersistenceUtil;
import java.io.IOException;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
@WebServlet(name = "RelatorioControllerFornecedor", urlPatterns = "/RelatorioControllerFornecedor")
public class RelatorioControllerFornecedor extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
 EntityManager em = PersistenceUtil.getEntityManager();
            EntityTransaction tx = em.getTransaction();
 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        Date date = new Date();
        String data = dateFormat.format(date);
        try {
             
            tx.begin();
            HashMap parametros = new HashMap();
            //parametros.put("PAR_codCurso", Integer.parseInt(request.getParameter("txtCodCurso")));
            String relatorio = getServletContext().getRealPath("/WEB-INF/classes/relatorio")+"/fornecedores.jasper";
            
//            JasperPrint jp = JasperFillManager.fillReport(relatorio, parametros, tx.???);
//            
//            byte[] relat = JasperExportManager.exportReportToPdf(jp);
//            response.setHeader("Content-Disposition", "attachment;filename=relatorioFornecedores" + data + ".pdf");
//            response.setContentType("application/pdf");
//            response.getOutputStream().write(relat);
//        } catch (JRException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
        } finally {
           PersistenceUtil.close(em);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
