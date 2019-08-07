package toDoListProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
}
