import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cells:");
        String inputString = scanner.nextLine();
        String[] pattern = inputString.split("(?!^)");
        String[][] maze = new String[3][3];

        int count = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                maze[i][j] = pattern[count];
                count++;
            }
        }
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

        if(!checkImpossible(maze)) {
            if (!(checkRow(maze) || checkColumn(maze) || checkDiagonal1(maze) || checkDiagonal2(maze))){
                if(!checkDraw(maze)){
                    System.out.println("Game not finished");
                }
            }
        }

    }

    public static boolean checkRow(String[][] maze){
        boolean anyoneWins = false;
        int wins = 0;
        String won = "";
        for(int i = 0; i < 3; i++){
            String player = maze[i][0];
            boolean playerWon = true;
            for(int j = 1; j < 3; j++){
                if (!player.equals(maze[i][j])){
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
                if (!player.equals(maze[j][i])){
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
        for(int i = 1, j = 1; i < 3 && j < 3 ; i++, j++){
            String player = maze[0][0];
            if (!player.equals(maze[j][i]))
                break;

            anyoneWins = true;
            won = player;
            break;
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
        for(int i = 1, j = 1; i > -1 && j < 3 ; i--, j++){
            String player = maze[0][2];
            if (!player.equals(maze[j][i]))
                break;

            anyoneWins = true;
            won = player;
            break;
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
                if(maze[i][j].equals("_")) return false;
            }
        }
        System.out.println("Draw");
        return true;
    }

}
