package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1019 {
    // 주어지는 페이지 숫자
    private static int totalPage;
    private static int[] nums;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String totalPageStr = reader.readLine(); 

        totalPage = Integer.parseInt(totalPageStr);
        
        nums = new int[10];
        for(int n=0; n<nums.length; n++){
            nums[n] = 0;
        }
        for(int i=0; i<totalPage; i++){
            countNum(totalPage);
        }
        for(int j=0; j<nums.length; j++){
            System.out.print(nums[j]);
        }
    }
    
    private static void countNum(int num){
        while(num>0){
            nums[num%10]++;
            num = num/10;
        }
    }
}