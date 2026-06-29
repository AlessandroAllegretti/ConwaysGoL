class GameOfLife{
    public static void main(String[] args) {
        int width = 10;
        int length = 10;

        int[][] spielfeld = new int[width][length];

        initRandom(spielfeld, width, length);
        
        for(int gen = 1; gen <= 2; gen++){
            printGrid(spielfeld, width, length);
            spielfeld = nextGen(spielfeld, width, length);
            System.out.println();
        }
    }

    public static void printGrid(int[][] spielfeld, int width, int length){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < length; j++){
                System.out.print(spielfeld[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public static void initRandom(int[][] spielfeld, int width, int length){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < length; j++){
                double zufall = Math.random();

                if(zufall > 0.3) spielfeld[i][j] = 0;
                else spielfeld[i][j] = 1;
            }
        }
    }

    public static int countNeighbours(int[][] spielfeld, int row, int col){
        int count = 0;
        for(int dr = -1; dr<= 1;dr++){
            for(int dc = -1; dc<= 1; dc++){
                int r = row + dr;
                int c = col + dc;
                if(dr == 0 && dc == 0) continue;
                if(r >= 0 && c >= 0 && r < spielfeld.length && c < spielfeld[0].length){
                    if(spielfeld[row+dr][col+dc] == 1) count++;
                }
            }
        }
        return count;
    }

    public static int[][] nextGen(int[][] spielfeld, int width, int length){
        int[][] temp = new int[width][length];
        for(int i = 0; i < width; i++){
            for(int j = 0; j < length; j++){
                int count = countNeighbours(spielfeld, i, j);
                if(spielfeld[i][j] == 1 && count < 2) temp[i][j] = 0;
                if(spielfeld[i][j] == 1 && (count == 2 || count == 3)) temp[i][j] = 1;
                if(spielfeld[i][j] == 1 && count > 3) temp[i][j] = 0;
                if(spielfeld[i][j] == 0 && count == 3) temp[i][j] = 1;
            }
        }

        return temp;
    }
}