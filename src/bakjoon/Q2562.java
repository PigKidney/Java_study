package bakjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2562 {
    private static int max;
    private static int index;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList list = new ArrayList();

        for(int i=0; i<9 ; i++){
            list.add(sc.nextInt());
        }

        max = (int) list.get(0);
        index = 1;
        for(int i=0; i<9; i++){
            int num = (int) list.get(i);
            if(num > max){
                max = num;
                index = i+1;
            }
        }

        System.out.println(max);
        System.out.println(index);

    }
}
