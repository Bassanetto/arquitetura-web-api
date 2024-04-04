package arquitetura.web.demo.repository;

import arquitetura.web.demo.models.Aluno;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {
    private final JdbcTemplate jdbcTemplate;
    public AlunoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Aluno> obterTodos() {
        return jdbcTemplate.query("SELECT * FROM aluno", (resultSet, rowNum) ->
                new Aluno(
                        resultSet.getLong("id"),
                        resultSet.getString("nome"),
                        Aluno.formatCpf(resultSet.getString("documento")),
                        resultSet.getString("curso"),
                        resultSet.getInt("idade")
                )
        );
    }

    @Override
    public Aluno obter(Long id) {
        String query = "SELECT * FROM aluno WHERE id = ?";

        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet,  rowNum) ->
                new Aluno(
                        resultSet.getLong("id"),
                        resultSet.getString("nome"),
                        Aluno.formatCpf(resultSet.getString("documento")),
                        resultSet.getString("curso"),
                        resultSet.getInt("idade")
                )
        );
    }

    @Override
    public Aluno adicionar(Long id, Aluno aluno) {
        if (id == null) {
            String insertQuery = "INSERT INTO public.aluno (nome, documento, curso, idade) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(insertQuery, aluno.getNome(), aluno.getDocumento(), aluno.getCurso(), aluno.getIdade());
        } else {
            // Sem troca de ID
            if (this.obter(id) != null) {
                String updateQuery = "UPDATE public.aluno SET nome = ?, documento = ?, curso = ?, idade = ? WHERE id = ?";
                jdbcTemplate.update(updateQuery, aluno.getNome(), aluno.getDocumento(), aluno.getCurso(), aluno.getIdade(), aluno.getId());
            } else {
                throw new IllegalArgumentException("Não existe nenhum estudante com esse registro.");
            }
        }
        return aluno;
    }

    @Override
    public Aluno excluir(Long id){
        Aluno aluno = obter(id);
        String deleteQuery = "DELETE FROM public.aluno WHERE id = ?";
        jdbcTemplate.update(deleteQuery, new Object[]{id});
        return aluno;
    }
}