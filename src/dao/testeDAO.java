/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Movel1;

/**
 *
 * @author davi
 */
public class testeDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        List<Movel1> x = MovelDAO1.obterMoveisById(1L);
        for (Movel1 movel1 : x) {
            System.out.println(movel1.getNome());
        }
        
        
        
        
    }
    
}
