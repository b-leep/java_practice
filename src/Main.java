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

