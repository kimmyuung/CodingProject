package FunctionPrograming.DesignPattern.service;

import FunctionPrograming.DesignPattern.model.User;

public class MaksMoreFriendsEmailProvider implements EmailProvider{
    @Override
    public String getEmail(User user) {
        return "Make more friends email for " + user.getEmailAddress();
    }
}
