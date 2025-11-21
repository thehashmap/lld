package taskManagement.entity;

import java.time.Instant;

public class Comment {
    private final String id;
    private final String taskId;
    private final String authorId;
    private final String text;
    private final Instant createdAt;

    public Comment(String id, String taskId, String authorId, String text, Instant createdAt) {
        this.id = id;
        this.taskId = taskId;
        this.authorId = authorId;
        this.text = text;
        this.createdAt = createdAt;
    }
}
