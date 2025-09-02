/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Cliente;

/**
 *
 * @author lefoly
 */
public class ClienteDaoJpa implements InterfaceClienteDao<Cliente> {

    @Override
    public void incluir(Cliente cliente) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Cliente cliente) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Cliente cliente) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            Cliente c1 = em.find(Cliente.class, cliente.getId());
            em.remove(c1);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Cliente pesquisarPorId(int id) throws Exception {
        Cliente c = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            c = em.find(Cliente.class, id);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }

    @Override
    public List<Cliente> listar() throws Exception {
        List<Cliente> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("SELECT c FROM model.Cliente c WHERE c.ativo = true", Cliente.class).getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return lista;
    }

    @Override
    public List<Cliente> filtrarPorNome(String nome) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();

        Query query = em.createNamedQuery("Contato.filtrarPorNome");
        query.setParameter("nome", nome);
        List<Cliente> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public List<Cliente> livrosEmprestados() throws Exception {
        List<Cliente> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try{
            em.getTransaction().begin();
            String consulta = "SELECT DISTINCT c FROM cliente c JOIN c.emprestimo e";
            lista = em.createQuery(consulta).getResultList();
            em.getTransaction().commit();
       } finally{
            em.close();
        }
        return lista;
    }

    @Override
    public void desativarCliente(int clienteId) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try{
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, clienteId);
            if(cliente != null){
                cliente.setAtivo(false);
                em.merge(cliente);
            }
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            em.close();
        }
    }

}
