package streamapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class VytvoreniStreamu {

    public static void main(String[] args) {
        // 3 způsoby, jak vytvořit streamy
        List<String> list = Arrays.asList("pepa", "karel", "michal");
        Stream<String> stream = list.stream();

        Integer[] pole = new Integer[]{5, 7, 9, 11, -4};
        Stream<Integer> intStream = Arrays.stream(pole);
        // nebo
        Stream<Integer> intStream2 = Stream.of(pole);

        Stream<String> ownStream = Stream.of("pepa", "karel", "michal");

        DoubleStream.generate(Math::random).limit(10).forEach(System.out::println);

        DoubleStream.iterate(10, operand -> operand / 2).limit(10).forEach(System.out::println);

        IntStream.rangeClosed(1, 10).forEach(System.out::println);
    }
}
