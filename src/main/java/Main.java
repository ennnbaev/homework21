import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> example1 = new ArrayList<>();
        example1.add(1);
        example1.add(2);
        example1.add(3);
        example1.add(4);
        example1.add(5);
        example1.add(6);
        System.out.println(findSquareOfEvenNumbers(example1));
        List<String> example2 = new ArrayList<>();
        example2.add("hey");
        example2.add("Dan");
        example2.add("Pats");
        example2.add("Kharkov");
        System.out.println(moreTwoUpperCaseInList(example2));

        Map<Integer, Boolean> example3 = new HashMap<>();
        example3.put(2, true);
        example3.put(4, false);
        example3.put(1, true);
        example3.put(3, false);
        example3.put(5, true);
        System.out.println(sortMapWhereValueTrue(example3));
    }

    /**
     * This method find square of even numbers and return List of this numbers
     *
     * @param numbers list of input numbers
     * @return List square of even numbers
     */
    public static List<Integer> findSquareOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter((number) -> (number % 2) == 0)
                .map((number) -> number * number)
                .collect(Collectors.toList());
    }

    /**
     * This method return true if list contains two words in upper case
     *
     * @param inputWords list with words
     * @return boolean
     */
    public static boolean moreTwoUpperCaseInList(List<String> inputWords) {
        int minCount = 2;
        int indexFirstSymbol = 0;
        Predicate<List<String>> moreTwoUpperCase = (input) ->
                (input.stream()
                        .filter((input2) -> Character.isUpperCase(input2.charAt(indexFirstSymbol)))
                        .count() > minCount);
        long count = inputWords.stream().map(s -> inputWords).filter(moreTwoUpperCase).count();
        return count > minCount;
    }

    /**
     * This method sort map where value is true , with help og Stream API
     *
     * @param input map which will be sort
     * @return List with sorted key
     */
    public static List<Integer> sortMapWhereValueTrue(Map<Integer, Boolean> input) {
        return input.entrySet().stream().filter(Map.Entry::getValue)
                .sorted((input1, input2) -> input2.getKey() - input1.getKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
