import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorWindow {
    
    public ErrorWindow(String msg) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setTitle("ERROR");
        frame.add(panel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();  
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;  
        int y = (screenSize.height - frame.getHeight()) / 2;  
        frame.setLocation(x, y);

        panel.setLayout(null);

        JLabel error = new JLabel(msg);
        error.setBounds(20, 20, 500, 20);
        panel.add(error);

        frame.setVisible(true);
    }

}
