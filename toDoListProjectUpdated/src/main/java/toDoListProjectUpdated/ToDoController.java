package toDoListProjectUpdated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    private List<ToDo> resultTodos = new ArrayList<>();
    private boolean todoBool=false;
    private int id = 0;

    @GetMapping("/")
    public String top(Model model) {
        model.addAttribute("todos", toDoService.findAll());

        if (toDoService.findAll().isEmpty()) {
            todoBool=false;
        } else {
            todoBool=true;
        }
        model.addAttribute("todoBool", todoBool);
        return "top";
    }

    @PostMapping("/create")
    public String create(RedirectAttributes attributes, @RequestParam String content, @RequestParam String deadline) {
        if (content.equals("")) {
            attributes.addFlashAttribute("errorMessage", "全ての項目を入力してください");
            return "redirect:/";
        } else if (deadline.equals("")) {
            attributes.addFlashAttribute("errorMessage", "全ての項目を入力してください");
            return "redirect:/";
        }

        if (content.length()>=31) {
            attributes.addFlashAttribute("errorMessage", "ToDoは30文字以内にしてください");
            return "redirect:/";
        }

        for (ToDo otherTodo: toDoService.findAll()){
            if (otherTodo.getContent().equals(content)) {
                attributes.addFlashAttribute("errorMessage", "既に登録されたToDoです");
                return "redirect:/";
            }
        }

        toDoService.create(id, content, deadline);

        id+=1;
        if (!todoBool) {
            todoBool=true;
        }

        return "redirect:/";
    }

    @PostMapping("/changeDid")
    public String changeDid(@RequestParam Integer id) {
        if (toDoService.findOne(id).getDone()) {
            toDoService.changeDone(id, false);
        }else {
            toDoService.changeDone(id, true);
        }
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Integer id) {
        model.addAttribute("todo", toDoService.findOne(id));
        return "edit";
    }

    @PostMapping("/recreate")
    public String recreate(RedirectAttributes attributes, @RequestParam String content, @RequestParam String deadline, @RequestParam Integer id) {

        if (content.equals("")) {
            attributes.addFlashAttribute("errorMessage", "全ての項目を入力してください");
            attributes.addAttribute("id", id);
            return "redirect:/edit";
        } else if (deadline.equals("")) {
            attributes.addFlashAttribute("errorMessage", "全ての項目を入力してください");
            attributes.addAttribute("id", id);
            return "redirect:/edit";
        }

        if (content.length()>=31) {
            attributes.addFlashAttribute("errorMessage", "ToDoは30文字以内にしてください");
            attributes.addAttribute("id", id);
            return "redirect:/edit";
        }

        for (ToDo otherTodo: toDoService.findAll()){
            if (otherTodo.getContent().equals(content)) {
                if (otherTodo.getId()!=id) {
                    attributes.addFlashAttribute("errorMessage", "既に登録されたToDoです");
                    attributes.addAttribute("id", id);
                    return "redirect:/edit";
                }
            }
        }
        toDoService.update(id, content, deadline);

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id) {

        toDoService.delete(id);

        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("resultTodos", resultTodos);
        return "search";
    }

    @GetMapping("/result")
    public String result(RedirectAttributes attributes, @RequestParam String content) {

        resultTodos = new ArrayList<>();

        if (content.equals("")) {
            attributes.addFlashAttribute("resultMessage", "検索ワードを入力してください");
            return "redirect:/search";
        }

        for (ToDo todo: toDoService.findAll()){
            if (todo.getContent().contains(content)) {
                if (!todo.getDone()) {
                    resultTodos.add(todo);
                }
            }
        }

        if (resultTodos.size()==0) {
            attributes.addFlashAttribute("resultMessage", "対象のToDoは見つかりません");
        } else {
            String stringSize=Integer.toString(resultTodos.size());
            attributes.addFlashAttribute("resultMessage", "ToDoが"+stringSize+"件見つかりました");
        }
        return "redirect:/search";
    }

    @PostMapping("/resultChangeDid")
    public String resultChangeDid(@RequestParam int id) {
        if (toDoService.findOne(id).getDone()) {
            toDoService.changeDone(id, false);
        }else {
            toDoService.changeDone(id, true);
        }
        for (ToDo todo: resultTodos){
            if (todo.getId()==id) {
                Integer index=resultTodos.indexOf(todo);
                resultTodos.set(index, toDoService.findOne(id));
            }
        }

        return "redirect:/search";
    }
}
