/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author Vhugo
 */
public class EmprestimoDaoFactory {
    
    public static EmprestimoDaoJpa novoEmprestimoDao() throws Exception{
        return new EmprestimoDaoJpa();
    }
}
