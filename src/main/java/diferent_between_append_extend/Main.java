package different_between_append_extend;

import java.util.*;

public class Main {

    public static List<List<Integer>> processNumbersAppend(Map<String, List<Integer>> data) {
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : data.entrySet()) {
            List<Integer> value = entry.getValue();
            List<Integer> evens = value.stream()
                    .filter(num -> num % 2 == 0)
                    .toList();
            if (!evens.isEmpty()) {
                result.add(evens);
            }
        }
        return result;
    }

    public static List<Integer> processNumbersExtend(Map<String, List<Integer>> data) {
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : data.entrySet()) {
            List<Integer> value = entry.getValue();
            List<Integer> evens = value.stream()
                    .filter(num -> num % 2 == 0)
                    .toList();
            if (!evens.isEmpty()) {
                result.addAll(evens);
            }
        }
        return result;
    }

    public static void main(String... args) {
        Map<String, List<Integer>> data = new HashMap<>();
        data.put("a", Arrays.asList(1, 2, 3));
        data.put("b", Arrays.asList(4, 5, 6));
        data.put("c", Arrays.asList(7, 8, 9));

        System.out.println("Append: " + processNumbersAppend(data));
        System.out.println("Extend: " + processNumbersExtend(data));
    }
}
