package FunctionPrograming.DesignPattern.service;

import FunctionPrograming.DesignPattern.model.User;

public interface EmailProvider {
    String getEmail(User user);
}
