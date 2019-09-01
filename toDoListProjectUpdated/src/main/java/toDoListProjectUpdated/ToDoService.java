package toDoListProjectUpdated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public void create(Integer id, String content, String deadline) {

        ToDo todo=new ToDo();
        todo.setId(id);
        todo.setContent(content);
        todo.setDeadline(deadline);
        todo.setDone(false);
        todo.setToday();

        toDoRepository.save(todo);
    }

    public List<ToDo> findAll() {
        List<ToDo> todos=toDoRepository.findAll();
        return todos;
    }

    public ToDo findOne(Integer id) {
        Optional<ToDo> todo=toDoRepository.findById(id);
        return todo.get();
    }

    public ToDo update(Integer id, String content, String deadline) {
        ToDo todo=findOne(id);
        todo.setContent(content);
        todo.setDeadline(deadline);
        todo.setDone(false);
        todo.setToday();
        return toDoRepository.save(todo);
    }

    public void delete(Integer id) {
        toDoRepository.deleteById(id);
    }

    public ToDo changeDone(Integer id, boolean done) {
        ToDo todo=findOne(id);
        todo.setDone(done);
        return toDoRepository.save(todo);
    }
}
