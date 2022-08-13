package Day04;

import java.util.Scanner;

public class SelectionSort_17 {
    // 선택정렬 : 대상 데이터에 최대나 최소 데이터를 데이터가 나열된 순으로 찾아가며 선택하는 방법
    // 가장 구현 방법이 복잡하고, 시간 복잡도도 O(n2)으로 효율적이지 않아 많이 사용하지는 않음

    // 핵심 : 최솟값 또는 최댓값을 찾고, 데이터와 swqp하는 것이 선택정렬의 핵심

    // 선택정렬 과정
    // 1. 남은 정렬 부분에서 최솟값 또는 최댓값을 찾음
    // 2. 남은 정렬 부분에서 가장 앞에 있는 데이터와 선택된 데이터를 swap 함
    // 3. 가장 앞에 있는 데이터의 위치를 변경해(index++) 남은 정렬 부분의 범위를 축소
    // 4. 전체 데이터 크기만큼 index가 커질 때까지, 즉 남은 정ㄹ려 부분이 없을 때까지 반복

    // 내림차순으로 자릿수 정렬
    // 1. 자연수를 받아 자릿수별로 정렬
    // 2. 숫자를 각 자릿수별로 나누는 작업이 필요
    // 3. --> 입력값을 String으로 받은 후 substring() 함수를 사용해 자릿수 단위를 분리 후 다시 int형으로 전환
    // 4. 배열에 저장 후 배열을 정렬

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();  // str(정렬할 수)
        int[] A = new int[str.length()];   // A(자릿수별로 구분해 저장할 배열)
        for(int i = 0; i < str.length(); i++) { // for(str길이만큼 반복)
            // A 배열 저장 -> str.subestring() 사용
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        for(int i = 0; i < str.length(); i++) { // for(i : 0 ~ str의 길이만큼 반복)
            int Max = i;
            for(int j = i + 1; j < str.length(); j++) { //  for(j: i + 1 ~ str의 길이만큼 반복)
                if(A[j] > A[Max]) Max = j;  //  현재 범위에서 Max 값 찾기

            }
            if(A[i] < A[Max]) {   // 현재 i의 값과 Max값 중 Max값이 더 크면 swap 수행
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        for(int i = 0; i < str.length(); i++) {
            System.out.println(A[i]);  // A 배열 출력
        }
    }

    }

