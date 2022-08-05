package Day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SlidingWindow_9 {
    static  int checkArr[];
    static  int myArr[];
    static  int checkSecret;
    public static void main(String[] args) {
    try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0;
        char A[] = new char[S];
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0){
                checkSecret++;
            }
        }
        for(int i = 0; i < P; i++){
            Add(A[i]);
        }
        if(checkSecret == 4) Result++;
        for(int i = 0; i < S; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[i]);
            if(checkSecret == 4) {Result++;}
        }
        System.out.println(Result);
        br.close();
    }catch (Exception e){e.printStackTrace();}
    }

    private static void Add(char c){
        switch (c){
            case 'A': myArr[0]++;
                    if(myArr[0] == checkArr[0]) checkSecret++; break;
            case 'C' : myArr[1]++;
            if(myArr[1] == checkArr[1]) checkSecret++; break;
            case 'G' : myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++; break;
            case 'T' : myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++; break;
        }
    }

    private static void Remove(char c) {
        switch (c){
            case 'A':
                if(myArr[0] == checkArr[0]) checkSecret--;  myArr[0]--;break;
            case 'C' :
                if(myArr[1] == checkArr[1]) checkSecret--;  myArr[1]--;break;
            case 'G' :
                if(myArr[2] == checkArr[2]) checkSecret--;  myArr[2]--; break;
            case 'T' :
                if(myArr[3] == checkArr[3]) checkSecret--;  myArr[3]--; break;
        }
    }

}
// 손으로 풀어 보기
// 1. S 배열과 비밀번호 체크 배열을 저장
// 2. 윈도우에 포함된 문자로 현재 상태 배열로 만듦. 그런 다음 현재 상태 배열과 비밀번호 체크 배열을 비교하여
//    유효 비밀번호인지 판단
// 3. 윈도우를 한 칸 씩 이동하며 현재 상태 배열을 업데이트. 현재 상태 배열을 업데이트 한 이후에는 비밀번호 체크
//    배열과 비교하여 비밀번호 유효성을 판단. 현재 상태 배열을 업데이트할 때는 빠지는 문자열, 신규 문자열만 보고
//    업데이트하는 방식으로 진행

// 슈도코드 작성
// 1. S(문자열) , P(부분 문자열의 크기)
// 2. A(문자열 데이터)
// 3. checkArr(비밀번호 체크 해명)
// 변수 선언
// 4. myArr(현재 상태 배열)
// 5. checkSecret(몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수)
// 6. P 범위 ( 0 ~ P - 1) 만큼 S 배열에 적용하고, 유효한 비밀번호인지 판단
// 7. for(i를 P에서 S까지 반복) {
// j 선언(i - P) : 이 부분은 함수로 별도 구현
// 한 칸씩 이동하면서 제거되는 문자열과 새로 들어오는 문자열을 처리하기
// 유효한 비밀번호인지(checkSecret == 4) 판단해 결괏값에 업데이트하기
// }
// 결괏값 출력하기
// 별도 함수
// Add(문자 더하기 함수) {
// 새로 들어온 문자를 myArr에 업데이트하거나 checkSecret 값 변경
// }
// Remove(문자 빼기 함수) {
// 제거되는 문자를 myArr에 업데이트하거나 checkSecret 값 변경
// }
