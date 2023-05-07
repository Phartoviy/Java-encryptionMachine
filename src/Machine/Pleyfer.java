package Machine;

public class Pleyfer extends Algorithms {

    public static char[][] generateKeySquare(String keyword) {
        char[][] keySquare = new char[5][5];
        String defaultAlphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        String key = keyword + defaultAlphabet;
        // Remove duplicates from the key
        key = key.chars().distinct().mapToObj(c -> String.valueOf((char) c)).reduce("", String::concat);
        // Fill the key square with the key
        int i = 0, j = 0;
        for (char c : key.toCharArray()) {
            keySquare[i][j] = c;
            if (++j == 5) {
                j = 0;
                i++;
            }
        }
        return keySquare;
    }


    public static String encryptPleyf(String plaintext, char[][] keySquare) {
        plaintext = plaintext.replaceAll("J", "I").replaceAll("\\s+", "");
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i += 2) {
            char char1 = plaintext.charAt(i);
            char char2 = i + 1 < plaintext.length() ? plaintext.charAt(i + 1) : 'X';
            int[] char1Pos = findPosition(char1, keySquare);
            int[] char2Pos = findPosition(char2, keySquare);

            if (char1Pos[0] == char2Pos[0]) {
                ciphertext.append(keySquare[char1Pos[0]][(char1Pos[1] + 1) % 5]);
                ciphertext.append(keySquare[char2Pos[0]][(char2Pos[1] + 1) % 5]);
            } else if (char1Pos[1] == char2Pos[1]) {
                ciphertext.append(keySquare[(char1Pos[0] + 1) % 5][char1Pos[1]]);
                ciphertext.append(keySquare[(char2Pos[0] + 1) % 5][char2Pos[1]]);
            } else {
                ciphertext.append(keySquare[char1Pos[0]][char2Pos[1]]);
                ciphertext.append(keySquare[char2Pos[0]][char1Pos[1]]);
            }
        }
        return ciphertext.toString();
    }
    public static String decryptPleyf(String ciphertext, char[][] keySquare)
    {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i += 2) {
            char char1 = ciphertext.charAt(i);
            char char2 = ciphertext.charAt(i + 1);
            int[] char1Pos = findPosition(char1, keySquare);
            int[] char2Pos = findPosition(char2, keySquare);

            if (char1Pos[0] == char2Pos[0]) {
                plaintext.append(keySquare[char1Pos[0]][(char1Pos[1] + 4) % 5]);
                plaintext.append(keySquare[char2Pos[0]][(char2Pos[1] + 4) % 5]);
            } else if (char1Pos[1] == char2Pos[1]) {
                plaintext.append(keySquare[(char1Pos[0] + 4) % 5][char1Pos[1]]);
                plaintext.append(keySquare[(char2Pos[0] + 4) % 5][char2Pos[1]]);
            } else {
                plaintext.append(keySquare[char1Pos[0]][char2Pos[1]]);
                plaintext.append(keySquare[char2Pos[0]][char1Pos[1]]);
            }
        }
        return plaintext.toString();
    }
}
