package ae.lesson.first;

import java.util.Arrays;
import java.util.Random;

import ae.common.Lesson;
import ae.lesson.first.calculator.Calculator;
import ae.util.ConsoleHelpers;

public class FirstLesson extends Lesson {

    public void run() {
        task1();
        task2();
        task3();
    }

    protected static void task1() {
        final int elementsCount = 20;

        // generate array of numbers
        final Random random = new Random();

        int[] arr = new int[elementsCount];
        for (int i = 0; i < elementsCount; i++) arr[i] = -10 + random.nextInt(21);

        // print array
        System.out.println(Arrays.toString(arr));

        // find sum & min value
        int sum = arr[0];
        int min = arr[0];
        for (int i = 1; i < elementsCount; i++) {
            sum += arr[i];
            min = Math.min(min, arr[i]);
        }

        System.out.println(sum / elementsCount - min);
    }

    protected static void task2() {
        final int n = ConsoleHelpers.readInt("Enter n: ");
        System.out.println("Enter " + n + " words:");

        String taskResult = null;
        outerloop: for (int i = 0; i < n; i++) {
            String word = ConsoleHelpers.readNonEmptyString("");

            if (taskResult == null) {
                for (int j = 0; j < word.length(); j++) {
                    if (word.lastIndexOf(word.charAt(j)) != j) continue outerloop;
                }
                taskResult = word;
            }
        }

        if (taskResult != null) {
            System.out.println("Word with all unique characters: " + taskResult);
        } else {
            System.out.println("There is no word with unique characters");
        }
    }

    protected static void task3() {
        Calculator c = new Calculator();

        c.addBinaryOperator("%", (a, b) -> a % b);
        c.addBinaryOperator("^", Math::pow);

        c.run();
    }

}
