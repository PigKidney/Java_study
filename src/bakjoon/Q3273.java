package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q3273 {
    private static int N;
    private static int X;

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        String[] temp = reader.readLine().split(" ");
        X = Integer.parseInt(reader.readLine());
        int arr[] = new int[N];

        for(int i = 0; i< N ; i++){
            int num = Integer.parseInt(temp[i]);
            if(num < X){
                arr[i] =  num;
            }
        }
        Arrays.sort(arr);

    
        System.out.print(findPairCount(arr,X));
    }

    private static int findPairCount(int[] arr, int num){
        int count = 0;
        int left = 0;
        int right = arr.length-1;
        
        while(left < right){
            int sum = arr[left] + arr[right];
            
            if(sum < X){
                left++;
            } else if(sum > X){
                right--;
            } else {
                count++;
                left++;
                right--;
            }
        }
        return count;
    }
}
