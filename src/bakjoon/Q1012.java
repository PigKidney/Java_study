package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Q1012{
    // 배추밭 가로 길이(x)
    private static int M;

    // 배추밭 세로 길이(y)
    private static int N;

    // 배추밭
    private static int area[][];

    // 구역 방문 여부
    private static boolean isVisit[][];

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 케이스 수
        int T = Integer.parseInt(reader.readLine());
        
        for(int i=0; i<T; i++){
            String[] temp = reader.readLine().split(" ");

            M = Integer.parseInt(temp[0]);
            N = Integer.parseInt(temp[1]);

            // 배추 갯수
            int K = Integer.parseInt(temp[2]);

            area = new int[M][N];

            isVisit = new boolean[M][N];

            int bugs = 0;

            for(int j=0; j<K; j++){
                temp = reader.readLine().split(" ");
                int x = Integer.parseInt(temp[0]);
                int y = Integer.parseInt(temp[1]);

                area[x][y] = 1;
            }

            for(int x=0; x<M; x++){
                for(int y=0; y<N; y++){
                    if(area[x][y] == 1 && !isVisit[x][y]){
                       bugs++; 

                       dfs(x, y);
                    }
                }
            }

            System.out.println(bugs);

        }
    }

    private static void dfs(int x , int y){
        //x의 상하 좌우 이동
        int[] dx = {0, 0, -1, 1};
        //y의 상하 좌우 이동
        int[] dy = {-1, 1, 0, 0};

        isVisit[x][y] = true;

        for(int i=0; i<4; i++){
            int xn = x + dx[i];
            int yn = y + dy[i];

            if((xn > -1 && xn < M) && (yn > -1 && yn < N) && area[xn][yn] == 1 && !isVisit[xn][yn]){
                dfs(xn, yn);
            }
        }
    }
}