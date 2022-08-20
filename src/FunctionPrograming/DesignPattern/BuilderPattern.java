package FunctionPrograming.DesignPattern;

import FunctionPrograming.DesignPattern.model.User;

public class BuilderPattern {
    // 대표적인 생성 패턴
    // 객체의 생성에 대한 로직과 표현에 대한 로직을 분리
    public static void main(String[] args) {
        User user = User.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@fastcampus.co.kr";
                    builder.isVerified = true;
                }).build();
        System.out.println(user);
    }
}
