import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User(1, "Yogesh", "xxx", "yogi@gmail.com"));
        users.add(new User(2, "Zen", "xxx", "zen@gmail.com"));
        users.add(new User(3, "Zeke", "xxx", "zeke@gmail.com"));

        // Use .collect() to store mapped values
        List<UserDTO> usersDTO = users.stream()
                .map(user -> new UserDTO(user.getId(), user.getUserName(), user.getEmail()))
                .collect(Collectors.toList());

        // Print the DTO list
        usersDTO.forEach(System.out::println);

    }
}

// DTO class (No password included)
class UserDTO {
    private int id;
    private String userName;
    private String email;

    public UserDTO(int id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDTO [id=" + id + ", userName=" + userName + ", email=" + email + "]";
    }
}

// User class (Password excluded from toString())
class User {
    private int id;
    private String userName;
    private String password;
    private String email;

    public User(int id, String userName, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    // Secure toString() (Hides password)
    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", email=" + email + "]";
    }
}


/*
UserDTO [id=1, userName=Yogesh, email=yogi@gmail.com]
UserDTO [id=2, userName=Zen, email=zen@gmail.com]
UserDTO [id=3, userName=Zeke, email=zeke@gmail.com]
 */