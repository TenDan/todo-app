package pl.maciejslusarz.model;

import pl.maciejslusarz.IdProvider;

/**
 * @author ciepluchs
 */
public class Task {

    private Long id;
    private String owner;
    private String name;
    private String description;

    public Task(String owner, String name) {
        id = IdProvider.generateId();
        this.owner = owner;
        this.name = name;
        this.description = "";
    }

    public Task(String owner, String name, String description) {
        id = IdProvider.generateId();
        this.owner = owner;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        /*return "Task{" +
                //"id=" + id +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';*/
        return name + ": " + description;
    }
}
