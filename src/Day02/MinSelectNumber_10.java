package Day02;

import java.io.*;
import java.util.*;

public class MinSelectNumber_10 {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Deque<Node> mydeque = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                int now = Integer.parseInt(st.nextToken());
                while (!mydeque.isEmpty() && mydeque.getLast().value > now)
                {
                mydeque.removeLast();
                }
                mydeque.addLast(new Node(now, i));
                // out of range number is remove from deck
                if(mydeque.getFirst().index <= i - L){
                    mydeque.removeFirst();
                }
                bw.write(mydeque.getFirst().value + " ");
            }
            bw.flush();
            bw.close();
        }catch (Exception e){e.printStackTrace();}
    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
/*
 문제 분석
 덱 : 양 끝에서 데이터를 삽입하거나 삭제할 수 있는 자료구조
 왼쪽 : addFirst(), removeFirst() // 오른쪽 : addLast(), removeLast()

 덱에서는 (인덱스, 숫자) 형태의 노드를 클래스로 구현하여 저장

 슈도 코드 작성
 1. N(데이터 개수), L(최솟값을 구하는 범위)
 2. Deque<Node> mydeque(데이터를 담을 덱 자료구조)
 3. 배열 선언
 4. for(N만큼 반복) {
 now(현재 데이터 값)
 덱의 마지막 위치에서부터 now보다 큰 값은 덱에서 제거
 덱의 마지막 위치에 now값 저장
 덱의 1번째 위치에서부터 L의 범위를 벗어난 값(now index-L <= index)를 덱에서 제거하기
 덱의 1번째 데이터 출력하기
 }
 덱에 저장할 노드 클래스 별도 생성
 노드 클래스에는 index(자신의 위치), value(자신의 값) 담기
*/
