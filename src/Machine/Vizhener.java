package Machine;

public class Vizhener extends Algorithms {
    public static String encryptionVizhener(String msg, String key)
    {
        String encryptedMessage = "";
        int count = 0;
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == ' ')
            {
                encryptedMessage += ' ';
                continue;
            }
            encryptedMessage += alphavit.charAt((findIt(key.charAt(count++%key.length())) + findIt(msg.charAt(i))) % 26);
        }
        return encryptedMessage;
    }
    public static String decryptVizhener(String cipherText,String key)
    {
        String encryptedMessage = "";
        int count = 0;
        for (int i = 0; i < cipherText.length(); i++) {
            if (cipherText.charAt(i) == ' ')
            {
                encryptedMessage += ' ';
                continue;
            }
            encryptedMessage += alphavit.charAt((findIt(cipherText.charAt(i))-findIt(key.charAt(count++%key.length()))+26) % 26);
        }
        return encryptedMessage;
    }
}
