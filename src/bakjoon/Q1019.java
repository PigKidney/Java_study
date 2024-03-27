package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1019 {
    // 숫자가 얼마나 나오는지 담아놓을 배열
    static int page[] = new int[10];
    // 10단위씩 뛰면서 계산하기 위해
    static int count = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int B = Integer.parseInt(reader.readLine());
        int A = 1;

        while (A <= B) {
            //4567
            // 1의 자리를 9로 맞추는 과정 -> 그 과정시 나온 숫자 카운트
            while(B%10 != 9 && A <= B){
                cal(B);
                B--;
            }
            // 시작페이지를 10으로
            while(A%10 != 0 && A <= B) {
                cal(A);
                A++;
            }
            // 10 ~ 4559
            // 1의 자리 9로 맞춘 후 10단위씩 확인하면서 올라간다
            if(A > B) {
                break;
            }

            A /= 10;
            B /= 10;
            
            // 1 ~ 455
            for(int i=0; i<10; i++){
                page[i] += (B-A+1)*count;
            }

            // 한번 진행하고 10자리 100자리는 해당 번호 자리수가 해당번호 자리수 만큼 나온다
            count *= 10;
        }

        for(int i=0; i <10; i++){
            System.out.print(page[i]+ " ");
        }
        
    }

    public static void cal(int cur){
        while(0< cur){
            page[cur % 10] += count;
            cur /= 10;
        }
    }
}