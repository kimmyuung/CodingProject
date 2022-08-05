package Day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoodNumber_8 {
    public static void main(String[] args) {
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(bf.readLine());
            int result = 0;
            long A[] = new long[N];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i = 0; i < N; i++) {
                A[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(A);
            for(int k = 0; k < N; k++) {
                long find = A[k];
                int i = 0;
                int j = N - 1;
            while(i < j) {
            if(A[i] + A[j] == find) {
                if(i != k && j != k){
                    result++;
                    break;
                }else if(i == k){ i++;}
                else if(j == k) {j--;}
                else {j--;}
            }
            }
            }
            System.out.println(result);
            bf.close();
        }catch (Exception e){e.printStackTrace();}
    }
}
// 손으로 풀어보기
// 1. 수를 입력받아 배열에 저장한 후 정렬
// 2. 투 포인터 i, j를 배열 A 양쪽 끝에 위치시키고 조건에 적합한 후 투 포인터 이동 원칙을 활용해 탐색을 수행
//    판별의 대상이 되는 수는 K라고 가정
// A[i] + A[j] > K; j--; A[i] + A[j] < K; i++;
// A[i] + A[j] == K; i++; j--; count++;
// 3. 2단계를 배열의 모든 수에 대하여 반복. K가 N이 될 때까지 반복하며 좋은 수가 몇 개인지 셈
