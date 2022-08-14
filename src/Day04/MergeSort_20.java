package Day04;

import java.io.*;

public class MergeSort_20 {
    // 병합 정렬 : 분할 정복 방식을 사용해 데이터를 분할하고 분할한 집합을 정렬하며 합치는 알고리즘
    // 시간 복잡도 평균값은 O(nlogn)입니다.

    // 최초에는 정렬을 원하는 데이터 각각의의 그룹으로 나눔
    // 데이터 총 / 2개씩 그룹을 합치며 오름차순 정렬
    // ex) 1 -> 2 -> 4 -> 8
    // 전체를 오름차순으로 정렬할때까지 반복

    // 2개의 그룹을 병합하는 과정
    // 투 포인터 개념을 사용하여 왼쪽, 오른쪽 그룹을 병합
    // 왼쪽 포인터와 오른쪽 포인터의 값을 비교하여 작은 값을 결과 배열에
    // 추가하고 포인터를 오른쪽으로 1칸 이동시킴

    // 수 정렬
    public static int[]A, tmp;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 정렬할 수의 갯수
        A = new int[N+1]; // 정렬할 배열 선언
        tmp = new int[N+1]; // 정렬할 때 잠시 임시로 사용할 배열
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine()); // 데이터 저장
        }
        merget_sort(1, N); // 병합 정렬 함수 수행
        for(int i = 1; i <= N; i++) {
            bw.write(A[i] + "\n"); // 결과 값 출력
        }
        bw.flush();
        bw.close();
    }

    private static void merget_sort(int s, int e) { // 병합 정렬
        // s : 시작, e : 종료
        if(e - s < 1) return;
        int m = s + (e - s) / 2; // 중간지점
        // 재귀 함수 형태로 구현
        merget_sort(s, m);
        merget_sort(m + 1, e);
        for(int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }
        int k = s;
        int index1 = s; // 앞쪽 그룹 시작점
        int index2 = m + 1; // 뒤쪽 그룹 시작점
        while(index1 <= m && index2 <= e) { // 두 그룹을 병합
            // 양쪽 그룹의 index가 가리키는 값을 비교한 후 더 작은 수를 선택해 배열에 저장하고,
            // 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동
            // 반복문의 끝난 후 남아 있는 데이터 정리
            if(tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            }else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while(index1 <= m) { // 한쪽 그룹이 모두 선택된 후에 남아 있는 값 정리
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
