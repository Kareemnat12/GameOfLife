import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Animation Example");
            AnimationPanel panel = new AnimationPanel();
            frame.getContentPane().add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setVisible(true);
        });
    }
}
