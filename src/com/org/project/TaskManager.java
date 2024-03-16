package com.org.project;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    public TaskManager() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask() {
        System.out.println("Enter your task name:");
        String name = scanner.nextLine();
        System.out.println("Enter your task description:");
        String description = scanner.nextLine();
        System.out.println("Enter task due date:");
        String dueDate = scanner.nextLine();

        Task task = new Task(name, description, dueDate);
        tasks.add(task);
        System.out.println("Task details added successfully.");
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". Name: " + task.getName() + ", Description: " + task.getDescription() + ", Due Date: " + task.getDueDate());
            }
        }
    }

    public void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to remove.");
            return;
        }

        System.out.println("Enter the index of the task list to remove:");
        int index;
        try {
            index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= tasks.size()) {
                System.out.println("Invalid index!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
            return;
        }

        tasks.remove(index);
        System.out.println("Task removed successfully!");
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Manager System");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                continue;
            }

            switch (choice) {
                case 1:
                    taskManager.addTask();
                    break;
                case 2:
                    taskManager.listTasks();
                    break;
                case 3:
                    taskManager.removeTask();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
