package Entity;

public class LabTask {
    private Task task;
    private String type;
    private String description;
    
    public LabTask(Task task, String type, String description)
    {
        this.task = task;
        this.type = type;
        this.description = description;
    }


    public void setTask(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
