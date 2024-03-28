package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2444 {
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(reader.readLine());
        for(int i=1; i<=line; i++){
            for(int blink=line-i; blink>0; blink--){
                System.out.print(" ");
            }
            for(int j=1; j<=i*2-1 ; j++){
                System.out.print('*');
            }
            System.out.println();
        }

        for(int i=line-1; i>=1; i--){
            for(int blink=line-i; blink>0; blink--){
                System.out.print(" ");
            }
            for(int j=1; j<=i*2-1 ; j++){
                System.out.print('*');
            }
            System.out.println();
        }
        
    }
}
