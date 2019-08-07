package toDoListProject;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "m_todo")
public class ToDo implements Serializable {

    @Id
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="deadline", nullable = false)
    private String deadline;

    @Column(name="done", nullable = false)
    private boolean done;

    @Column(name="today", nullable = false)
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
