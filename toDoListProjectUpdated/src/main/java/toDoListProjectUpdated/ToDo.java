package toDoListProjectUpdated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "todos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="deadline", nullable = false)
    private String deadline;

    @Column(name="done", nullable = false)
    private boolean done;

    @Column(name="today", nullable = false)
    private String today;


    public int getId() {
        return this.id;
    }

    public void setId(Integer id) { this.id = id;}

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        this.today = dateFormat.format(today);
    }
}
