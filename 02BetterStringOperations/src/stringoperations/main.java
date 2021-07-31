/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringoperations;

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
        
        //excercise 1 : find the better string:
        // using lambda expression
        String result = StringUtils.betterString("Ahmed", "Ali", (s1,s2) -> s1.length() <= s2.length());
        System.out.println("The (" + result + ") string is better because it has less charchters.");
        //using method refrence:
        String result2 = StringUtils.betterString("Ahmed", "Ibrahim", StringUtils::isShorter);
        System.out.println("The (" + result2 + ") string is better because it has less charchters.");
        
        
        //excercise 2 : find if a string has a number :
        String s3 = "Hellojava";
        String s4 = "Hellojava14";
        boolean result3 = StringUtils.hasDigit(s3.toCharArray(), Character::isLetter);  //using method refrence
        boolean result4 = StringUtils.hasDigit(s4.toCharArray(), (c) -> Character.isLetter(c) );  //using lambda
        System.out.println("the string(" + s3 +") has a number ? " + result3);
        System.out.println("the string(" + s4 +") has a number ? " + result4);
        
        
    }
    
}
