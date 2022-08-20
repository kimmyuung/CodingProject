package FunctionPrograming.AdvancedStream;

import FunctionPrograming.AdvancedStream.Service.EmailService;
import FunctionPrograming.Optional.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter8Section10 {
    // Parallel Stream
    // Sequential vs Parallel
    // 기본은 Sequential
    // 여러개의 스레드를 이용하여 stream의 처리 과정을 병렬화
    // 중간 과정은 병렬 처리 되지만 순서가 있는 Stream의 경우 종결 처리 했을
    // 때의 결과물이 기존의 순차적 처리와 일치하도록 종결 처리과정에서 조정
    // List로 collect하면 순서가 항상 올바르게 나옴

    // 장점 : 굉장히 간단하게 병렬처리 사용 가능하게 함, 속도가 비약적으로 빠름
    // 단점 : 항상 속도가 빠른것은 아님, 공통으로 사용하는 리소스가 있을 경우 잘못된 결과가
    // 나오거나 오류가 날 수도 있음
    // 이를 막기 위해 mutex, semaphore 등 병렬 처리 기술 이용시 속도가 느려질 수 있음
    public static void main(String[] args) {
        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@fastcampus.co.kr");
        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@fastcampus.co.kr");
        User user4 = new User()
                .setId(104)
                .setName("David")
                .setVerified(true)
                .setEmailAddress("david@fastcampus.co.kr");
        User user5 = new User()
                .setId(105)
                .setName("Eve")
                .setVerified(false)
                .setEmailAddress("eve@fastcampus.co.kr");
        User user6 = new User()
                .setId(106)
                .setName("Frank")
                .setVerified(false)
                .setEmailAddress("frank@fastcampus.co.kr");

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);
       long startTime = System.currentTimeMillis();
       long endTime = System.currentTimeMillis();
       EmailService emailService = new EmailService();
       users.stream().parallel()
                       .filter(user -> !user.isVerified())
                               .forEach(emailService::sendVerifyEmail);
       System.out.println("Parallel Time taken : " + (endTime - startTime) + "ms");

       List<User> processedUsers = users.parallelStream()
               .map(user -> {
                   System.out.println("Capitaliz user name for users " + user.getId());
                   user.setName(user.getName().toUpperCase());
                   return user;
               })
               .map(user -> {
                   System.out.println("Capitaliz user name for users " + user.getId());
                   user.setVerified(true);
                   return user;
               })
               .collect(Collectors.toList());
       // 순서가 뒤죽박죽 실행되지만 최종 출력은 순서가 정렬되어 출력
    }
}
