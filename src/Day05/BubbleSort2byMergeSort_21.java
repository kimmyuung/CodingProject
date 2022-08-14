package Day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BubbleSort2byMergeSort_21 {
    // 슈도 코드



    // for(N의 개수만큼) {
    // A 배열 선언
    // }
    // 병합 정렬 함수 수행
    // 결괏값 출력
    // 병합 정렬(s, e) {
    // s(시작점), e(종료점), m(중간점)
    // 재귀함수 형태로 구현
    // 병합 정렬(s, m)
    // 병합 정렬(m + 1, e)
    // for(s ~ e) {
    // tmp 배열 저장하기
    // }
    // 두 그룹을 병합하는 로직
    // index1 : 앞쪽 그룹 시작점
    // index2 : 뒤쪽 그룹 시작점
    // while(index1 <= 중간점 && index2 <= 종료점) {
    // 뒤쪽 데이터 값이 더 작아 선택될 때
    // swap이 일어났다고 가정하고, 현재 남아 있는 앞쪽 데이터 개수만큼 결괏값을 더함
    // }
    // 반복문이 끝난 후 남아 있는 데이터 정리하기
    // }
    public static int[] A, tmp;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N(정렬할 수 개수)
        A = new int[N+1]; // A(정렬할 배열 선언)
        tmp = new int[N+1]; // tmp(정렬할 때 잠시 사용할 임시 배열 선언)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        merge_sort(1, N);
        System.out.println(result);
    }
    private static void merge_sort(int s, int e) {
        if(e - s < 1) return;
        int m = s + (e - s) / 2;
        merge_sort(s, m);
        merge_sort(m + 1, e);
        for(int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while (index1 <= m && index2 <= e) {
            if(tmp[index1] > tmp[index2]){
                A[k] = tmp[index2];
                result = result + index2 - k;
                k++;
                index2++;
            }else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) {
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
