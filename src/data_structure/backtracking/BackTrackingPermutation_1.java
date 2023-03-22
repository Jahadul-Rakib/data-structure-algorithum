package data_structure.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingPermutation_1 {
    public static void main(String[] args) {
        List<String> randomLetter = Arrays.asList("-1-", "-2-", "-3-");
        List<String> objectList = new ArrayList<>();
        printAllPossibleAns(randomLetter, "", objectList);
        objectList.forEach(System.out::println);

    }

    private static void printAllPossibleAns(List<String> allBoys, String currentParam, List<String> combinationBoys) {
        if (allBoys.size() == 0) {
            combinationBoys.add(currentParam);
        }

        for (int i = 0; i < allBoys.size(); i++) {
            String currentBoy = allBoys.get(i);

            List<String> currentLeft = new ArrayList<>(allBoys);
            currentLeft.remove(currentBoy);

            printAllPossibleAns(currentLeft, currentParam + currentBoy, combinationBoys);
        }
    }
}
