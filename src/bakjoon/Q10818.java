package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10818 {
    private static int N;
    private static int max;
    private static int min;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        max = Integer.parseInt(temp[0]);
        min = Integer.parseInt(temp[0]);
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(temp[i]);
            if(max < num){
                max = num;
            } else if(min > num){
                min = num;
            }
        }

        System.out.printf("%d %d", min, max);
    }
}
