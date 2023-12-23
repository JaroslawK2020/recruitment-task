package lns.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task2 implements ConsoleTool {
    public void execute() {
        System.out.println("Task2. Type numbers: ");
        List<int[]> pairsList = getPairsList(getNumbersFromConsole());
        pairsList.sort(Comparator.comparingInt(a -> a[0]));
        for (int[] pair : pairsList) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }

    private List<int[]> getPairsList(List<Integer> list) {
        List<int[]> pairsList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int first = list.get(i);
                int second = list.get(j);
                if (first + second == 13) {
                    if (first > second) {
                        int buffer = second;
                        second = first;
                        first = buffer;
                    }
                    int[] pair = {first, second};
                    pairsList.add(pair);
                }
            }
        }
        return pairsList;
    }
}
