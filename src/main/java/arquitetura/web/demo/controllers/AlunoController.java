package arquitetura.web.demo.controllers;

import arquitetura.web.demo.exceptions.AlunoNaoEncontradoException;
import arquitetura.web.demo.models.Aluno;
import arquitetura.web.demo.services.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Aluno atualizar(@RequestBody Aluno atualizar){
        return alunoService.atualizar(atualizar);
    }

    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try {
            alunoService.excluir(id);
            return ResponseEntity.ok("Item deletado com sucesso!");
        } catch (AlunoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/obter-alunos-por-curso/{id}")
    public List<Aluno> ObterAlunosPorCursoId(@PathVariable Long id) {
        return alunoService.obterAlunosPorCurso(id);
    }

    @GetMapping("/obter-alunos-por-curso-nome/{nome}")
    public List<Aluno> obterAlunosPorCursoNome(@PathVariable String nome) {
        return alunoService.obterAlunosPorCursoNome(nome);
    }

    @GetMapping("/obter-alunos-por-curso-nome-parcial/{nomeParcial}")
    public List<Aluno> obterAlunosPorCursoNomeParcial(@PathVariable String nomeParcial) {
        return alunoService.obterAlunosPorCursoNomeParcial(nomeParcial);
    }

    @GetMapping("/contar-aluno-por-curso/{cursoId}")
    public Long contarAlunoPorCursoId(@PathVariable Long cursoId) {
        return alunoService.contarAlunoPorCursoId(cursoId);
    }

    @GetMapping("/contar-aluno-por-curso-nome-parcial/{nomeParcial}")
    public Long contarAlunoPorCursoNomeParcial(@PathVariable String nomeParcial) {
        return alunoService.contarAlunoPorCursoNomeParcial(nomeParcial);
    }

}