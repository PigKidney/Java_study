package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1978 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] temp = reader.readLine().split(" ");
        int count = 0;
        for(int i = 0; i<N ; i++){
            int num = Integer.parseInt(temp[i]);
            if(isPrime(num)){
                count++;
            };
        }
        System.out.println(count);
    }

    private static boolean isPrime(int num){
        if(num == 1){
            return false;
        }

        for(int i=2 ; i<num; i++){
            if(num%i==0){
                return false;
            };
        }

        return true;
    }
}
