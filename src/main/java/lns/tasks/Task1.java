package lns.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task1 implements ConsoleTool{

    public void execute() {
        System.out.println("Task1. Type numbers: ");
        List<Integer> list = getNumbersFromConsole();
        List<Integer> sortedList = list.parallelStream().distinct().sorted(Integer::compareTo).collect(Collectors.toList());
        sortedList.forEach(number -> System.out.print(number + " "));
        System.out.println();
        System.out.println("count: " + list.size());
        System.out.println("distinct: " + sortedList.size());
        System.out.println("min: " + list.parallelStream().min(Integer::compareTo).get());
        System.out.println("max: " + list.parallelStream().max(Integer::compareTo).get());
    }
}
