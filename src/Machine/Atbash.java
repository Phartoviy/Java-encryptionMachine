package Machine;

public class Atbash extends Algorithms {
    public static String encryptAtbash(String msg)
    {
        String encryptedMessage = "";
        for (int i = 0;i<msg.length();i++)
        {
            if (msg.charAt(i) == ' ')
            {
                encryptedMessage += ' ';
                continue;
            }
            encryptedMessage += alphavit.charAt(26 - findIt(msg.charAt(i))-1);
        }
        return encryptedMessage;
    }
    public static String decryptAtbash(String msg)
    {
        String encryptedMessage = "";
        for (int i = 0;i<msg.length();i++)
        {
            if (msg.charAt(i) == ' ')
            {
                encryptedMessage += ' ';
                continue;
            }
            encryptedMessage += alphavit.charAt(26 - findIt(msg.charAt(i))-1);
        }
        return encryptedMessage;
    }
}
