package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q15552 {
    private static int T;
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(reader.readLine());
        for(int i=0; i<T; i++){
            String[] temp = reader.readLine().split(" ");
            writer.write(Integer.parseInt(temp[0])+Integer.parseInt(temp[1]) + "\n");
        };
        reader.close();

        writer.flush();
        writer.close();
        
    }
}
