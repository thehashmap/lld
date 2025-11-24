package taskManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import taskManagement.entity.Comment;
import taskManagement.entity.Task;
import taskManagement.entity.User;
import taskManagement.enums.TaskPriority;
import taskManagement.enums.TaskStatus;

public class TaskManager {
    private static TaskManager instance;
    private final Map<String, Task> tasks;
    private final Map<String, User> users;

    private TaskManager() {
        this.tasks = new ConcurrentHashMap<>();
        this.users = new ConcurrentHashMap<>();
    }

    public static synchronized TaskManager getInstance() {
        if(instance == null) return new TaskManager();
        return instance;
    }

    public void createUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public Task createTask(String name, String description, TaskPriority priority, TaskStatus status,
                           String createdByUserId, String assignedTo) {
        Task task = new Task.TaskBuilder(createdByUserId, name)
                .setDescription(description)
                .setPriority(priority)
                .setStatus(status)
                .setAssignedUserId(assignedTo)
                .build();

        tasks.put(task.getId(), task);

        return task;
    }

    public boolean assignTask(String taskId, String assignTo) {
        Task task =  tasks.get(taskId);
        if(task == null) return false;
        task.setAssignedUserId(assignTo);
        return true;
    }

    public boolean updateTaskStatus(String taskId, TaskStatus status) {
        Task task = tasks.get(taskId);
        if(task == null) return false;
        task.setStatus(status);
        return true;
    }

    public boolean updateTaskPriority(String taskId, TaskPriority priority) {
        Task task = tasks.get(taskId);
        if(task == null) return false;
        task.setPriority(priority);
        return true;
    }

    public boolean updateTaskDescription(String taskId, String description) {
        Task task = tasks.get(taskId);
        if(task == null) return false;
        task.setDescription(description);
        return true;
    }

    public boolean addComment(String taskId, String authorId, String text) {
        Task task = tasks.get(taskId);
        if(task == null) return false;
        Comment comment = new Comment(taskId, authorId, text);
        task.addComment(comment);
        return true;
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public List<Task> getTaskByStatus(TaskStatus status) {
        return tasks.values().stream()
                .filter(task -> task.getStatus() == status)
                .toList();
    }

    public List<Task> getTaskByPriority(TaskPriority priority) {
        return tasks.values().stream()
                .filter(task -> task.getPriority() == priority)
                .toList();
    }

    public List<Task> getTaskByAssignee(String assignedUserId) {
        return tasks.values().stream()
                .filter(task -> task.getAssignedUserId() == assignedUserId)
                .toList();
    }

    public List<Task> filterTasks(String assignedUserId, TaskStatus status, TaskPriority priority) {
        return tasks.values().stream()
                .filter(task -> task.getAssignedUserId() == null || task.getAssignedUserId() == assignedUserId)
                .filter(task -> task.getPriority() == null || task.getPriority() == priority)
                .filter(task -> task.getStatus() == null || task.getStatus() == status)
                .toList();
    }

}