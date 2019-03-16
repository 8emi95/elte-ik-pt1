package hu.valdar.progtech.gy4.it.person;

import hu.valdar.progtech.gy4.it.system.Severity;
import hu.valdar.progtech.gy4.it.system.Task;

import java.util.ArrayList;
import java.util.List;

public class Programmer {

    private final String name;
    private final List<Task> tasks;

    public Programmer(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        if(task == null){
            throw new IllegalStateException("Ez nem jó feladat!");
        }
        tasks.add(task);
    }

    public void doAllUnfinishedTask(){
        for (final Task task : tasks) {
            if(!task.isFinished()){
                task.setFinished(true);
            }
        }
    }

    public void tellTasks(){
        for (final Task task : tasks) {
            System.out.println(task.getName() + " finished: " + task.isFinished());
        }
    }

    public List<Task> getTasksBySeverity(Severity severity){
        final List<Task> resultTasks = new ArrayList<>();
        for (final Task task : tasks) {
            if(!task.isFinished() && task.getSeverity() == severity){
                resultTasks.add(task);
            }
        }
        return resultTasks;
    }

}
