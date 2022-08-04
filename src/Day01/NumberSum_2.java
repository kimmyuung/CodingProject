package Day01;

import java.util.Scanner;

public class NumberSum_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 입력값을 String형 변수 sNum에 저장한 후 char[]형 변수로 변환하기
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0'; // cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적하기
        }
        System.out.print(sum);
    }
}
// 슈도코드 작성하기
// 1. 변수 N에 과목의 수 입력받기
// 2. 길이가 N인 1차원 배열 A[] 선언하기
// 3. for(A[] 길이만큼 반복) {
// A[i]에 각 점수 사용하기
// }
// 4. for(A[] 길이만큼 반복) {
// 최고점은 변수 max, 총점은 변수 sum에 저장
// }
// sum * 100 / max / N 출력


// 형변환
// String sNum = '1234';
// int i1 = Integer.parseInt(sNum);
// int i2 = Integer.valueOf(sNum);
// double d = Double.valueOf(sNum);
// float f = Float.valueOf(sNum);
// long l = Long.parseLong(sNum);
// short s = Short.parseShort(sNum);
