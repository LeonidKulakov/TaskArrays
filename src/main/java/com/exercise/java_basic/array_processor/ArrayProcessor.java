package com.exercise.java_basic.array_processor;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 04-java-basic-array-processor
 * Useful methods for array processing
 */

public class ArrayProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи число цифр:");
        int number = scanner.nextInt();
        int[] input = new int[number];
        System.out.println("введи цыфры: ");
        for (int i = 0; i < number; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println("Original array: " + Arrays.toString(input));
        swapMaxNegativeAndMinPositiveElements(input);
        countSumOfElementsOnEvenPositions(input);
        replaceEachNegativeElementsWithZero(input);
        multiplyByThreeEachPositiveElementStandingBeforeNegative(input);
        calculateDifferenceBetweenAverageAndMinElement(input);
        findSameElementsStandingOnOddPositions(input);

    }


    public static int[] swapMaxNegativeAndMinPositiveElements(int[] input) {
        int min = input[0];
        int max = input[0];
        int minIndex = 0;
        int maxIndex = 0;
        int[] testInput = input.clone();
        for (int i = 0; i < input.length; i++) {
            if (min > input[i]) {
                min = input[i];
            }
        }
        for (int i = 0; i < input.length; i++) {
            if (max < input[i]) {
                max = input[i];
            }
        }
        for (int i = 0; i < input.length; i++) {
            if (input[i] > min && input[i] < 0) {
                min = input[i];
                minIndex = i;
            }
        }
        for (int i = 0; i < input.length; i++) {
            if (input[i] < max && input[i] > 0) {
                max = input[i];
                maxIndex = i;
            }
        }
        testInput[minIndex] = max;
        testInput[maxIndex] = min;
        System.out.println("1) Exchange max negative and min positive elements: " + Arrays.toString(testInput));
        return testInput;
    }

    public static int countSumOfElementsOnEvenPositions(int[] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i = i + 2) {
            sum = sum + input[i];
        }
        System.out.println("2) Sum of elements on even positions: " + sum);
        return sum;
    }

    public static int[] replaceEachNegativeElementsWithZero(int[] input) {
        int[] testInput = input.clone();
        for (int i = 0; i < input.length; i++) {
            if (testInput[i] < 0) {
                testInput[i] = 0;
            }
        }
        System.out.println("3) Replace negative values with 0 " + Arrays.toString(testInput));
        return testInput;
    }

    public static int[] multiplyByThreeEachPositiveElementStandingBeforeNegative(int[] input) {
        int[] testInput = input.clone();
        for (int i = 1; i < input.length; i++) {
            if (testInput[i] < 0 && testInput[i - 1] > 0) {
                testInput[i - 1] = testInput[i - 1] * 3;
            }
        }
        System.out.println("4) Multiply by 3 each positive element standing before negative one " + Arrays.toString(testInput));
        return testInput;
    }

    public static float calculateDifferenceBetweenAverageAndMinElement(int[] input) {
        int min = input[0];
        int[] testInput = input.clone();
        for (int i = 0; i < testInput.length; i++) {
            if (min > input[i]) {
                min = input[i];
            }
        }
        float sum = 0;
        for (int i = 0; i < testInput.length; i++) {
            sum = sum + input[i];
        }
        sum = sum / testInput.length - min;
        System.out.println("5) Difference between average and min element in array: " + sum);
        return sum;
    }


    public static int[] findSameElementsStandingOnOddPositions(int[] input) {
        int[] cloneInput = input.clone();
        int[] testInput = new int[input.length];
        int counter = 0;
        for (int i = 0; i < cloneInput.length; i++) {
            for (int j = i + 1; j < cloneInput.length; j++) {
                if (cloneInput[i] == cloneInput[j] && (i + 1) % 2 == 0) {
                    testInput[counter] = cloneInput[i];
                    counter++;

                }
            }
        }
        int[] doneArray = new int[counter];
        System.arraycopy(testInput, 0, doneArray, 0, counter);

        ArrayList<Integer> listInput = new ArrayList<Integer>();
        for (int i = 0; i < doneArray.length; i++) {
            listInput.add(doneArray[i]);
        }

        for (int i = 0; i < doneArray.length; i++) {
            for (int j = i + 1; j < doneArray.length; j++) {
                if (doneArray[i] == doneArray[j]) {
                    listInput.remove(j);
                }
            }
        }
        doneArray = new int[listInput.size()];
        for (int i = 0; i < listInput.size(); i++) {
            doneArray[i] = listInput.get(i);
        }
        System.out.println("6) Elements which present more than one time and stay on odd index" + Arrays.toString(doneArray));
        return doneArray;
    }

}
