package lns;

import lns.tasks.Task1;
import lns.tasks.Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type 1, 2 or 3 to execute Task1, Task2 or Task3: ");
        String input = scanner.nextLine();

        switch (input){
            case "1":
                Task1 task1 = new Task1();
                task1.execute();
                scanner.close();
                break;
            case "2":
                Task2 task2 = new Task2();
                task2.execute();
                scanner.close();
                break;
        }

    }
}