import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {
            System.out.println(Arrays.toString(new String[]{}));
            return;
        }
        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println(Arrays.toString(new String[]{}));
            return;
        }

        String[] words = line.split("\\s+");

        String bestWord = null;
        int bestDistinct = Integer.MAX_VALUE;

        for (String word : words) {
            int distinct = distinctCharCount(word);
            if (distinct < bestDistinct) {
                bestDistinct = distinct;
                bestWord = word;
            }
        }

        if (bestWord == null) {
            System.out.println(Arrays.toString(new String[]{}));
        } else {
            System.out.println(Arrays.toString(new String[]{bestWord}));
        }
    }

    private static int distinctCharCount(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}