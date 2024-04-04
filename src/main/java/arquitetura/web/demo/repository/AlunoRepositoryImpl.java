package arquitetura.web.demo.repository;

import arquitetura.web.demo.models.Aluno;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {
    private final List<Aluno> alunos = new ArrayList<>();
    private Long proximoId;

    public AlunoRepositoryImpl() {
        alunos.add(new Aluno(1L, "Luiz Obara"    , "111.111.111-11", "TEC-ADS" , 21));
        alunos.add(new Aluno(2L, "Júlia Almeida" , "222.222.222-22", "ARQ-URB" , 20));
        alunos.add(new Aluno(3L, "Felipe Lima"   , "333.333.333-33", "TEC-ADS" , 20));
        alunos.add(new Aluno(4L, "Tiago Bernardo", "444.444.444-44", "ENG-PROD", 22));
        alunos.add(new Aluno(5L, "Pedro Mattos"  , "555.555.555-55", "TEC-JGD" , 21));
        proximoId = 6L;
    }

    @Override
    public List<Aluno> obterTodos() {
        return alunos;
    }

    @Override
    public Aluno obter(Long id) {
        return alunos.stream()
                .filter(aluno -> aluno.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Aluno adicionar(Aluno aluno) {
        if (aluno.getId() == null) {
            aluno.setId(proximoId++);
            alunos.add(aluno);
        } else {
            alunos.removeIf(t -> t.getId().equals(aluno.getId()));
            alunos.add(aluno);
        }
        return aluno;
    }

    @Override
    public Aluno atualizar(Long id, Aluno aluno){
        Aluno atualizarAluno = this.obter(id);
        if (atualizarAluno != null) {
            alunos.set(alunos.indexOf(atualizarAluno), aluno);
        }
        return aluno;
    }

    @Override
    public Aluno excluir(Long id){
        Aluno excluirAluno = this.obter(id);
        if (excluirAluno != null) {
            alunos.removeIf(aluno -> aluno.getId().equals(id));
        }
        return excluirAluno;
    }
}