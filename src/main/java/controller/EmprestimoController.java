/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Emprestimo;
import model.dao.EmprestimoDaoJpa;
import model.dao.InterfaceEmprestimoJpa;

@WebServlet("/emprestimo")
public class EmprestimoController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if(acao != null){
            switch (acao) {
                case "historico":
                    listarLivrosDisponiveis(request, response);
                break;
                default:
                    throw new AssertionError();
            }
            
        }else{
            response.sendRedirect("index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    private void listarLivrosDisponiveis(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        InterfaceEmprestimoJpa dao = new EmprestimoDaoJpa();
        List<Emprestimo> lista = null;
        try{
            lista = dao.listarHistorico();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        request.setAttribute("historico", lista);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/MostrarHistorico.jsp");
        requestDispatcher.forward(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
