package Day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class NGESolving_12 {
    public static void main(String[] args) {
        // 스택에 새로 들어오는 수가 top에 존재하는 수보다 크면 그 수는 오큰수가 됨
        // 오큰수를 더한 후 수열에서 오큰수가 존재하지 않는 숫자에 -1을 출력해야 함

        // 푸는 순서
        // 1. 스택에 채워져 있거나 A[index] > A[top]인 경우 pop한 인덱스를 이용하여 정답 수열에 오큰수를 저장
        // pop은 조건을 만족하는 동안 계속 반복하고, 과정 1을 마치면 과정 2로 넘어감
        // 2. 현재 인덱스를 스택에 push하고 다음 인덱스로 넘어감
        // 3. 과정 1~2를 수열 길이만큼 반복한 다음 현재 스택에 남아 있는 인덱스에 -1을 저장
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine()); // 수열의 갯수
            int[] A = new int[n]; // 수열 배열 생성
            int[] ans = new int[n]; // 정답 배열 생성
            String[] str = br.readLine().split(" ");
            for(int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(str[i]);
            }
            Stack<Integer> mystack = new Stack<>();
            mystack.push(0); // //최초 스택 초기화하기
           for(int i = 1; i < n; i++) { //
               while (!mystack.isEmpty() && A[mystack.peek()] < A[i]) {
                   // 스택이 비어 있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 큰 경우
                   ans[mystack.pop()] = A[i]; // 정답 배열에 오큰수를 현재 수열로 저장
               }
               mystack.push(i); // 신규 데이터 push
               while(!mystack.isEmpty()) {
                   // 반복문 종료 후 스택이 비어 있지 않다면 빌 때까지
                   ans[mystack.pop()] = -1;
                   // 스택에 쌓인 index에 -1 입력
               }
           }
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           for(int i = 0; i < n; i++)  {
               bw.write(ans[i] + " "); // 출력
           }
           bw.write("\n");
           bw.flush();
        }catch(Exception e){e.printStackTrace();}
    }
}
