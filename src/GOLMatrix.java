public class GOLMatrix {

    boolean [][] world;
    int generation;
    boolean[][] copied;
    int n=0;
///////////////Constructor////////////////////////
    public GOLMatrix(int n) {
       this.n=Math.max(n,3);

        world = new boolean[n][n];
        reset(world);
    }

    public int getSize() {
        return n;
    }

    ////////////To start/ reset the array to false ////////////
    private void reset (boolean[][]world){
        for(int i =0;i<world.length;i++){
            for (int j =0; j<world[i].length;j++)
                world[i][j]=false;
        }
        generation=0;
    }
/////////////Getters//////////////////////
    public boolean[][] getWorld() {
        return world;
    }

    public int getGenerations() {
        return generation;
    }




///////////Clear World/////////////////////////
    public void clearWorld(){
        reset(this.world);
}


/////////////CELL FLIP/////////////////////
    public void flipCell(int row,int col) {
        boolean booleancell = world[row][col];
        world[row][col] = !booleancell;


    }

//////////////////////////////////////////////////////we must make a new array that we do all changes ion it

    public void nextGeneration() {
        copied = copyArr(world);
        int colBound = world.length;
        int rowBound = world[0].length;

        for (int i = 0; i < colBound; i++) {
            for (int j = 0; j < rowBound; j++) {
                int counter = countNeighbors(i, j);
                if (counter == 3 || (counter == 2 && copied[i][j])) {
                    world[i][j] = true;
                } else {
                    world[i][j] = false;
                }
            }
        }
        generation++;
    }

    private int countNeighbors(int row, int col) {
        int counter = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue; // Skip the current cell
                }
                int neighborRow = row + i;
                int neighborCol = col + j;
                if (isValidCell(neighborRow, neighborCol) && copied[neighborRow][neighborCol]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < world.length && col >= 0 && col < world[0].length;
    }




 ////////////////////////////////////////////////////////////////
 /*
//public void nextGeneration() {
//int counter=0;
//    for(int i =0;i<world.length;i++){
//        for (int j =0; j<world[i].length;j++){
//            int col_bound=world[i].length;
//            int row_bound=world.length;
//            counter+=world[i][j++]==true&&j++<row_bound?1:0;//right cell
//            counter+=world[i][j--]==true&&j-->0?1:0;//left cell
//            counter+=world[i--][j]==true&&i-->0?1:0;//upper cell
//            counter+=i++<col_bound&&world[i++][j]==true?1:0;//downer cell
//
//            counter+=world[i--][j++]==true&&i-->0&&j++<row_bound?1:0;//right up cell
//            counter+=world[i++][j++]==true&&i++<col_bound&&j++<row_bound?1:0;//right down cell
//            counter+=i-->0&&j-->0&&world[i--][j--]==true?1:0;// left upper cell
//            counter+=i++<col_bound&&j-->0&&world[i++][j--]==true?1:0;//downer left cell
//
//            if(counter==3|| counter ==2 && copied[i][j]==false)
//                flipCell(i,j);
//
//        }
//    }
//
//    world[n][n]=copied[n][n];



}
*/
    /////
 private boolean[][] copyArr(boolean[][] world) {
     int col = world.length;
     int row = world[0].length;
     copied = new boolean[col][row];
     for (int i = 0; i < col; i++) {
         for (int j = 0; j < row; j++) {
             copied[i][j] = world[i][j];
         }
     }
     return copied;
 }

    public boolean isCellAlive(int row, int col) {
     return world[row][col]==true;
    }


    ////
//private boolean[][] copyArr(boolean[][] world){
//        int col = world[0].length;
//        int row = world.length;
//      copied =new boolean[col][row];
//    for(int i =0;i<copied.length;i++){
//        for (int j =0; j<copied[i].length;j++)
//            copied[i][j]=world[i][j];
//    }
//    return copied;

}










