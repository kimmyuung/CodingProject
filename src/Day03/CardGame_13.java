package Day03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CardGame_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myque = new LinkedList<>();
        int N = sc.nextInt();
        for(int i = 0; i <= N; i++) { // 카드를 큐에 저장
            myque.add(i);
        }
        while(myque.size() > 1) { // 카드가 1장 남을 때까지
            myque.poll(); // 맨 위의 카드를 버림
            myque.add(myque.poll()); // 맨 위의 카드를 가장 아래 카드 밑으로 이동
        }
        System.out.println(myque.poll()); // 마지막으로 남은 카드 출력
    }
}
// 문제 푸는 순서
// 1. poll을 수행하여 맨 앞의 카드를 버림
// 2. 과정 1에 이어 바로 add를 수행하여 맨 앞에 있는 카드를 맨 아래로 옮김
// 3. 큐의 크기가 1이 될 때까지 과정 1 ~ 2를 반복 후 큐에 남은 원소를 출력