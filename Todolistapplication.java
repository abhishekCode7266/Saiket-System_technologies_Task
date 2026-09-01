import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {

    private String title;
    
    private boolean completed;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markComplete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        String status = completed ? "Done" : "Pending";
        return title + " [" + status + "]";
    }
}

public class Todolistapplication {

    private static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("===== To-Do List =====");

        while (running) {

            System.out.println("\n1. Add Task");
            System.out.println("2. Mark Task as Complete");
            System.out.println("3. Show All Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine().trim();

            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter task title: ");

                    String title = sc.nextLine().trim();

                    if (title.isEmpty()) {
                        System.out.println("Task title cannot be empty.");
                    } else {
                        tasks.add(new Task(title));
                        System.out.println("Task added successfully.");
                    }

                    break;

                case 2:

                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to update.");
                        break;
                    }

                    showTasks();

                    System.out.print(
                        "Enter task number to mark complete: "
                    );

                    try {

                        int index =
                            Integer.parseInt(sc.nextLine().trim()) - 1;

                        if (index >= 0 && index < tasks.size()) {

                            if (tasks.get(index).isCompleted()) {

                                System.out.println(
                                    "Task is already completed."
                                );

                            } else {

                                tasks.get(index).markComplete();

                                System.out.println(
                                    "Task marked as complete."
                                );
                            }

                        } else {

                            System.out.println(
                                "Invalid task number."
                            );
                        }

                    } catch (NumberFormatException e) {

                        System.out.println(
                            "Please enter a valid number."
                        );
                    }

                    break;

                case 3:

                    showTasks();

                    break;

                case 4:

                    running = false;

                    System.out.println(
                        "Exiting to-do list. Bye!"
                    );

                    break;

                default:

                    System.out.println(
                        "Invalid choice, try again."
                    );
            }
        }

        sc.close();
    }

    private static void showTasks() {

        if (tasks.isEmpty()) {

            System.out.println("No tasks added yet.");

            return;
        }

        System.out.println("\nYour Tasks:");

        for (int i = 0; i < tasks.size(); i++) {

            System.out.println(
                (i + 1) + ". " + tasks.get(i)
            );
        }
    }
}
