package Day01;

import java.util.Scanner;

public class NumberAvg_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        for(int i = 0; i < N; i++){
            if(A[i] > max) max = A[i];
            sum = sum + A[i];
        }
        // 한 과목과 관련된 수식을 총합한 후 관련된 수식으로 변환해 로직이 간단해짐
        System.out.println(sum * 100.0 / max / N);
    }
}
// 슈도 코드 작성
// 1. N 값 입력받기
// 2. 길이 N의 숫자를 입력받아 String형 변수 sNum에 저장하기
// 3. sNum을 다시 char[]형 변수 cNum에 치환하여 저장하기
// 4. int형 변수 sum 선언하기
// 5. for(cNum 길이만큼 반복하기) {
// 배열의 각 자리값을 정수형으로 변환하여 sum에 더하여 누적하기
// }
// sum 출력하기
