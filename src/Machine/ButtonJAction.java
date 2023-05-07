package Machine;
import Machine.GraphicWindow;
import javax.swing.*;

import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

//import static Machine.Algorithms.generateKeySquare;

public class ButtonJAction extends Component {

    public String encrypt;

    public char[][] keySquare;
    public ButtonJAction(){};
    public Algorithms Algoritm = new Algorithms();
    public void buttonActionFile() {
        // реализация действий для кнопки 1
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Открыть файл");
        fc.showOpenDialog(this);
        System.out.println(fc.getSelectedFile());
        try(FileReader reader = new FileReader(fc.getSelectedFile()))
        {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){

                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
                encrypt = String.copyValueOf(buf);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public void buttonActionEncryption(int indexAlg, String msg, String key) {
        // реализация действий для кнопки 2
        //System.out.println(key);

        msg = msg.toLowerCase();
        String result = "";
        switch(indexAlg)
        {
            case 0:
            {
                msg = msg.toLowerCase();
                result = Vizhener.encryptionVizhener(msg, key);
                break;
            }
            case 1:
            {
                msg = msg.toLowerCase();
                result = Pollibiy.encryptPollibiy(msg);
                break;
            }
            case 2:
            {
                msg = msg.toLowerCase();
                result = Gronsfeld.encryptGronsfeld(msg, key);
                break;
            }
            case 3:
            {
                key = key.toUpperCase().replaceAll("J", "I");
                keySquare = Pleyfer.generateKeySquare(key);
                msg = msg.toUpperCase();
                result = Pleyfer.encryptPleyf(msg,keySquare);
                break;
            }
            case 4:
            {
                msg = msg.toLowerCase();
                result = Atbash.encryptAtbash(msg);
                break;
            }
            case 5:
            {
                msg = msg.toLowerCase();
                //result = Algoritm.bekkon(msg);
                break;
            }
        }
        try(FileWriter writer = new FileWriter("notes.txt", false))
        {
            writer.write(result);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Файл сформирован");
    }

    public void buttonActionDecryption(int index,String key) {
        // реализация действий для кнопки 3
        switch(index)
        {
            case 0:
            {
                System.out.println(Vizhener.decryptVizhener(encrypt,key));
                break;
            }
            case 1:
            {
                System.out.println(Pollibiy.decryptPollibiy(encrypt));
                break;
            }
            case 2:
            {
                System.out.println(Gronsfeld.decryptGronsfeld(encrypt,key));
                break;
            }
            case 3:
            {
                System.out.println(Pleyfer.decryptPleyf(encrypt,keySquare));
                break;
            }
            case 4:
            {
                System.out.println(Atbash.decryptAtbash(encrypt));
                break;
            }
            case 5:
            {
                //System.out.println(Algoritm.decryptBekkon(encrypt));
                break;
            }
        }
    }

}

