package lns.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public interface ConsoleTool {
    default List<Integer> getNumbersFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        List<Integer> list = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return list;
    }
}
