package Day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointerEx_7 {
    public static void main(String[] args) {
        try{
            BufferedReader br
                    = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            StringTokenizer stringTokenizer
                    = new StringTokenizer(br.readLine());
            for(int i=0; i < N; i++){
                A[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Arrays.sort(A);
            int count = 0;
            int i = 0;
            int j = N - 1;
            while(i < j){
                if(A[i] + A[j] < M){
                    i++;
                }else if(A[i]+A[j] > M) {
                    j--;
                } else {count++; i++; j--;}
            }
            System.out.println(count);
            br.close();
        }catch(Exception e){e.printStackTrace();}
    }
}
// 투 포인터 이동 원칙
// A[i] + A[j] > M: j--;  // 번호의 합이 M보다 크므로 큰 번호 index를 내림
// A[i] + A[j] < M: i++;  // 번호의 합이 M보다 작으므로 작은 번호 index를 올림
// A[i] + A[j] == M: i++; j--; count++; // 양쪽 포인터를 모두 이동시키고 count를 증가
// 슈도코드 작성
// 1. N(재료의 개수), M(갑옷이 되는 번호) 저장
// 2. for(N만큼 반복) {
// 재료 배열 저장하기
// }
// 재료 배열 정렬하기
// while(i < j) {
// if(재료 합 < M) 작은 번호 재료를 한 칸 위로 변경하기
// else if(재료 합 > M) 큰 번호 재료를 한 칸 아래로 변경하기
// else 경우의 수 증가, 양쪽 index 각각 변경하기
// }
// count 출력하기
