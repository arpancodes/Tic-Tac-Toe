import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter cells:");
//        String inputString = scanner.nextLine();
//        String[] pattern = inputString.split("(?!^)");
        String[][] maze = new String[3][3];

        int count = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                maze[i][j] = " ";
                count++;
            }
        }

        String currentPlayer = "X";
        printMaze(maze);
        while(!(checkRow(maze) || checkColumn(maze) || checkDiagonal1(maze) || checkDiagonal2(maze) || checkDraw(maze)) || checkImpossible(maze)){
            String x, y;
            do{
                System.out.println("Enter the coordinates:" );
                x = scanner.next();
                y = scanner.next();
                if(!(isNumeric(x) || isNumeric(y))){
                    System.out.println("You should enter numbers!");
                }else if(Integer.parseInt(x) < 1 || Integer.parseInt(x) > 3 || Integer.parseInt(y) < 1 || Integer.parseInt(y) > 3 ){
                    System.out.println("Coordinates should be from 1 to 3!");
                }
                else if(!maze[Integer.parseInt(x) - 1][Integer.parseInt(y) - 1].equals(" ")){
                    System.out.println("This cell is occupied! Choose another one!");
                } else
                    break;
            } while(true);

            int xCoord =  Integer.parseInt(x);
            int yCoord =  Integer.parseInt(y);

            maze[xCoord - 1][yCoord - 1] = currentPlayer;
            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            printMaze(maze);


        }

//        if(!checkImpossible(maze)) {
//            if (!(checkRow(maze) || checkColumn(maze) || checkDiagonal1(maze) || checkDiagonal2(maze))){
//                if(!checkDraw(maze)){
//                    System.out.println("Game not finished");
//                }
//            }
//        }

    }

    public static boolean checkRow(String[][] maze){
        boolean anyoneWins = false;
        int wins = 0;
        String won = "";
        for(int i = 0; i < 3; i++){
            String player = maze[i][0];
            boolean playerWon = true;
            for(int j = 1; j < 3; j++){
                if (!player.equals(maze[i][j]) || player.equals(" ")){
                    playerWon = false;
                    break;
                }
            }
            if(playerWon){
                anyoneWins = true;
                won = player;
                wins++;
            }
        }
        if (wins > 1){
            System.out.println("Impossible");
            return true;
        }
        if (anyoneWins){
            System.out.println(won + " wins");
            return true;
        }
        return false;
    }

    public static boolean checkColumn(String[][] maze){
        boolean anyoneWins = false;
        int wins = 0;
        String won = "";
        for(int i = 0; i < 3; i++){
            String player = maze[0][i];
            boolean playerWon = true;
            for(int j = 1; j < 3; j++){
                if (!player.equals(maze[j][i]) || player.equals(" ")){
                    playerWon = false;
                    break;
                }
            }
            if(playerWon){
                anyoneWins = true;
                won = player;
                wins++;
            }
        }
        if (wins > 1){
            System.out.println("Impossible");
            return true;
        }
        if (anyoneWins){
            System.out.println(won + " wins");
            return true;
        }
        return false;
    }

    public static boolean checkDiagonal1(String[][] maze){
        boolean anyoneWins = false;
        String won = "";
        String player = maze[0][0];
        if (player.equals(maze[1][1]) && player.equals(maze[2][2]) && !player.equals(" "))
        {
            anyoneWins = true;
            won = player;
        }
        if (anyoneWins){
            System.out.println(won + " wins");
            return true;
        }
        return false;
    }


    public static boolean checkDiagonal2(String[][] maze){
        boolean anyoneWins = false;
        String won = "";
        String player = maze[2][2];
        if (player.equals(maze[1][1]) && player.equals(maze[2][0]) && !player.equals(" "))
        {
            anyoneWins = true;
            won = player;
        }
        if (anyoneWins){
            System.out.println(won + " wins");
            return true;
        }
        return false;
    }

    public static boolean checkImpossible(String[][] maze){
        int Xs = 0, Os = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(maze[i][j].equals("X")) Xs++;
                if(maze[i][j].equals("O")) Os++;
            }
        }

        if(Xs + 1 < Os || Os + 1 < Xs){
            System.out.println("Impossible");
            return true;
        }
        return false;
    }

    public static boolean checkDraw(String[][] maze){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(maze[i][j].equals(" ")) return false;
            }
        }
        System.out.println("Draw");
        return true;
    }

    public static void printMaze(String[][] maze){
        System.out.print("---------");
        for (int i = 0; i < 3; i++){
            System.out.println();
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(maze[i][j]+ " ");
            }
            System.out.print("|");
        }
        System.out.println();
        System.out.println("---------");
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
