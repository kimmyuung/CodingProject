package Day03;

import java.util.Scanner;
import java.util.Stack;

public class StackAscendingNumber_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;
        for(int i = 0; i < A.length; i++) {
            int su = A[i];
            if(su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+ \n");
                }
            stack.pop();
            bf.append("- \n");
            }
            else {
                int n = stack.pop();
                if(n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    bf.append("- \n");
                }
            }
        }
        if(result) System.out.println(bf.toString());
    }
    // 스택 연산 수행 방법
    // 1. 현재 수열 값 >= 자연수
    // 현재 수열 값이 자연수보다 크거나 같을 떄까지 자연수를 1씩 증가시키며 자연수를 스택에 push
    // push가 끝나면 수열을 출력하기 위해 마지막 1회만 pop
    // 2. 현재 수열 값 < 자연수
    // 현재 수열 값보다 자연수가 크다면 pop으로 스택에 있는 값을 꺼냄. 꺼낸 값이 현재 수열 값이거나 아닐 수 있음
    // 만약 아니라면 후입선출 원리에따라 수열을 표현할 수 없으므로 NO를 출력한 후 문제를 종료하고, 현재 수열 값이라면
    // 그대로 조건문을 빠져나감
    // 슈도 코드
    // 1. N : 수열 개수 // A[](수열 배열)
    // 2. 수열 배열 채우기
    // 3. for(N만큼 반복) {
    // if(현재 수열 값 <= 오름차순 자연수) {
    // while(값이 같아질 때까지) {
    //      push(); (+) 저장}
    //  }
    // pop(); (-) 저장
    // }
    // else {
    // pop();
    // if(스택 pop 출력값 > 수열의 수) NO 출력
    // else {(-) 저장}
    // }
    // if(- 값 출력한 적 없을시) 저장 값 출력
}
