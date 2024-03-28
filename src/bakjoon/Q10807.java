package bakjoon;

import java.io.IOException;
import java.util.Scanner;

public class Q10807 {
    private static int N;
    private static int V;
    
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N ; i++){
            arr[i] = sc.nextInt();
        }

        V = sc.nextInt();
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == V){
                count++;
            }
        }

        System.out.print(count);
    }

}
