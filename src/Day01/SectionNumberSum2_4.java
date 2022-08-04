package Day01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SectionNumberSum2_4 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int A[][] = new int[N + 1][N + 1];
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= N; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int D[][] = new int[N+1][N+1];
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <=N; j++){
                    //Section Sum
                    D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
                }
            }
            for(int i =1; i <= N; i++){
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                // Section Sum array
            int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
            System.out.println(result);
            }
        }catch(Exception e){e.printStackTrace();}
    }
}
// 슈도코드 작성하기
// 1. N(배열 크기) M(질문 수) 저장하기
// 2. for(N만큼 반복하기) {
// for(N만큼 반복하기) {
//  원본 배열 저장하기
//  }
// }
// 3. for(N만큼 반복하기) {
// for(N만큼 반복하기) {
//  합 배열 저장하기
//  D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
//  }
// }
// 4. for(M만큼 반복하기) {
// 질문 계산 및 출력
// result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
// }