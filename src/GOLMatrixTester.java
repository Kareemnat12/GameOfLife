public class GOLMatrixTester {

    public static void copyMatrixToGolMatrix(boolean[][] b, GOLMatrix golMatrix){
        for (int i = 0; i < b.length; i++)
            for (int j = 0 ; j < b[0].length; j++)
                if ((b[i][j] && !golMatrix.getWorld()[i][j]) || (!b[i][j] && golMatrix.getWorld()[i][j]))
                    golMatrix.flipCell(i,j);
    }

    public static boolean compareMatrixToGolMatrix(boolean[][] b, GOLMatrix golMatrix){
        for (int i = 0; i < b.length; i++)
            for (int j = 0 ; j < b[0].length; j++)
                if (b[i][j] != golMatrix.getWorld()[i][j])
                    return false;
        return true;
    }

    public static void printMatrix(boolean[][] b) {
        StringBuilder string = new StringBuilder();
        for (boolean[] booleans : b) {
            for (int j = 0; j < b.length; j++)
                string.append(booleans[j]).append("\t");
            string.append("\n");
        }
        System.out.println(string);
    }

    public static void printMatrix(GOLMatrix golMatrix) {
        boolean[][] b = golMatrix.getWorld();
        StringBuilder string = new StringBuilder();
        for (boolean[] booleans : b) {
            for (int j = 0; j < b.length; j++)
                string.append(booleans[j]).append("\t");
            string.append("\n");
        }
        System.out.println(string);
    }

    public static void main(String[] args) {
        boolean noErrors = true;

        GOLMatrix golMatrix = new GOLMatrix(3);


        boolean[][] test1Before = {{true, false, true},
                                    {false, false, false},
                                    {true, false, true}};

        copyMatrixToGolMatrix(test1Before, golMatrix);
        if (!compareMatrixToGolMatrix(test1Before, golMatrix)) {
            System.out.println("there seems to be a problem with the flipCell function or the initialization. please make sure those are working well first");
            noErrors = false;

        }
        boolean[][] test1After = {{false, false, false},
                {false, false, false},
                {false, false, false}};

        golMatrix.nextGeneration();
        if (golMatrix.getGenerations() != 1) {
            System.out.println("Generations amount is supposed to be 1 and you got: " + golMatrix.getGenerations() + "\n");
            noErrors = false;
        }

        if (!compareMatrixToGolMatrix(test1After, golMatrix)){
            System.out.println("Applying nextGeneration on the matrix:");
            printMatrix(test1Before);
            System.out.println("Expected:");
            printMatrix(test1After);
            System.out.println("Got:");
            printMatrix(golMatrix);
            System.out.println();
            noErrors = false;
        }




        boolean[][] test2Before = {{false, true, false},
                {false, true, false},
                {false, true, false}};
        copyMatrixToGolMatrix(test2Before, golMatrix);
        if (!compareMatrixToGolMatrix(test2Before, golMatrix)) {
            System.out.println("there seems to be a problem with the flipCell function or the initialization. please make sure those are working well first");
            noErrors = false;
        }

        boolean[][] test2After = {{false,false,false},
                {true, true, true},
                {false, false, false}};
        golMatrix.nextGeneration();
        if (golMatrix.getGenerations() != 2) {
            System.out.println("Generations amount is supposed to be 2 and you got: " + golMatrix.getGenerations() + "\n");
            noErrors = false;
        }
        if (!compareMatrixToGolMatrix(test2After, golMatrix)){
            System.out.println("Applying nextGeneration on the matrix:");
            printMatrix(test2Before);
            System.out.println("Expected:");
            printMatrix(test2After);
            System.out.println("Got:");
            printMatrix(golMatrix);
            System.out.println();
            noErrors = false;
        }


        boolean[][] test3Before = {{true, true, true},
                {true, false, true},
                {true, true, true}};
        copyMatrixToGolMatrix(test3Before, golMatrix);
        if (!compareMatrixToGolMatrix(test3Before, golMatrix)) {
            System.out.println("there seems to be a problem with the flipCell function or the initialization. please make sure those are working well first");
            noErrors = false;
        }

        boolean[][] test3After = {{true, false, true},
                {false, false, false},
                {true, false, true}};

        golMatrix.nextGeneration();
        if (golMatrix.getGenerations() != 3) {
            System.out.println("Generations amount is supposed to be 3 and you got: " + golMatrix.getGenerations() + "\n");
            noErrors = false;
        }
        if (!compareMatrixToGolMatrix(test3After, golMatrix)){
            System.out.println("Applying nextGeneration on the matrix:");
            printMatrix(test3Before);
            System.out.println("Expected:");
            printMatrix(test3After);
            System.out.println("Got:");
            printMatrix(golMatrix);
            System.out.println();
            noErrors = false;
        }

        boolean[][] test4Before = {{true, true, true},
                {true, true, true},
                {true, true, true}};
        copyMatrixToGolMatrix(test4Before, golMatrix);
        if (!compareMatrixToGolMatrix(test4Before, golMatrix)) {
            System.out.println("there seems to be a problem with the flipCell function or the initialization. please make sure those are working well first");
            noErrors = false;

        }

        boolean[][] test4After = {{true, false, true},
                {false, false, false},
                {true, false, true}};
        golMatrix.nextGeneration();
        if (golMatrix.getGenerations() != 4) {
            System.out.println("Generations amount is supposed to be 4 and you got: " + golMatrix.getGenerations() + "\n");
            noErrors = false;
        }
        if (!compareMatrixToGolMatrix(test4After, golMatrix)){
            System.out.println("Applying nextGeneration on the matrix:");
            printMatrix(test4Before);
            System.out.println("Expected:");
            printMatrix(test4After);
            System.out.println("Got:");
            printMatrix(golMatrix);
            System.out.println();
            noErrors = false;
        }



    if (noErrors)
        System.out.println("Well Done no Errors in this tester!");
    }
}
