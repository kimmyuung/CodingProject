package Day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AbsoluteHeap_14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 질의 요청 갯수
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> { // 우선순위 큐 설정
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs) return o1 > o2 ? 1 : -1; // 절댓값이 같으면 음수 우선 정렬
            else return first_abs - second_abs; // 절댓값을 기준으로 정렬
        });
        for(int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request == 0) { // 요청이 0일 때
                if(queue.isEmpty()) { // 큐가 비어 있으면
                    System.out.println("0"); // 0 출력
                }
                else System.out.println(queue.poll()); // 비어 있지 않으면 큐의 front값 출력
            } else { // 요청이 1일 때
                queue.add(request); // 새로운 데이터를 우선순위 큐에 더하기
            }
        }
    }

}
// 문제 푸는 순서
// 1. x = 0
// 큐가 비어 있을 때는 0을 출력하고 비어 있지 않을 때는 절댓값이 최소인 값을 출력. 절댓값이 같으면 음수를 우선하여 출력
// 2. x = 1
// add로 큐에 새로운 값을 추가하고 우선순위 큐 정렬 기준으로 자동 정렬
