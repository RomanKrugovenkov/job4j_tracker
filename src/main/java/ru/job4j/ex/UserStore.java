package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User u : users) {
            if (login.equals(u.getUsername())) {
                return u;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() > 2) {
            return true;
        }
        throw new UserInvalidException("User invalid");
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException unf) {
            unf.printStackTrace();
        }
    }
}
