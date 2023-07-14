import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WordsGUI {

    int MAX_WORDS_PER_COLUMN = 40;
    
    public WordsGUI(ArrayList<String> words, long time) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setSize(700, 900);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();  
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;  
        int y = (screenSize.height - frame.getHeight()) / 2;  
        frame.setLocation(x, y);

        panel.setLayout(null);

        JLabel title = new JLabel("Found " + words.size() + " words (took "+time+"ms)");
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
