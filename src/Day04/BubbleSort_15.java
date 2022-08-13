package Day04;

import java.util.Scanner;

public class BubbleSort_15 {
    // 버블 정렬 : 두 인접한 데이터의 크리글 비교해 정렬하는 방법
    // --> 간단하게 구현이 가능하지만 시간 복잡도는 다른 정렬 알고리즘보다 속도가 느린 편
    // --> 루프를 돌면서 인접한 데이터 간의 swap 연산으로 정렬

    // 과정
    // 1. 비교 연산이 필요한 루프 범위를 설정
    // 2. 인접한 데이터 값을 비교
    // 3. swap 조건에 부합하면 swap 연산을 수행
    // 4. 루프 범위가 끝날 때까지 2~3번 반복
    // 5. 정렬 영역을 설정. 다음 루프를 실행할 때는 이 영역을 제외
    // 6. 비교 대상이 없을 때까지 1~5번 반복
    // --> 종료

    // 슈도코그 작성
    // N(정렬할 수 개수)
    // A(정렬할 배열 선언)
    // for(i : 0 ~ N - 1)
    // {for(j : 0 ~ N - 1 - i) {
    // 현재 A 배여ㅛㄹ의 값보다 1칸 오른쪽 배ㅔ열의 값이 더 작으면 두 수 바꾸기
    // }
    // }
    // A 배열 출력
    // 예제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int []A = new int[N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; i < N - 1 - i; j++) {
                if(A[j] > A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        for(int i = 0; i < N; i++) {
            System.out.println(A[i]);
        }
    }
}
