package FunctionPrograming.DesignPattern.service;

import FunctionPrograming.DesignPattern.model.User;

public class UserService extends AbstractUserService{

    @Override
    protected boolean verifitUser(User user) {
        System.out.println("validation user " + user.getName());

        return user.getName() != null && user.getEmailAddress().isPresent();
    }

    @Override
    protected void writeToDB(User user) {
        System.out.println("Writing User " + user.getName() + " to DB");
    }
}
