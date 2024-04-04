package arquitetura.web.demo.services;

import arquitetura.web.demo.models.Aluno;
import java.util.List;

public interface AlunoService {
    List<Aluno> obterTodos();
    Aluno obter(Long id);
    Aluno adicionar(Long id, Aluno aluno);
    Aluno atualizar(Long id, Aluno aluno);
    Aluno excluir(Long id);
}