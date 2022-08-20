package FunctionPrograming.AdvancedStream;

import FunctionPrograming.AdvancedStream.Service.EmailService;
import FunctionPrograming.Optional.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Chapter8Section9 {
    // for Each : stream에 제공된 action을 적용
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 5, 2, 1);
        numbers.forEach(number -> {
            System.out.println("The number is" + number);
        });
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
        List<User> users = Arrays.asList(user1, user2, user3);

        EmailService emailService = new EmailService();
        users.stream()
                .filter(user -> ! user.isVerified())
                .forEach(emailService::sendVerifyEmail);

        for(User user : users) {
            System.out.println("Do an operation on user " + user.getEmailAddress());
        }

        for(int i =0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println("Do an operation on user " + user.getEmailAddress() + "an index " + i);
        }
        // 위와 같음
        IntStream.range(0, users.size()).forEach(i ->
        {
            User user = users.get(i);
            System.out.println("Do an operation on user " + user.getEmailAddress() + "an index " + i);
        });
        // 시작점 끝점 지점하여 범위반복 가능
    }
}
