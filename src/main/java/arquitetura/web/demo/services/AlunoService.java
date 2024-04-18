package arquitetura.web.demo.services;

import arquitetura.web.demo.models.Aluno;
import java.util.List;

public interface AlunoService {
    List<Aluno> obterTodos();
    Aluno obter(Long id);
    Aluno adicionar(Aluno aluno);
    Aluno atualizar(Aluno aluno);
    void excluir(Long id);
    List<Aluno> obterAlunosPorCurso(Long categoriaId);
    List<Aluno> obterAlunosPorCursoNome(String nomeCategoria);
    List<Aluno> obterAlunosPorCursoNomeParcial(String nomeCursoParcial);
    Long contarAlunoPorCursoId(Long categoriaId);
    Long contarAlunoPorCursoNomeParcial(String nomeCursoParcial);
}
