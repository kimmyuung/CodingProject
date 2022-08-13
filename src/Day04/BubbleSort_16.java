package Day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort_16 {
// 슈도코드 작성
    // 1. N(데이터 개수) , A(데이터 배열, 단 클래스를 데이터로 담는 배열)
    // 2. for(N만큼 반복) {
    // A 배열 저장
    // }
    // A 배열 정렬
    // 3. for(N만큼 반복) {
    // A[i]의 정렬 전 index - 정렬 후 index 계산의 최댓값을 찾아 저장
    // }
    // 최댓값 + 1 을 정답으로 출력

    // 별도 클래스 선언
    // mData(데이터 표현) {
    // index, value를 가지며
    // value 기준 오름차순 정렬 함수 Comparable 구현
    // }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(reader.readLine());
            mData[] A = new mData[N];
            for(int i = 0; i < N; i++) {
                A[i] = new mData(Integer.parseInt(reader.readLine()), i);
            }
            Arrays.sort(A); // A 뱌욜 정렬 (O(nlogn) 시간 복잡도)
            int Max = 0;
            for(int i = 0; i < N; i++) {
                if(Max < A[i].index - i) Max = A[i].index - i;
                // 정렬 전 index - 정렬 후 index 계산의 최댓값 저장
            }
            System.out.println(Max + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     static class mData implements Comparable<mData> {
        int value;
        int index;

        public mData(int value, int index) {
            super();
            this.value = value;
            this.index = index;

        }

        @Override
        public int compareTo(mData o) { // value 기준 오름차순 정렬
            return this.value - o.value;
        }

    }
}
