package Machine;

import java.util.HashMap;

public class Algorithms {
    protected static final HashMap<String, Character> ALPHABET = new HashMap<>();
    static {
        ALPHABET.put("AAAAA", 'a');
        ALPHABET.put("AAAAB", 'b');
        ALPHABET.put("AAABA", 'c');
        ALPHABET.put("AAABB", 'd');
        ALPHABET.put("AABAA", 'e');
        ALPHABET.put("AABAB", 'f');
        ALPHABET.put("AABBA", 'g');
        ALPHABET.put("AABBB", 'h');
        ALPHABET.put("ABAAA", 'i');
        ALPHABET.put("ABAAB", 'j');
        ALPHABET.put("ABABA", 'k');
        ALPHABET.put("ABABB", 'l');
        ALPHABET.put("ABBAA", 'm');
        ALPHABET.put("ABBAB", 'n');
        ALPHABET.put("ABBBA", 'o');
        ALPHABET.put("ABBBB", 'p');
        ALPHABET.put("BAAAA", 'q');
        ALPHABET.put("BAAAB", 'r');
        ALPHABET.put("BAABA", 's');
        ALPHABET.put("BAABB", 't');
        ALPHABET.put("BABAA", 'u');
        ALPHABET.put("BABAB", 'v');
        ALPHABET.put("BABBA", 'w');
        ALPHABET.put("BABBB", 'x');
        ALPHABET.put("BBAAB", 'y');
        ALPHABET.put("BBBAA", 'z');
    }
    protected static String alphavit = "abcdefghijklmnopqrstuvwxyza";
    protected static  int findIt(char letter) {
        for (int i = 0; i < 26; i++) {
            if (letter == alphavit.charAt(i))
                return i;
        }
        return 0;
    }
    public static int[] findPosition(char c, char[][] keySquare) {
        int[] position = new int[2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keySquare[i][j] == c) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        return null;
    }

}
