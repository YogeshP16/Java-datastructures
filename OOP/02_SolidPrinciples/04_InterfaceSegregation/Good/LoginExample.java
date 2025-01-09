interface IAuthentication {
    void signIn(String username, String password);
}

interface IUserRegistration {
    void signUp(String username, String password);
}

interface IPasswordManagement {
    void resetPassword(String email);
}

interface IAdminTasks {
    void handleAdminTasks();
}

// Implementation for a regular user
class RegularUser implements IAuthentication, IUserRegistration, IPasswordManagement {
    public void signUp(String username, String password) {
        System.out.println("User signed up with username: " + username);
    }

    public void signIn(String username, String password) {
        System.out.println("User signed in with username: " + username);
    }

    public void resetPassword(String email) {
        System.out.println("Password reset link sent to: " + email);
    }
}

// Implementation for an admin user
class AdminUser implements IAuthentication, IAdminTasks {
    public void signIn(String username, String password) {
        System.out.println("Admin signed in with username: " + username);
    }

    public void handleAdminTasks() {
        System.out.println("Admin is managing user data.");
    }
}

// Main function to test
public class LoginExample {
    public static void main(String[] args) {
        // Regular user actions
        RegularUser regularUser = new RegularUser();
        regularUser.signUp("zen", "password123");
        regularUser.signIn("loki", "password123");
        regularUser.resetPassword("zen@gmail.com");

        // Admin user actions
        AdminUser adminUser = new AdminUser();
        adminUser.signIn("admin_user", "adminpass");
        adminUser.handleAdminTasks();
    }
}

/*
User signed up with username: zen
User signed in with username: loki
Password reset link sent to: zen@gmail.com
Admin signed in with username: admin_user
Admin is managing user data.
 */