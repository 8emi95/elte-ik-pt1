package hu.valdar.progtech.gy4;

import hu.valdar.progtech.gy4.it.person.Programmer;
import hu.valdar.progtech.gy4.it.system.Severity;
import hu.valdar.progtech.gy4.it.system.Task;
import hu.valdar.progtech.gy4.it.system.TaskBuilder;

import java.util.List;

public class Boot {

    public static void main(String[] args){

        Programmer programmer = new Programmer("Valdar");

        Task task = new TaskBuilder()
                .setName("Programozási technológia 1. - 1. feladat")
                .setSeverity(Severity.CRITICAL)
                .setDescription("Készítsünk builder tervezési mintát alkalmazva a Task-ra egy osztályt.")
                .setFinished(true)
                .build();

        Task task2 = new TaskBuilder()
                .setName("Programozási technológia 1. - 2. feladat")
                .setSeverity(Severity.MAJOR)
                .setDescription("Készítsünk el a 2. feladatot a kapott dokumentum alapján!")
                .setFinished(false)
                .build();

        programmer.addTask(task);
        programmer.addTask(task2);

        programmer.tellTasks();
        programmer.doAllUnfinishedTask();
        programmer.tellTasks();

        printDescription(programmer, Severity.CRITICAL);

    }


    private static void printDescription(Programmer programmer, Severity severity){
        List<Task> tasksBySeverity = programmer.getTasksBySeverity(severity);
        for (final Task task : tasksBySeverity) {
            System.out.println(task.getDescription());
        }
    }
}
