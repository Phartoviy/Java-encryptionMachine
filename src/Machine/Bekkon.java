package Machine;

public class Bekkon extends Algorithms {
    public static String encryptionBekkon(String msg) {

        String encryptedMessage = "";
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            /*if (c == ' ')
            {
                encryptedMessage += ' ';
                continue;
            }*/
            if (ALPHABET.containsValue(c)) {
                for (String key : ALPHABET.keySet()) {
                    if (ALPHABET.get(key) == c) {
                        encryptedMessage += key;
                        break;
                    }
                }
            } else {
                encryptedMessage += c;
            }
        }
        return encryptedMessage;
    }
    public static String decryptBekkon(String text)//make obrbotku probelov
    {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        int i = 0;
        while (i < text.length()) {
            String letter = text.substring(i, i + 5);
            if (ALPHABET.containsKey(letter)) {
                result.append(ALPHABET.get(letter));
            } else {
                result.append(letter);
            }
            i += 5;
        }
        return result.toString();
    }
}
