import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {

    JTextField[] letterFields = new JTextField[7];
    
    public GUI() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setTitle("Spelling Bee Shit");
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(null);

        JLabel reqlabel = new JLabel("Required Letter ");
        reqlabel.setBounds(10, 20, 100, 20);
        panel.add(reqlabel);

        JTextField reqtxt = new JTextField();
        reqtxt.setBounds(110, 20, 20, 20);
        panel.add(reqtxt);

        letterFields[0] = reqtxt;

        for (int i = 1; i < 7; i++) {
            JLabel label = new JLabel("Letter "+i);
            label.setBounds(10, 20*(i+1), 100, 20);
            panel.add(label);

            JTextField txt = new JTextField();
            txt.setBounds(110, 20*(i+1), 20, 20);
            panel.add(txt);
            letterFields[i] = txt;
        }

        JButton button = new JButton("Do thing");
        button.setBounds(10, 20*9, 100, 20);
        button.setText("GO");
        button.addActionListener(this);
        panel.add(button);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char[] letters = new char[7];
        boolean hasError = false;
        for (int i = 0; i < 7; i++) {
            String input = letterFields[i].getText().toLowerCase();
            if (input == " " || input == null || input.length() != 1) {
                new ErrorWindow("u did somthing wrong *UWU*");
                hasError = true;
                break;
            }
            letters[i] = input.charAt(0);
        }

        if (!hasError) new WordFinder(letters);
    }

}
