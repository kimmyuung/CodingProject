package FunctionPrograming.DesignPattern;

import FunctionPrograming.DesignPattern.model.User;
import FunctionPrograming.DesignPattern.service.InternetUserService;
import FunctionPrograming.DesignPattern.service.UserSerivceInFunctionalWay;
import FunctionPrograming.DesignPattern.service.UserService;

import java.util.Arrays;

public class TemplateMethodPattern {
    // 대표적인 행동 패턴
    // 상위 클래스는 알고리즘의 뼈대만을 정의하고 알고리즘의 각 단계는 하위 클래스에게 정의를 위임하는 패턴
    // 알고리즘의 구조를 변경하지 않고 세부 단계들을 유연하게 변경이 가능

    public static void main(String[] args) {
        User user1 = User.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@fastcampus.co.kr";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
                }).build();

        UserService userService = new UserService();
        InternetUserService internetUserService = new InternetUserService();

        //userService.createUser(user1);
        internetUserService.createUser(user1);

        UserSerivceInFunctionalWay userSerivceInFunctionalWay = new UserSerivceInFunctionalWay(
                user -> {
                    System.out.println("validation user " + user.getName());
                    return user.getName() != null && user.getEmailAddress().isPresent();
                },
                user -> {
                    System.out.println("Writing User " + user.getName() + " to DB");
                });
        userSerivceInFunctionalWay.createUser(user1);

    }
}
