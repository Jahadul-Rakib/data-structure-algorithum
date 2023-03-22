package data_structure.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class BackTrackingPermutation_1 {
    public static void main(String[] args) {
        List<String> randomLetter = Arrays.asList("-1-", "-2-", "-3-");
        List<String> objectList = new ArrayList<>();
        getAllPossibleCombination(randomLetter, "", objectList);
        objectList.forEach(System.out::println);


        String inputString = "abc";
        List<String> stringList = new ArrayList<>();
        getAllPossibleCharacterCombination(inputString, "", stringList);
        stringList.forEach(System.out::println);

        //leetcode: problem number46
        int[] input = new int[]{1, 2, 3};
        List<List<Integer>> listList = permute(input);
        assert listList != null;
        listList.forEach(integers -> System.out.println(integers.toString()));

    }

    public static List<List<Integer>> permute(int[] input) {
        if (!(1 <= input.length && input.length <= 6))
            return null;
        List<Integer> integers = new ArrayList<>();
        for (int j : input) {
            if (-10 <= j && j <= 10) {
                integers.add(j);
            } else {
                return null;
            }

        }

        List<List<Integer>> output = new ArrayList<>();
        findAllPossibleCombination(integers, List.of(), output);
        //output.forEach(System.out::println);
        return output;
    }

    private static void findAllPossibleCombination(List<Integer> input, List<Integer> tempArray, List<List<Integer>> output) {
        if (input.size() == 0) {
            output.add(tempArray);
        }

        for (int i = 0; i < input.size(); i++) {
            Integer currentDigit = input.get(i);

            List<Integer> list = new ArrayList<>();
            list.addAll(input);
            list.remove(currentDigit);

            List<Integer> integerList = new ArrayList<>();
            integerList.addAll(tempArray);
            integerList.add(currentDigit);

            findAllPossibleCombination(list, integerList, output);
        }
    }


    private static void getAllPossibleCombination(List<String> allBoys, String currentParam, List<String> combinationBoys) {
        if (allBoys.size() == 0) {
            combinationBoys.add(currentParam);
        }

        for (int i = 0; i < allBoys.size(); i++) {
            String currentBoy = allBoys.get(i);

            List<String> currentLeft = new ArrayList<>(allBoys);
            currentLeft.remove(currentBoy);

            getAllPossibleCombination(currentLeft, currentParam + currentBoy, combinationBoys);
        }
    }

    private static void getAllPossibleCharacterCombination(String inputString, String temp, List<String> stringList) {
        if (inputString.length() == 0)
            stringList.add(temp);

        for (int i = 0; i < inputString.length(); i++) {
            char currentCharacter = inputString.charAt(i);
            String nextString = inputString.substring(0, i) + inputString.substring(i + 1);
            String newTemp = currentCharacter + temp;
            getAllPossibleCharacterCombination(nextString, newTemp, stringList);
        }
    }

}
