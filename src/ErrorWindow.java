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

        panel.setLayout(null);

        JLabel error = new JLabel(msg);
        error.setBounds(20, 20, 500, 20);
        panel.add(error);

        frame.setVisible(true);
    }

}
