package count_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<Integer> findEvenNumbersLoop(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }
        return evens;
    }

    public static List<Integer> findEvenNumbersStream(List<Integer> numbers){
        return numbers.stream()
                .filter(num-> num % 2 == 0)
                .toList();
    }

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Список: " + numbers);
        System.out.println("Loop: " + findEvenNumbersLoop(numbers));
        System.out.println("Stream: " + findEvenNumbersStream(numbers));
    }
}
