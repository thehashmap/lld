package taskManagement.entity;

import taskManagement.enums.TaskPriority;
import taskManagement.enums.TaskStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Task {
    private final String id;
    private String name;
    private String description;
    private String assignedUserId;
    private final String createdByUserId;
    private TaskStatus status;
    private TaskPriority priority;
    private final Instant createdAt;
    private Instant updatedAt;

    private List<Comment> comments = new ArrayList<>();

    private Task(TaskBuilder builder) {
        this.createdByUserId = builder.createdByUserId;
        this.id = UUID.randomUUID().toString();
        this.name = builder.name;
        this.description = builder.description;
        this.assignedUserId = builder.assignedUserId;
        this.status = builder.status;
        this.priority = builder.priority;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public static class TaskBuilder {
        private final String id;
        private String name;
        private String description;
        private String assignedUserId;
        private final String createdByUserId;
        private TaskStatus status = TaskStatus.TODO;
        private TaskPriority priority = TaskPriority.MEDIUM;
        private final Instant createdAt;
        private Instant updatedAt;

        public TaskBuilder(String createdByUserId, String name) {
            this.id = UUID.randomUUID().toString();
            this.createdByUserId = createdByUserId;
            this.createdAt = Instant.now();
        }

        public TaskBuilder setAssignedUserId(String assignedUserId) {
            this.assignedUserId = assignedUserId;
            this.updatedAt = Instant.now();
            return this;
        }

        public TaskBuilder setStatus(TaskStatus status) {
            this.status = status;
            this.updatedAt = Instant.now();
            return this;
        }

        public TaskBuilder setPriority(TaskPriority priority) {
            this.priority = priority;
            this.updatedAt = Instant.now();
            return this;
        }

        public TaskBuilder setDescription(String description) {
            this.description = description;
            this.updatedAt = Instant.now();
            return this;
        }

        public Task build(){
            return new Task(this);
        }
    }


    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) { this.comments.add(comment);};

    public String getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(String assignedUserId) { this.assignedUserId = assignedUserId;};

    public String getCreatedByUserId() {
        return createdByUserId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
