
interface IUser {
    void signUp(String username, String password);
    void signIn(String username, String password);
    void resetPassword(String email);
    void handleAdminTasks(); // Not relevant for all users
}

class RegularUser implements IUser {
    public void signUp(String username, String password) { /* Implementation */ }
    public void signIn(String username, String password) { /* Implementation */ }
    public void resetPassword(String email) { /* Implementation */ }
    public void handleAdminTasks() { 
        throw new UnsupportedOperationException("Not an admin!"); 
    } // Irrelevant for RegularUser
}

class AdminUser implements IUser {
    public void signUp(String username, String password) { 
        throw new UnsupportedOperationException("Admins don't sign up!"); 
    } // Irrelevant for AdminUser
    public void signIn(String username, String password) { /* Implementation */ }
    public void resetPassword(String email) { /* Implementation */ }
    public void handleAdminTasks() { /* Implementation */ }
}


/*
Interface segregation -> dont force a class to implement mehtods which is not used 

here both regular user and admin user have methods which they dont needed 
ex: regular user --> why he need to handle admin task method
ex : Admin user dont need signup 
 */

