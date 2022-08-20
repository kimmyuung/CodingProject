package FunctionPrograming.AdvancedStream.Service;

import FunctionPrograming.Optional.User;

public class EmailService {

    public void SendEmail(User user) {
        user.getEmailAddress().ifPresent(email ->
            System.out.println("Sending play with Friends email to " + email));
    }

    public void SendEmail2(User user) {
        user.getEmailAddress().ifPresent(email ->
                System.out.println("Make more Friends " + email));
    }

    public void sendVerifyEmail(User user) {
        user.getEmailAddress().ifPresent(email ->
                System.out.println("Verify email " + email));
    }
}
