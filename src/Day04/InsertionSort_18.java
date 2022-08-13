package Day04;

import java.util.Scanner;

public class InsertionSort_18 {
    // 삽입 정렬 : 이미 정렬된 데이터 범위에 정렬되지 않은 데이터를 적절한 위치에 삽입시켜 정렬하는 방식
    // 평균 시간 복잡도는 O(n2)으로 느린 편이지만 구현하기가 쉬움

    // 핵심 : 선택 데이터를 현재 정렬된 데이터 범위 내에서 적절한 위치에 삽입하는 것
    // 삽입 정렬 수행 방식
    // 1. 현재 index에 있는 데이터 값을 선택
    // 2. 현재 선택한 데이터가 정렬된 데이터 범위에 삽입될 위치를 탐색
    // 3. 삽입 위치부터 index에 있는 위치까지 shift 연산을 수행
    // 4. 삽입 위치에 현재 선택한 데이터를 삽입하고 index++ 연산을 수행
    // 5. 전체 데이터의 크기만큼 index가 커질 때까지, 즉 선택할 데이터가 없을 때까지 반복

    // 적절한 삽입 위치를 탐색하는 부분에서 이진 탐색 등과 같은 탐색 알고리즘을 사용하면 시간 복잡도를 줄일 수 있음

    //
    // ATM 인출 시간 계산
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사람 수
        int[] A = new int[N]; // 자릿수별로 구분해 저장한 배열
        int[] S = new int[N]; // A 합 배열 : 각 사람이 인출을 완료하는 데 필요한 시간을 저장
        for(int i = 0; i < N; i++) { // N만큼 반복
            A[i] = sc.nextInt(); // A 배열 저장하기
        }
        for(int i = 1; i < N; i++) {
            int insert_point = i;
            int insert_value = A[i];
            for(int j = i - 1; j >= 0; j--) {
                if(A[j] > A[i])  {
                    insert_point = j + 1;
                    break;
                }
                if(j == 0) {
                    insert_point = 0;
                }
            }
            for(int j = i; j > insert_point; j--) {
                A[j] = A[j-1];
            }
            A[insert_point] = insert_point;
        }
        S[0] = A[0];
        for(int i = 1; i < N; i++) {
            S[i] = S[i-1] + A[i];
        }
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum = sum + S[i];
        }
        System.out.println(sum);
    }
}
