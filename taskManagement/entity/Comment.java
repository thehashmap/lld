package taskManagement.entity;

import java.time.Instant;
import java.util.UUID;

public class Comment {
    private final String id;
    private final String taskId;
    private final String authorId;
    private final String text;
    private final Instant createdAt;

    public Comment(String taskId, String authorId, String text) {
        this.id = UUID.randomUUID().toString();
        this.taskId = taskId;
        this.authorId = authorId;
        this.text = text;
        this.createdAt = Instant.now();
    }


    public String getId() {
        return id;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getText() {
        return text;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
