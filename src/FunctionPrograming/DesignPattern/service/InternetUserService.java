package FunctionPrograming.DesignPattern.service;

import FunctionPrograming.DesignPattern.model.User;

public class InternetUserService extends AbstractUserService{


    @Override
    protected boolean verifitUser(User user) {
        System.out.println("validation Internet user " + user.getName());
        return true;
    }

    @Override
    protected void writeToDB(User user) {
        System.out.println("Writing User " + user.getName() + " to Internet DB");
    }
}
