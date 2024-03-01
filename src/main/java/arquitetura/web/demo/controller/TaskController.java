package arquitetura.web.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private List<String> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add("Estudar para a prova de matemática");
        tasks.add("Fazer compras no mercado");
        tasks.add("Preparar apresentação para o trabalho");
    }
    @GetMapping
    public String getAllTasks() {
        return "Tasks";
    }

    @GetMapping("/{taskId}")
    public String getTextById(@PathVariable int task) {
        if (task >= 0 && task < tasks.size()) {
          return tasks.get(task);
        } else {
            return "Tarefa não encontrada";
        }
    }

    @PostMapping("/add-task")
    public void addTask(@RequestBody String task) {
        tasks.add(task);
        System.out.println("Tarefa Adicionada: " + task);
    }
}
