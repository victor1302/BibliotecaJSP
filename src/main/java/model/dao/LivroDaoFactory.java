/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author Vhugo
 */
public class LivroDaoFactory {
    public static LivroDaoJpa novoLivroDao() throws Exception {
        return new LivroDaoJpa();
    }
}
