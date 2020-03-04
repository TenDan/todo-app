package pl.maciejslusarz;

import pl.maciejslusarz.model.Board;
import pl.maciejslusarz.model.Task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj imię: ");
        String userName = input.nextLine();
        System.out.println("Wybrałeś imię: " + userName);

        Board board1 = new Board("To do");
        Board board2 = new Board("In progress");
        Board board3 = new Board("Done");

        String userInput = "";
        while (!userInput.equalsIgnoreCase("quit")) {
            System.out.println("Type command: ");
            userInput = input.nextLine();
            int taskNumber;
            int boardNumber;
            switch (userInput) {
                case "quit":
                    break;
                case "add task":
                    System.out.println("Type task name: ");
                    String taskName = input.nextLine();
                    System.out.println("Type task description: ");
                    String taskDescription = input.nextLine();
                    Task task = new Task(userName, taskName, taskDescription);
                    board1.addTask(task);
                    break;
                case "show todo":
                    board1.printTasks();
                    break;
                case "show started":
                    board2.printTasks();
                    break;
                case "show done":
                    board3.printTasks();
                    break;
                case "start task":
                    if (!board1.isThereTasks()) {
                        System.out.println("No tasks");
                        break;
                    }
                    System.out.println("Type task-to-start number: ");
                    taskNumber = input.nextInt();
                    input.nextLine();
                    board2.addTask(board1.getTask(taskNumber - 1));
                    board1.removeTask(taskNumber - 1);
                    break;
                case "complete task":
                    if (!board2.isThereTasks()) {
                        System.out.println("No tasks");
                        break;
                    }
                    System.out.println("Type task-to-complete number: ");
                    taskNumber = input.nextInt();
                    input.nextLine();
                    board3.addTask(board2.getTask(taskNumber - 1));
                    board2.removeTask(taskNumber - 1);
                    break;
                case "remove task":
                    System.out.println("Which board you want remove task from? ");
                    boardNumber = input.nextInt();
                    System.out.println("Which task you want to remove? ");
                    taskNumber = input.nextInt();
                    input.nextLine();
                    switch (boardNumber) {
                        case 0:
                            System.out.println("Zrobiłeś mnie w jajo");
                            System.exit(0);
                            break;
                        case 1:
                            board1.removeTask(taskNumber - 1);
                            break;
                        case 2:
                            board2.removeTask(taskNumber - 1);
                            break;
                        case 3:
                            board3.removeTask(taskNumber - 1);
                            break;
                        default:
                            System.out.println("Gratulację, nic nie zrobiłeś");
                            break;
                    }
                    break;
                case "?":
                case "help":
                    System.out.println("List of commands: " +
                            "\nquit - exit the program" +
                            "\nadd task - add the task" +
                            "\nremove task - remove the task" +
                            "\nshow (todo|started|done) - show the (todo|started|done) list" +
                            "\nstart task - start the task" +
                            "\ncomplete task - complete the task");
                    break;
                default:
                    System.out.println("Command not found! Type \"?\" or \"help\" to get full list of commands...");
                    break;
            }
        }


//        Task task1 = new Task(userName, "zakupy");
//        Task task2 = new Task(userName, "sprzątanie", "posprzątaj kuchnię");
//        Task task3 = new Task(userName, "odpoczywanie", "odpocznij");
//

//
//        board1.addTask(task1);
//        board1.addTask(task2);
//        board1.addTask(task3);
//
//        //wyswietalnie
//        System.out.println("Lista zadań z tablicy " + board1.getType());
//        board1.printTasks();
//        System.out.println("Lista zadań z tablicy " + board2.getType());
//        board2.printTasks();
//        System.out.println("Lista zadań z tablicy " + board3.getType());
//        board3.printTasks();
//
//        BoardManager manager = new BoardManager();
//
//        manager.moveTask(board1, board2, task1);
//
//        //wyswietalnie
//        System.out.println("Lista zadań z tablicy " + board1.getType());
//        board1.printTasks();
//        System.out.println("Lista zadań z tablicy " + board2.getType());
//        board2.printTasks();
//        System.out.println("Lista zadań z tablicy " + board3.getType());
//        board3.printTasks();

    }
}
