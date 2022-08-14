package Day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort_19 {
    // 퀵 정렬 : 기준값(pivot)을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해 정렬하는 알고리즘
    // 기준값이 어떻게 선정되는지가 시간 복잡도에 많은 영향을 미치고, 평균적인 시간 복잡도는 O(nlogn)임

    // 퀵 정렬의 핵심 이론 : pivot을 중심으로 계속 데이터를 2개의 집합으로 나누면서 정렬하는 것이 퀵 정렬의 핵심

    // 퀵 정렬의 핵심
    // 1. 데이터를 분할하는 pivot을 설정
    // 2. pivot을 기준으로 다음 a-e 과정을 거쳐 데이터를 2개의 집합으로 분리
        // 2-1. start가 가리키는 데이터가 pivot이 가리키는 데이터보다 작으면 start를 오른쪼으로 1칸 이동
        // 2-2. end가 가리키는 데이터가 pivot이 가리키는 데이터보다 크면 end를 왼쪽으로 1칸 이동
        // 2-3. start가 가리키는 데이터가 pivot이 가리키는 데이터보다 크고, end가 가리키는 데이터가 pivot이
        //      가리키는 데이터보다 작으면 start, end가 가리키는 데이터를 swap하고 start는 오른쪽, end는 왼쪽으로 1칸 이동
        // 2-4. start와 end가 만날 때까지 2-1 ~ 2-3를 반복
        // 2-5. start와 end가 만나면 만난 지점에서 가리키는 데이터와 pivot이 가리키는 데이터를 비교하여 pivot이 가리키는 데이터가
        //      크면 만난 지점의 오른쪽에, 적으면 만난 지점의 왼쪽에 pivot이 가리키는 데이터를 삽입
    // 3. 분리 집합에서 각각 다시 pivot을 선정
    // 4. 분리 집합이 1개 이하가 될 때까지 1~3을 반복
    // ==> 시간 복잡도는 비교적 준수하므로 코딩 테스트에서도 종종 응용

    // K번째 수 구하기
    public static void main(String[] args) throws IOException {
        // pivot을 정하는 방법
        // pivot == K : K번째 수를 찾은 것이므로 알고리즘을 종료
        // pivot > K : pivot의 왼쪽 부문에 K가 있으므로 왼쪽(S ~ pivot -1)만 정렬을 수행
        // pivot < K : pivot의 오른쪽 부문에 K가 있으므로 오른쪽(pivot -1 ~ E)만 정렬을 수행
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken()); // 숫자의 갯수
        int K = Integer.parseInt(st.nextToken()); // K번째 수
        st = new StringTokenizer(in.readLine());
        int[] A = new int[N]; // 숫자 데이터 저장 배열
        for(int i = 0; i < N; i++) { // N만큼 반복
            A[i] = Integer.parseInt(st.nextToken()); // A배열 저장
        }
        quickSort(A, 0, N - 1, K - 1); // 퀵 소트 실행
        System.out.println(A[K - 1]); // K번째 데이터 출력
    }

    public static void quickSort(int[] A, int S, int E, int K) { // 정렬 함수
    if(S < E) {
        int pivot = partition(A, S, E); // 기준 구하기 함수
        if(pivot == K) return; // K번째 수가 기준이면 더 이상 구할 필요 없음
        else if(K < pivot) quickSort(A, S, pivot - 1, K); // K가 기준보다 작으면 왼쪽 그룹만 정렬 수행
        else quickSort(A, pivot + 1, E, K); // K가 기준보다 크면 오른쪽 그룸만 정렬 수행
    }
    }

    public static int partition(int[] A, int S, int E) { // 기준 구하기 함수
        int M = (S + E) / 2; // 중앙값을 기준으로 설정
        swap(A, S, M); //  중앙값을 1번째 요소로 이동
        int pivot = A[S];
        int i = S, j = E; // 시작점과 종료점을 설정
        while( i < j) {
            while (pivot < A[j]) { // 기준보다 작은 수가 나올 때까지 j--
                j--;
            }

        while(i < j && pivot >= A[i]) { // 기준보다 큰 수가 나올 때까지 i++
            i++;
        }
        swap(A, i, j); // 찾은 i와 j를 교환
        }
        // i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정
        A[S] = A[i]; // 기준 데이터를 나눠진 두 그룹의 경계 index에 저장
        A[i] = pivot;
        return i;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
