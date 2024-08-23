import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
public class AnimationPanel extends JPanel {
    private JButton cmdStart, cmdStop, cmdFaster, cmdSlower;
    private int x;
    private  int INTERVAL = 5;
    private Timer timer;
    public AnimationPanel() {
        cmdStart = new JButton("Start");
        cmdStop = new JButton("Stop");
        cmdFaster = new JButton("Faster");
        cmdSlower = new JButton("Slower");
        JPanel buttons = new JPanel();
        buttons.add(cmdStart);
        buttons.add(cmdStop);
        buttons.add(cmdFaster);
        buttons.add(cmdSlower);

        setLayout(new BorderLayout());
        add(buttons, BorderLayout.SOUTH);
        Listener lis = new Listener();
        timer = new Timer(100, lis);
        cmdStart.addActionListener(lis);
        cmdStop.addActionListener(lis);
        cmdFaster.addActionListener(lis);
        cmdSlower.addActionListener(lis);
        x = 0;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(x, getHeight() / 2, 50, 50);
    }

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == timer) {
                x += INTERVAL;
                if(x <= 0 || x + 50 >= getWidth())
                    INTERVAL *= -1;
                repaint();
            }
            else if(e.getSource() == cmdStart)
                timer.start();
            else if(e.getSource() == cmdStop)
                timer.stop();
            else if(e.getSource() == cmdFaster) {
                if(timer.getDelay() > 30)
                    timer.setDelay(timer.getDelay() - 10);
            }
            else if(e.getSource() == cmdSlower)
                timer.setDelay(timer.getDelay() + 10);
        }
    }
}
