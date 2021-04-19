package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

    public StreamAPI() {
        final List<String> jmena = Arrays.asList("David", "Martin", "Dan", "Petr", "Vratislav", "Eliška");
        jmena.stream().filter(jmeno -> jmeno.length() > 5).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("**************");
        Predicate<String> predicate = t -> t.contains("D");
        jmena.stream().filter(predicate).forEach(System.out::println);

        System.out.println("\nJEDINEČNÉ PRVKY (DISTINCT)");
        Stream.of(1, 5, 3, 44, 1, 468, 1, 44, 8, 4).distinct().forEach(System.out::println);

        System.out.println("\nLIMIT");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).limit(5).forEach(System.out::println);

        System.out.println("\nSKIP");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).skip(4).forEach(System.out::println);

        
    }

    public static void main(String[] args) {
        new StreamAPI();
    }
}
