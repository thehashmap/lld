package splitwise.entity;

import java.util.UUID;

public class User {
    private final String id;
    private String name;
    private String email;

    public User(String id, String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
}
