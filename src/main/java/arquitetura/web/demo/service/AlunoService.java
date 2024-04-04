package arquitetura.web.demo.service;

import arquitetura.web.demo.model.Aluno;
import java.util.List;

public interface AlunoService {
    List<Aluno> obterTodos();
    Aluno obter(Long id);
    Aluno adicionar(Aluno aluno);
    Aluno atualizar(Long id, Aluno aluno);
    Aluno excluir(Long id);
}