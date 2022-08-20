package FunctionPrograming.DesignPattern.service;

import FunctionPrograming.DesignPattern.model.User;

public class VerifiyYourEmailAddressEmailProvider implements EmailProvider{

    @Override
    public String getEmail(User user) {
        return "Verify Your Email Address email for : " + user.getEmailAddress();
    }
}
