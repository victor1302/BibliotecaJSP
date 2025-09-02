package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.dao.ClienteDaoFactory;
import model.dao.ClienteDaoJpa;
import model.dao.InterfaceClienteDao;
import model.dao.InterfaceDao;

/**
 *
 * @author Vhugo
 */
@WebServlet("/registrar")
public class ClienteController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        switch (acao) {
            case "listagem":
                listagem(request, response);
                break;
            case "deletar":
                deletar(request, response);
            default:
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
                requestDispatcher.forward(request, response);
        }
           
    }   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        
        switch (acao) {
            case "registrar":
                registrar(request, response);
                break;
            case "deletar":
                try{
                    InterfaceClienteDao dao = ClienteDaoFactory.novoClienteDAO();
                    int id = Integer.parseInt(request.getParameter("clienteId"));                    
                    dao.desativarCliente(id);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
                requestDispatcher.forward(request, response);
                break;
        }
    }
    
    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            InterfaceClienteDao dao = ClienteDaoFactory.novoClienteDAO();
            String nome = request.getParameter("nome");
            String idade = request.getParameter("idade");
            String endereco = request.getParameter("endereco");
            String senha = request.getParameter("senha");

            Cliente cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setIdade(Integer.parseInt(idade));
            cliente.setEndereco(endereco);
            cliente.setSenha(senha);
            cliente.setAtivo(true);
        
            dao.incluir(cliente);
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
            requestDispatcher.forward(request, response);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }  
    }
    
    private void listagem(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        InterfaceClienteDao dao = new ClienteDaoJpa();
        List<Cliente> lista = null;
        try{
            lista = dao.listar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        request.setAttribute("clientes", lista);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/ListagemClientes.jsp");
        requestDispatcher.forward(request, response);
    }
    
    private void deletar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
        requestDispatcher.forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
