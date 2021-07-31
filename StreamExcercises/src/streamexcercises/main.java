/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamexcercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Walidz
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        //01
        Person p1 = new Person("Ahmed", 33);
        Person p2 = new Person("Walid", 30);
        Person p3 = new Person("Mohamed", 26);
        Person p4 = new Person("Rana", 24);
        
        List<Person> sibilings = List.of(p1, p2 , p3, p4);
        
        Long countStartwithW = sibilings.stream()
                                        .map(x -> x.getName())
                                        .filter(x -> x.startsWith("W"))
                                        .count();
        
        System.out.println(countStartwithW);
       
        
        //03
        City engineers = new City("Engineers", p2, p3);
        City doctors = new City("Doctors", p1, p4);
        
        List<City> cities = List.of(engineers, doctors);
        Long countPeople = cities.stream().flatMap(x -> x.getPeople().stream()).count();
        System.out.println("people in cities = " + countPeople);
        
        cities.stream().flatMap(x -> x.getPeople().stream()).forEach(x -> System.out.println(x));
        
        //04
        long count2 =  Stream.of(sibilings).count();
        System.out.println(count2);
        
        Person[] people = {p1, p2, p3, p4};
        Arrays.stream(people).forEach(x -> System.out.println(x.getName()));
        
        //05
        Path path = Path.of("first-names.txt");
        try (Stream<String> lines = Files.lines(path)){
            long countLines = lines.count();
            System.out.println("we have " + countLines + " lines.");
        }catch(IOException e){
            e.printStackTrace();
        }
        
        //06
        String sentence = "the quick brown fox jumps over the lazy dog";
        String[] words = sentence.split(" ");
        long countWords = Arrays.stream(words).count();
        System.out.println("the sentence has " + countWords + " words.");
        
        Pattern delimit = Pattern.compile(" ");
        long countWords2 = delimit.splitAsStream(sentence).count();
        System.out.println("the sentence has " + countWords2 + " words.");
        
        
        //07
        sentence.chars()
                .mapToObj(lettercode -> Character.toString(lettercode))
                .filter(letter -> !letter.equals(" "))
                .distinct()
                .sorted()
                .forEach(x -> System.out.print(x));
        
        //08
        IntStream.range(0, 30)
                .skip(10)
                .limit(10)
                .forEach(x -> System.out.print(x + "|"));
        
        try (Stream<String> lines = Files.lines(path)){
            lines.skip(20).limit(10).forEach(System.out::println);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
        //getting average age for names with 'a'
        double average = sibilings.stream()
                .filter(x -> x.getName().contains("a"))
                .mapToInt(x -> x.getAge())
                .average()
                .orElseThrow();
        System.out.println(average);
                
        
    }
    
}
