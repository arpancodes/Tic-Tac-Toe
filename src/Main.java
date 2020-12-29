import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cells:");
        String inputString = scanner.nextLine();
        String[] pattern = inputString.split("(?!^)");
        System.out.print("---------");
        for (int i = 0; i < pattern.length; i++){
            if(i % 3 == 0) {
                System.out.println();
                System.out.print("| ");
            }
            System.out.print(pattern[i] + " ");
            if((i+1)%3==0) System.out.print("|");
        }
        System.out.println();
        System.out.println("---------");
    }
}
