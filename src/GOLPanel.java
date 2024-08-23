import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GOLPanel extends JPanel {
    private GOLMatrix world;
    private JButton[][] cells;
    private int interval = 200;
    private Timer timer;
    private JLabel lblGenerations;
    private JButton cmdNext;
    private JButton cmdGo;
    private JButton cmdClear;
    private JButton cmdFaster;
    private JButton cmdSlower;


/////////////////////THE CONSTRUCTOR/////////////////////////////
    public GOLPanel(int worldSize) {
        setLayout(new BorderLayout());

        world = new GOLMatrix(worldSize);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(worldSize, worldSize));

        cells = new JButton[worldSize][worldSize];

        for (int row = 0; row < worldSize; row++) {// Making the cells
            for (int col = 0; col < worldSize; col++) {
                JButton cell = new JButton();
                cell.setPreferredSize(new Dimension(20, 20));
                cell.setBackground(world.isCellAlive(row, col) ? Color.BLUE : Color.WHITE);
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                cell.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int row = -1, col = -1;
                        for (int i = 0; i < worldSize; i++) {
                            for (int j = 0; j < worldSize; j++) {
                                if (cells[i][j] == e.getSource()) {
                                    row = i;
                                    col = j;
                                    break;
                                }
                            }
                        }
                        if (row >= 0 && col >= 0) {
                            world.flipCell(row, col);
                            cells[row][col].setBackground(world.isCellAlive(row, col) ? Color.BLUE : Color.WHITE);
                        }
                    }
                });

                cells[row][col] = cell;
                gridPanel.add(cell);
            }
        }

        add(gridPanel, BorderLayout.CENTER);
//
        JPanel controlPanel = new JPanel();
        lblGenerations = new JLabel("Number of generations: " + world.getGenerations());
        cmdNext = new JButton("Next");
        cmdGo = new JButton("Go");
        cmdClear = new JButton("Clear");
        cmdFaster = new JButton("Faster");
        cmdSlower = new JButton("Slower");

        cmdNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextGeneration();
            }
        });

        cmdGo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startSimulation();
            }
        });

        cmdClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearWorld();
            }
        });

        cmdFaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                speedUpSimulation();
            }
        });

        cmdSlower.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                slowDownSimulation();
            }
        });

        controlPanel.add(lblGenerations);
        controlPanel.add(cmdNext);
        controlPanel.add(cmdGo);
        controlPanel.add(cmdClear);
        controlPanel.add(cmdFaster);
        controlPanel.add(cmdSlower);

        add(controlPanel, BorderLayout.NORTH);
    }

    private void nextGeneration() {
        world.nextGeneration();
        updateGenerationsLabel();
        updateCellColors();
    }

    private void startSimulation() {
        if (timer != null && timer.isRunning()) {
            stopSimulation();
        } else {
            timer = new Timer(interval, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    nextGeneration();
                }
            });
            timer.start();
            cmdGo.setText("Stop");
            cmdNext.setEnabled(false);
            cmdClear.setEnabled(false);
            cmdFaster.setEnabled(true);
            cmdSlower.setEnabled(true);
        }
    }

    private void stopSimulation() {
        if (timer != null) {
            timer.stop();
            timer = null;
            cmdGo.setText("Go");
            cmdNext.setEnabled(true);
            cmdClear.setEnabled(true);
            cmdFaster.setEnabled(false);
            cmdSlower.setEnabled(false);
        }
    }

    private void clearWorld() {
        world.clearWorld();
        updateGenerationsLabel();
        updateCellColors();
    }

    private void speedUpSimulation() {
        if (interval > 100) {
            interval -= 20;
            if (timer != null && timer.isRunning()) {
                timer.setDelay(interval);
            }
        }
    }

    private void slowDownSimulation() {
        if (interval < 1000) {
            interval += 20;
            if (timer != null && timer.isRunning()) {
                timer.setDelay(interval);
            }
        }
    }

    private void updateGenerationsLabel() {
        lblGenerations.setText("Number of generations: " + world.getGenerations());
    }

    private void updateCellColors() {
        for (int row = 0; row < world.getSize(); row++) {
            for (int col = 0; col < world.getSize(); col++) {
                cells[row][col].setBackground(world.isCellAlive(row, col) ? Color.BLUE : Color.WHITE);
            }
        }
    }
}
