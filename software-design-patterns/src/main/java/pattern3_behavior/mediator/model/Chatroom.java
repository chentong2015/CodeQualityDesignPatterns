package pattern3_behavior.mediator.model;

import java.time.LocalDate;

// Handles all the communications between different users
public class Chatroom {

    public static void showMessage(User user, String message) {
        System.out.println(LocalDate.now() + " [" + user.getName() + "] : " + message);
    }
}
