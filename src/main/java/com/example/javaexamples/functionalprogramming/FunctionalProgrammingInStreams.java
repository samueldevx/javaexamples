package com.example.javaexamples.functionalprogramming;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalProgrammingInStreams {

    public static void main(String[] args) {
        // 1: First-Class Functions
        firstClassFunctions();

        // 2: Immutability
        immutability();

        // 3: Lazy Evaluation
        lazyEvaluation();

        // 4: Higher-Order Functions
        higherOrderFunctions();
    }

    // 1: First-Class Functions
    public static void firstClassFunctions() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squaredNumbers = numbers.stream()
                .map(FunctionalProgrammingInStreams::square)
                .collect(Collectors.toList());
        System.out.println("Numbers: "+numbers);
        System.out.println("Squared Numbers: " + squaredNumbers);
    }

    // Example 2: Immutability
    public static void immutability() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> doubledNumbers = numbers.stream()
                .map(n -> n * 2) // Operations do not modify original list
                .collect(Collectors.toList());
        System.out.println("Numbers: "+numbers);
        System.out.println("Doubled Numbers: " + doubledNumbers);
    }

    // Example 3: Lazy Evaluation
    public static void lazyEvaluation() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> integerStream = numbers.stream()
                .filter(n -> {
                    System.out.println("Filtering: " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("Mapping: " + n);
                    return n * 2;
                });
        //nothing will be printed before this line
        integerStream.forEach(System.out::println);

    }

    // 4: Higher-Order Functions
    public static void higherOrderFunctions() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> capitalizedWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Capitalized Words: " + capitalizedWords);
    }

    public static int square(int x) {
        return x * x;
    }
}
