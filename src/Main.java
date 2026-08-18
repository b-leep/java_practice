import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String name;
    private String location;

    Task(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public String toString() {
        return name + " @ " + location;
    }
}

class TaskList {
    private ArrayList<Task> tasks;

    TaskList() {
        this.tasks = new ArrayList<>();
    }

    void addTask(Task t) {
        tasks.add(t);
    }

    void printAllTasks() {
        if (tasks.size() == 0) {
            System.out.println("No tasks yet.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    void updateTask(String name, String newLocation) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(name)) {
                tasks.get(i).setLocation(newLocation);
                System.out.println("Updated.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    void deleteTask(String name) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(name)) {
                tasks.remove(i);
                System.out.println("Deleted.");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskList taskList = new TaskList();
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Task  2. View Tasks  3. Update Task  4. Delete Task  5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Task name: ");
                String name = sc.nextLine();
                System.out.print("Location: ");
                String location = sc.nextLine();
                taskList.addTask(new Task(name, location));
                System.out.println("Added.");
            } else if (choice == 2) {
                taskList.printAllTasks();
            } else if (choice == 3) {
                System.out.print("Task name to update: ");
                String name = sc.nextLine();
                System.out.print("New location: ");
                String newLocation = sc.nextLine();
                taskList.updateTask(name, newLocation);
            } else if (choice == 4) {
                System.out.print("Task name to delete: ");
                String name = sc.nextLine();
                taskList.deleteTask(name);
            } else if (choice == 5) {
                running = false;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        System.out.println("Goodbye!");
    }
}

