import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WordsGUI {

    int MAX_WORDS_PER_COLUMN = 40;
    
    public WordsGUI(ArrayList<String> words) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setSize(700, 900);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setLayout(null);

        JLabel title = new JLabel("Found " + words.size() + " words");
        title.setBounds(20, 10, 600, 20);
        panel.add(title);

        for (int i = 0; i < words.size(); i++) {
            JLabel label = new JLabel(words.get(i));
            label.setBounds((int) ( 30 + (100 * (Math.floor( i/MAX_WORDS_PER_COLUMN ))+1) ), (int) 40 + (20*( i%MAX_WORDS_PER_COLUMN )), 200, 20);
            panel.add(label);

        }

        frame.setVisible(true); 

    }

}
