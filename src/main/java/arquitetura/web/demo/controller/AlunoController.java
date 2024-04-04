package arquitetura.web.demo.controller;

import arquitetura.web.demo.model.Aluno;
import arquitetura.web.demo.service.AlunoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> obterTodos() {
        return alunoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Aluno obter(@PathVariable Long id) {
        return alunoService.obter(id);
    }

    @PostMapping("/adicionar")
    public Aluno adicionar(@RequestBody Aluno aluno) {
        return alunoService.adicionar(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno atualizar){
        return alunoService.atualizar(id, atualizar);
    }

    @DeleteMapping("/{id}")
    public Aluno excluir(@PathVariable Long id) {
        return alunoService.excluir(id);
    }

}