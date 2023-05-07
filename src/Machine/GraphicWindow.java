package Machine;
import Machine.ButtonJAction;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicWindow extends JFrame {
    public GraphicWindow() {
        ButtonJAction myAction = new ButtonJAction();
        JFrame frame = new JFrame("Шифровальная машина");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocation(300,100);
        JPanel panel = new JPanel(null);
        frame.add(panel, BorderLayout.CENTER);

        JComboBox box = new JComboBox();
        box.setBounds(630,50,145,30);
        box.addItem("Алгоритм Виженера");
        box.addItem("Квадрат Поллибия");
        box.addItem("Шифр Гронсфельда");
        box.addItem("Алгоритм Плейфера");
        box.addItem("Алгоритм Атбаш");
        box.addItem("Шифр Бэкона");
        box.addItemListener(new ItemChangerListener());
        //System.out.println(box.getItemAt(1));
        panel.add(box);

        JTextArea text = new JTextArea();
        text.setBounds(20,20,600,150);
        panel.add(text);
        JTextField textKey = new JTextField();
        textKey.setBounds(80,175,400,30);
        panel.add(textKey);

        JButton buttonEncrypt = new JButton("Зашифровать");
        buttonEncrypt.setBounds(80, 220, 180, 50);
        buttonEncrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                myAction.buttonActionEncryption(box.getSelectedIndex(), text.getText(), textKey.getText());
            }
        });
        panel.add(buttonEncrypt);

        JButton buttonDecrypt = new JButton("Расшифровать");
        buttonDecrypt.setBounds(350, 350, 180, 50);
        buttonDecrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myAction.buttonActionDecryption(box.getSelectedIndex(),textKey.getText());
            }
        });
        panel.add(buttonDecrypt);

        JButton buttonFile = new JButton("Выбрать файл");
        buttonFile.setBounds(80, 350, 180, 50);
        buttonFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                myAction.buttonActionFile();
            }
        });
        panel.add(buttonFile);

        JLabel titleKey = new JLabel("Ключ: ");
        titleKey.setBounds(35,180,45,10);
        panel.add(titleKey);

        frame.setVisible(true);
    }
}

