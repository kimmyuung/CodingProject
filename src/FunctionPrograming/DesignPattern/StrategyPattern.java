package FunctionPrograming.DesignPattern;

import FunctionPrograming.DesignPattern.model.User;
import FunctionPrograming.DesignPattern.service.EmailProvider;
import FunctionPrograming.DesignPattern.service.EmailSender;
import FunctionPrograming.DesignPattern.service.MaksMoreFriendsEmailProvider;
import FunctionPrograming.DesignPattern.service.VerifiyYourEmailAddressEmailProvider;

import java.util.Arrays;
import java.util.List;

public class StrategyPattern {
    // 전략패턴
    // 대표적인 행동 패턴
    // 런타임에 어떤 전략(알고리즘)을 사용할 지 선택할 수 있게 해줌
    // 전략들을 캡슐화하여 간단하게 교체 가능하게 함
    public static void main(String[] args) {
        User user1 = User.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@fastcampus.co.kr";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
                }).build();

        User user2 = User.builder(2, "Bob")
                .with(builder -> {
                    builder.emailAddress = "bob@fastcampus.co.kr";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList( 211, 212, 213, 214);
                }).build();

        User user3 = User.builder(3, "Charlie")
                .with(builder -> {
                    builder.emailAddress = "charlie@fastcampus.co.kr";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212);
                }).build();

        List<User> users = Arrays.asList(user1, user2, user3);

        EmailSender emailSender = new EmailSender();
        EmailProvider verifiyYourEmailAddressProvider = new VerifiyYourEmailAddressEmailProvider();
        EmailProvider makeMoreFriendEmailProvider = new MaksMoreFriendsEmailProvider();

        emailSender.setEmailProvider(verifiyYourEmailAddressProvider);
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(makeMoreFriendEmailProvider);
        users.stream()
                .filter(User::isVerified)
                .filter(user -> user.getFriendUserIds().size() <= 5)
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(user -> "play with Friends's email for " + user.getName());

        users.stream()
                .filter(user -> !user.isVerified())
                .filter(user -> user.getFriendUserIds().size() > 5)
                .forEach(emailSender::sendEmail);


    }
}
