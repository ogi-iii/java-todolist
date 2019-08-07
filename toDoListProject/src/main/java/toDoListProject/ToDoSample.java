package toDoListProject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDoSample {

    private Integer id;
    private String content;
    private String deadline;
    private boolean done;
    private String today;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public int getId() {
        return this.id;
    }

    public void setId(int id) { this.id = id;}

    public  String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public  String getDeadline() {
        return this.deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean getDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getToday() {
        return this.today;
    }

    public void setToday() {
        Date today = new Date();
        this.today = dateFormat.format(today);
    }
}
