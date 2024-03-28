package bakjoon;

import java.util.Scanner;

public class Q5717 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        while (true) {
            int M = sc.nextInt();
            int F = sc.nextInt();
    
            int sum = M+F;
            
            if(M == 0 && F == 0){
                break;
            }
            
            System.out.println(sum);
        }
        
    }
}
