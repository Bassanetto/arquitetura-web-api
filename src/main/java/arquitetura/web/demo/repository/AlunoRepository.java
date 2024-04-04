package arquitetura.web.demo.repository;

import arquitetura.web.demo.models.Aluno;

import java.util.List;

public interface AlunoRepository {
    List<Aluno> obterTodos();
    Aluno obter(Long id);
    Aluno adicionar(Long id, Aluno student);
    Aluno excluir(Long id);
}