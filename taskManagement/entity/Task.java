package taskManagement.entity;

import taskManagement.enums.TaskPriority;
import taskManagement.enums.TaskStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private String id;
    private String name;
    private String description;
    private String assignedUserId;
    private final String createdByUserId;
    private TaskStatus status;
    private TaskPriority priority;
    private final Instant createdAt;
    private Instant updatedAt;

    private List<Comment> comments = new ArrayList<>();

    public Task(String createdByUserId, String id, String name, String description, String assignedUserId,
                TaskStatus status, TaskPriority priority, Instant createdAt, Instant updatedAt) {
        this.createdByUserId = createdByUserId;
        this.id = id;
        this.name = name;
        this.description = description;
        this.assignedUserId = assignedUserId;
        this.status = status;
        this.priority = priority;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
