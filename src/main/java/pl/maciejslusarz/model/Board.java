package pl.maciejslusarz.model;

import pl.maciejslusarz.IdProvider;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Long id;
    private String type;
    private List<Task> tasks;

    public Board(String type) {
        this.type = type;
        this.id = IdProvider.generateId();
        this.tasks = new ArrayList<>();
    }

    public boolean isThereTasks() {
        return tasks.size() > 0;
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        if (tasks.size() > 0) tasks.remove(index);
        else System.out.println("No tasks");
    }

    public void printTasks() {
        if (tasks.size() > 0)
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i+1)+". "+tasks.get(i));
            }
        else System.out.println("No tasks");
    }

    public String getType() {
        return type;
    }

}
