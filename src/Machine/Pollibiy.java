package Machine;

public class Pollibiy extends Algorithms {

    private static String[] kvadrat ={ "abcde","fghik","lmnop","qrstu","vwxyz"};
    public static String encryptPollibiy(String msg)
    {
        String encryptedMessage = "";
        for (int h = 0;h<msg.length();h++)
        {
            if (msg.charAt(h) == ' ')
            {
                encryptedMessage += ' ';
                continue;
            }
            if (msg.charAt(h) == 'j')
            {
                encryptedMessage += "24";
                continue;
            }
            for (int i = 0;i<5;i++)
            {
                for (int j = 0;j<5;j++)
                {
                    if (msg.charAt(h) == kvadrat[i].charAt(j))
                    {
                        encryptedMessage += Integer.toString((i+1))+Integer.toString((j+1));
                    }
                }
            }
        }
        return encryptedMessage;
    }
    public static String decryptPollibiy(String msg)
    {
        String encryptedMessage = "";
        for (int i = 0; i < msg.length(); i += 2) {
            if (msg.charAt(i) == ' ')
            {
                i--;
                encryptedMessage +=' ';
                continue;
            }
            int row = msg.charAt(i) - '1';
            int col = msg.charAt(i + 1) - '1';
            encryptedMessage += kvadrat[row].charAt(col);
        }
        return encryptedMessage;
    }
}
