package ua.ithillel.java;

public class Store {

    private String storeName;
    private String URL;
    private User[] users;
    private User authorizedUser;

    public Store(String storeName, String URL, User[] users) {
        this.storeName = storeName;
        this.URL = URL;
        this.users = users;
    }

    public static User[] userList(User... users) {
        for (User user : users) {
        }
        return users;
    }

    public boolean login(String login, String passwords) {
        for (User user : userList(users)) {
            if (user.isLoginCorrect(login)) {
                if (user.isPasswordCorrect(passwords)) {
                    authorizedUser = user;
                    System.out.println("Authentication was successful.");
                    return true;
                } else break;
            }
        }
        System.out.println("Wrong login or password.");
        return false;
    }

    void getCurrentUserRights() {
        switch (authorizedUser.getRole()) {
            case ANONIM -> System.out.println("Anonymous user, can buy goods and or log in.");
            case MANAGER -> System.out.println("Store manager, can communicate with customers.");
            case CLIENT -> System.out.println("Customer of the store, can buy goods and enjoy the discount.");
            case DIRECTOR -> System.out.println("Store manager, can manage personnel and prices.");
            case ADMINISTRATOR ->
                    System.out.println("Shop administrator, can add products and edit their description.");
        }
    }

    public void logout() {
        authorizedUser = null;
        System.out.println("User logged out.");
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public User getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(User authorizedUser) {
        this.authorizedUser = authorizedUser;
    }
}
