package hu.valdar.progtech.gy4.it.system;

public class Task {

    private String name;
    private boolean finished;
    private Severity severity;
    private String description;

    public String getName() {
        return name;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setName(String name) {
        this.name = name;
    }
}
