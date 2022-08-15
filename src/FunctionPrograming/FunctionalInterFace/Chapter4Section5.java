package FunctionPrograming.FunctionalInterFace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chapter4Section5 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(3, "Alice"));
        users.add(new User(1, "Charlice"));
        users.add(new User(5, "Bob"));

        Comparator<User> idComparator = (User u1, User u2) -> {
            return u1.getId() - u2.getId();
        };
       // Collections.sort(users, idComparator);
        // id 순 정렬
        System.out.println(users);

        Collections.sort(users, (u1, u2) -> u1.getName().compareTo(u2.getName()));
        // name 순 정렬


    }
}
