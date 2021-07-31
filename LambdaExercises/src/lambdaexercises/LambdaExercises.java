/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaexercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

/**
 *
 * @author Walidz
 */
public class LambdaExercises {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Supplier 
        Supplier<String> supplier = () -> "Hello";
        String str1 = supplier.get();
        System.out.println(str1);
        
        //consumer
        Consumer<String> consumer = (String string) -> System.out.println(string);
        consumer.accept("Hello");
        
        //predicate
        List<String> numbers = new ArrayList<>(List.of("one", "two", "three", "four", "five", "six",
                                                        "seven", "eight", "nine", "ten"));
        numbers.removeIf((s) -> s.startsWith("j"));
        numbers.forEach((s) -> System.out.println(s));
        
        //function
        User sarrah = new User("Sarrah", 20);
        User ahmed = new User("Ahmed", 30);
        User abdo = new User("Abdo", 15);
        User tamer = new User("Tamer", 22);
        User tamer2 = new User("Tamer", 23);
        
        List<User> users = new ArrayList<>(List.of(sarrah, ahmed, abdo,tamer, tamer2));
        List<String> names = new ArrayList<>();
        Function <User, String> toString = (User user) -> user.getName();
        for(User user:users){
            String name = toString.apply(user);
            names.add(name);
        }
        users.forEach(s -> System.out.println(s));
        names.forEach(s -> System.out.println(s));
        
        
        //working with primitives:
        IntSupplier intSupplier = () -> 10 ;
        int num = intSupplier.getAsInt();
        System.out.println(num);
        
        DoubleToIntFunction func = (double value) -> (int) Math.floor(value);
        int result = func.applyAsInt(3.14);
        System.out.println(result);
        
        
        //chaining consumer:
        Consumer<String> c1 = s -> System.out.println("c1 consumes " + s);
        Consumer<String> c2 = s -> System.out.println("c2 consumes " + s);    
        Consumer<String> c3 = c1.andThen(c2);
        c3.accept("Hello");
        
        //comprator
        Comparator<String> cmp = (String s1, String s2) -> s1.compareTo(s2);
        numbers.sort(cmp);
        System.out.println(numbers);
        
//        Comparator<User> cmp2 = (User u1, User u2) -> u1.getName().compareTo(u2.getName());
//        users.sort(cmp2);
//        System.out.println(users);
        
        Comparator<String> cmp3 = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
        numbers.sort(cmp3);
        System.out.println(numbers);
        
        Function<String, Integer> toLength = s -> s.length();
        Comparator<String> cmp4 = Comparator.comparing(toLength);
        numbers.sort(cmp3);
        System.out.println(numbers);
        
        ToIntFunction<String> toLen = s -> s.length();
        Comparator<String> cmp5 = Comparator.comparingInt(toLen);
        numbers.sort(cmp3);
        System.out.println(numbers);
        
        Comparator<User> cmpName = Comparator.comparing(u -> u.getName());
        Comparator<User> cmpAge = Comparator.comparing(u -> u.getAge());
        Comparator<User> cmpAgeRev = cmpAge.reversed();
        Comparator<User> cmp6 = cmpName.thenComparing(cmpAgeRev);
        users.sort(cmp6);
        users.forEach(u -> System.out.println(u));
        
        
        //predicate:
        Predicate<String> isNull = s -> s == null ;
        Predicate<String> isEmpty = s -> s.isEmpty();
        Predicate<String> p = isNull.negate().and(isEmpty.negate());
        System.out.println("result = "+ p.test(null));
        System.out.println("result = "+ p.test(""));
        System.out.println("result = "+ p.test("hello"));
        
    }
    
}
