/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Emprestimo;
import model.Livros;
import model.dao.ClienteDaoFactory;
import model.dao.ClienteDaoJpa;
import model.dao.EmprestimoDaoFactory;
import model.dao.EmprestimoDaoJpa;
import model.dao.InterfaceClienteDao;
import model.dao.InterfaceDao;
import model.dao.InterfaceEmprestimoJpa;
import model.dao.LivroDaoFactory;
import model.dao.LivroDaoJpa;

/**
 *
 * @author Vhugo
 */
@WebServlet("/livros")
public class LivrosController extends HttpServlet {

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
            case "listagem":
                listarLivrosDisponiveis(request, response);
                break;
            case "devolver":
                devolverLivro(request, response);
                break;
        }
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        
        
        
        if(acao != null ){
            switch (acao) {
            case "registrar":
                registrarLivros(request, response);
                break;
            case "deletarEmprestimo":
                try{
                    InterfaceEmprestimoJpa dao = EmprestimoDaoFactory.novoEmprestimoDao();
                    int id = Integer.parseInt(request.getParameter("emprestimoId"));
                    dao.devolverLivro(id);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
                requestDispatcher.forward(request, response);
                break;
            }
        }else{
            emprestarLivro(request, response);
        }
        
        
    }
    
    private void registrarLivros(HttpServletRequest request, HttpServletResponse response){
        
        try{
            InterfaceDao dao = LivroDaoFactory.novoLivroDao();
            
            String nome = request.getParameter("nome");
            String autor = request.getParameter("autor");
            String edicao = request.getParameter("edicao");
            String editora = request.getParameter("editora");
            
            
            Livros livro = new Livros();
            livro.setNome(nome);
            livro.setAutor(autor);
            livro.setEditora(editora);
            livro.setEdicao(Integer.parseInt(edicao));
            System.out.println(livro.toString());
            
            dao.incluir(livro);
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
            requestDispatcher.forward(request, response);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        
    }
    
    private void listarLivrosDisponiveis(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        InterfaceDao dao = new LivroDaoJpa();
        InterfaceClienteDao daoCliente = new ClienteDaoJpa();
        List<Livros> lista = null;
        List<Cliente> listaCliente = null;
        try{
            lista = dao.listarDisponiveis();
            listaCliente = daoCliente.listar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        request.setAttribute("livros", lista);
        request.setAttribute("clientes", listaCliente);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/ListagemLivrosDisponiveis.jsp");
        requestDispatcher.forward(request, response);
    }
    
    private void emprestarLivro(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        try{
            EmprestimoDaoJpa dao = EmprestimoDaoFactory.novoEmprestimoDao();
            ClienteDaoJpa daoCliente = ClienteDaoFactory.novoClienteDAO();
            LivroDaoJpa daoLivro = LivroDaoFactory.novoLivroDao();
            
            String livroId = request.getParameter("livroId");
            String clienteId = request.getParameter("clienteId");
            if(livroId != null){
                Livros livro = new Livros();
                Cliente cliente = new Cliente();
                
                
                livro = daoLivro.pesquisarPorId(Integer.parseInt(livroId));
                cliente = daoCliente.pesquisarPorId(Integer.parseInt(clienteId));
                
                Emprestimo emprestimo = new Emprestimo(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), livro, cliente);
                dao.incluir(emprestimo);
                
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
                requestDispatcher.forward(request, response);
                
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void devolverLivro(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        InterfaceEmprestimoJpa daoEmprestimo = new EmprestimoDaoJpa();
        InterfaceDao daoLivros = new LivroDaoJpa();
        InterfaceClienteDao daoCliente = new ClienteDaoJpa();
        
        List<Emprestimo> listaEmprestimo = null;
        List<Livros> listaLivros = null;
        List<Cliente> listaClientes = null;
        
        
        try{
            listaEmprestimo = daoEmprestimo.listar();
            listaLivros = daoLivros.listarEmprestados();
            listaClientes = daoCliente.livrosEmprestados();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        request.setAttribute("emprestimos", listaEmprestimo);
        request.setAttribute("livros", listaLivros);
        request.setAttribute("clientes", listaClientes);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/LivrosEmprestados.jsp");
        requestDispatcher.forward(request, response);
    }
        
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
