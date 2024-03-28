package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q12605 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        for(int i=0; i<N ; i++){
            String[] temp = reader.readLine().split(" ");
            int len = temp.length;
            System.out.printf("Case #%d: ",i+1);
            for(int j = len-1 ; j >= 0 ; j-- ){
                if(j==len){
                    System.out.print(temp[j]);
                }
                System.out.print(temp[j] + " ");
            }
        }
    }
}
