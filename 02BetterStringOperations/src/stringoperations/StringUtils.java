package stringoperations;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;


public class StringUtils {
    
    public static String betterString(String s1, String s2, BiPredicate<String, String> p){
        if (p.test(s1, s2)){
            return s1;
        }else{
            return s2;
        }
    }
    
    public static boolean isShorter(String s1 , String s2){
        if(s1.length() < s2.length()){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean hasDigit(char [] l, Predicate<Character> p){
        boolean flag = false;
        for(char c:l){
            if (p.test(c) == false) {
                flag =true;
                break;
            }
        }
        
        return flag;
        
    }

    static String hasDigit(String s3, Predicate<Character> predicate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
