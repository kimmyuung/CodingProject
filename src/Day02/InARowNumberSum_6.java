package Day02;

import java.util.Scanner;

public class InARowNumberSum_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        while(end_index != N) {
            if(sum == N) {
                count++;
                end_index++;
                sum = sum + end_index;
            }else if(sum > N) {
                sum = sum - start_index;
                start_index++;
            }else {
                end_index++;
                sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}
// 투 포인터 이동 원칙
// sum > N : sum = sum - start_index; start_index++;
// sum < N : end_index++; sum = sum + end_index;
// sum == N : end_index++; sum = sum + end_index; count++;
// 슈도코드
// 1. N 변수 저장
// 2. 사용 변수 초기화(count = 1; start_index = 1; end_index = 1; sum = 1)
// 3. while(end_index != N) {
// if(sum == N) count 증가, end_index 증가, sum 값 변경
// else if(sum > N) sum 값 변경, start_index 증가
// else if(sum < N) end_index 증가, sum값 변경
// }
// count 출력

