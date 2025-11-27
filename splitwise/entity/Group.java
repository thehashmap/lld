package splitwise.entity;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Group {
    private final String id;
    private String name;
    private List<String> userIds;
    private Instant createdAt;

    public Group(String name, List<String> userIds) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.userIds = userIds;
        this.createdAt = Instant.now();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

}

