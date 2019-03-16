package hu.valdar.progtech.gy4.it.system;

public class TaskBuilder {

    private final Task task;

    public TaskBuilder(){
        task = new Task();
    }

    public TaskBuilder setName(String name){
        task.setName(name);
        return this;
    }

    public TaskBuilder setSeverity(Severity severity){
        task.setSeverity(severity);
        return this;
    }

    public TaskBuilder setDescription(String description){
        task.setDescription(description);
        return this;
    }

    public TaskBuilder setFinished(boolean finished){
        task.setFinished(finished);
        return this;
    }

    public Task build(){
        return task;
    }

}
