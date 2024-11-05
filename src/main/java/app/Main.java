package app;

public class Main {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(new User(1, "Alice", "alice@gmail.com"));
        userRepository.addUser(new User(2, "Bob", "bob@gmail.com"));
        userRepository.addUser(new User(3, "Charlie", "charlie@gmail.com"));
        userRepository.addUser(new User(4, "Diana", "diana@gmail.com"));

        UserRepository userRepository2 = new UserRepository();

        userRepository.findUserById(3)
                .ifPresentOrElse(
                    user -> System.out.println("Found user: " + user),
                    () -> System.out.println("User not found")
                );

        userRepository.findUserById(6)
            .ifPresentOrElse(
                user -> System.out.println("Found user: " + user),
                () -> System.out.println("User not found")
            );

        userRepository.findUserByEmail("diana@gmail.com")
            .ifPresentOrElse(
                user -> System.out.println("Found user: " + user),
                () -> System.out.println("User not found")
            );

        userRepository.findAllUsers().ifPresentOrElse(
            users -> users.forEach(System.out::println),
            () -> System.out.println("List is empty")
        );

        userRepository2.findAllUsers().ifPresentOrElse(
            users -> users.forEach(System.out::println),
            () -> System.out.println("List is empty")
        );
    }

}
