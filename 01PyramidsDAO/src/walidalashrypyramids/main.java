/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package walidalashrypyramids;

import java.util.List;

/**
 *
 * @author Walidz
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        PyramidCSVDAO dao = new PyramidCSVDAO();
        List<Pyramid> pyramids =  dao.PyramidCSVDAO("pyramids.csv");
        
        int i = 1;
        for (Pyramid p:pyramids) {
            System.out.println("#"+(i++) +" "+ p.getModern_name());
            System.out.print(p.getPharaoh() + " | ");
            System.out.print(p.getModern_name()+ " | ");
            System.out.print(p.getSite()+ " | ");
            System.out.println(p.getHeight());
        

        
        }
    }
}
