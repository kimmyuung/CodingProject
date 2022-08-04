package Day01;

import java.util.Scanner;

public class RestNumberSum_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;
        S[0] = sc.nextInt();
        for(int i = 0; i < N; i++) { // Sum array
            S[i] = S[i - 1] + sc.nextInt();
        }
        for(int i = 0; i < N; i++) { // Sum array -> number % run
            int remainder = (int) (S[i] % M);
            // 0 ~ i Sum -> 0 => answer ++;
            if(remainder == 0) answer++;
            // search remain equal index counting
            C[remainder]++;
        }
        for(int i = 0; i < M; i++) {
            if(C[i] > 1) { //if == equal remain index of two select
                answer = answer + (C[i] * (C[i] -1) ) / 2;
            }
        }
        System.out.print(answer);
    }
}
// 슈도코드 작성
// 1. N 입력받기(수열의 개수)
// 2. M 입력받기(나누어떨어져야 하는 수)
// 3. S 선언하기(합 배열)
// 4. C 선언하기(같은 나머지의 인덱스를 카운트하는 배열)
// 5. for(i -> 1 ~ N) {
// S[i] = S[i - 1] + A[i]
// }
// 6. for(i -> 0 ~ N) {
// remainder = S[i] % M; = 합 배열을 M으로 나눈 나머지 값
// if(remainder == 0) -> 정답을 1증가 시키기
// C[remainder]의 값을 1증가
// }
// 7. for(i -> 0 ~ N) {
//  C[i](i가 나머지인 인덱스의 개수)에서 2가지를 뽑는 경우의 수를 정답에 더하기
// C[i]개 중 2개를 뽑는 경우의 수 계산 공식 C[i] * ( C[i] - 1 ) / 2
// }
