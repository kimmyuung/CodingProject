package FunctionPrograming.DesignPattern.service;

import FunctionPrograming.DesignPattern.model.User;

public abstract class AbstractUserService {
    protected abstract boolean verifitUser(User user);

    protected abstract void writeToDB(User user);

    public void createUser(User user) {
        if(verifitUser(user)) {
            writeToDB(user);
        }else {
            System.out.println("Cannot create User");
        }
    }
}
