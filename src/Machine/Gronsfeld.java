package Machine;

public class Gronsfeld extends Algorithms {
    public static String encryptGronsfeld(String msg, String key) {
        String keyWord = key;
        String encryptedMessage = "";
        while (keyWord.length() < msg.length()) {
            keyWord += key;
        }
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == ' ')
            {
                encryptedMessage += ' ';
                continue;
            }
            encryptedMessage += alphavit.charAt((Character.getNumericValue(keyWord.charAt(i)) + findIt(msg.charAt(i))) % 26);
        }
        return encryptedMessage;
    }
    public static String decryptGronsfeld(String msg, String key) {
        String keyWord = key;
        String encryptedMessage = "";
        while (keyWord.length() < msg.length()) {
            keyWord += key;
        }
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == ' ') {
                encryptedMessage += ' ';
                continue;
            }
            encryptedMessage += alphavit.charAt((findIt(msg.charAt(i)) -Character.getNumericValue(keyWord.charAt(i))+26) % 26);
        }
        return encryptedMessage;
    }
}
