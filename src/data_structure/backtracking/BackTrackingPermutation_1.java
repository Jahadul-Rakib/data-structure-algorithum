package data_structure.backtracking;

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
