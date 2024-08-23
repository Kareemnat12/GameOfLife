import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

//        GOLMatrix matrix = new GOLMatrix(5);
//
//        // Set some cells as alive
//        matrix.flipCell(1, 2);
//        matrix.flipCell(2, 2);
//        matrix.flipCell(3, 2);
//        matrix.flipCell(4, 2);
//
//
//        // Print the initial world state
//        System.out.println("Generation " + matrix.getGeneration());
//        printWorld(matrix.getWorld());
//
//        // Generate the next generation
//        matrix.nextGeneration();
//
//        // Print the updated world state
//        System.out.println("Generation " + matrix.getGeneration());
//        printWorld(matrix.getWorld());
//
//        matrix.nextGeneration();
//
//        System.out.println("Generation " + matrix.getGeneration());
//        printWorld(matrix.getWorld());
//    }
//
//    private static void printWorld(boolean[][] world) {
//        for (boolean[] row : world) {
//            for (boolean cell : row) {
//                System.out.print(cell ? "X " : "- ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        int worldSize = 50; // Adjust the size of the world as desired

        JFrame frame = new JFrame("Game of Life");
        GOLPanel golPanel = new GOLPanel(worldSize);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(golPanel);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setVisible(true);

    }

}