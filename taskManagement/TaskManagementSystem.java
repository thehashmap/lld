package taskManagement;

import taskManagement.entity.Task;
import taskManagement.entity.User;
import taskManagement.enums.TaskPriority;
import taskManagement.enums.TaskStatus;

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskManager taskManager = TaskManager.getInstance();

        User alice = new User("Alice", "alice@gmail.com");
        User bob = new User("Bob", "bob@gmail.com");

        taskManager.createUser(alice);
        taskManager.createUser(bob);

        Task task1 = taskManager.createTask(
                "Implement Login Feature",
                "Create login page with authentication",
                TaskPriority.MEDIUM,
                TaskStatus.IN_PROGRESS,
                alice.getId(),
                bob.getId()
        );

        Task task2 = taskManager.createTask(
                "Fix Bug #123",
                "Null pointer exception in dashboard",
                TaskPriority.HIGH,
                TaskStatus.TODO,
                bob.getId(),
                alice.getId()
        );

        taskManager.getAllTasks().forEach(System.out::println);
    }
}
