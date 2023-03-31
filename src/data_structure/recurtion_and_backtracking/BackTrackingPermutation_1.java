package data_structure.recurtion_and_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        String givenInput = "ABC";
        List<String> expectedOutput = new ArrayList<>();

        findAllPermutationAccordingToLexicographically(givenInput, "", expectedOutput);
        expectedOutput.sort(String::compareTo);
        expectedOutput.forEach(System.out::println);

        // leetcode problem: 567
        boolean checkInclusion = checkInclusion("ab", "eidbaooo");
        System.out.println(checkInclusion);
        boolean checkInclusion2 = checkInclusion("ab", "eidboaoo");
        System.out.println(checkInclusion2);
        boolean checkInclusion3 = checkInclusion("dinitrophenylhydrazine", "acetylphenylhydrazine");
        System.out.println(checkInclusion3);

    }

    public static boolean checkInclusion(String s1, String s2) {
        return findAllPermutation(s1, s2);
    }

    private static boolean findAllPermutation(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String current = String.valueOf(chars[i]);
            if (!s2.contains(current)) return false;
        }
        return true;
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


    private static void findAllPermutationAccordingToLexicographically(String givenInput, String tempValue, List<String> expectedOutput) {
        if (givenInput.length() == 0) {
            expectedOutput.add(tempValue);
        }

        for (int i = 0; i < givenInput.length(); i++) {
            char currentValue = givenInput.charAt(i);
            String nextInputString = givenInput.substring(0, i) + givenInput.substring(i + 1);

            String currentTempValue = currentValue + tempValue;
            findAllPermutationAccordingToLexicographically(nextInputString, currentTempValue, expectedOutput);
        }
    }

}
