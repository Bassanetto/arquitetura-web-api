package arquitetura.web.demo.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>
{
    /*
    Query Methods utilizando as converções de nomes para gerar consultas automaticamente
     */
    List<Aluno> findByCursoId(Long cursoId);
    List<Aluno> findByCursoNome(String cursoNome);
    List<Aluno> findByCursoNomeContaining(String cursoNomeParcial);

    /*
    Quer Methods com consultas custmomizadas
     */

    // Recuperar o total de tarefas por ID da categoria usando JPQL
    @Query("SELECT COUNT(a) FROM Aluno a WHERE a.curso.id = :cursoId")
    Long contarAlunoPorCursoId(@Param("cursoId") Long cursoId);

    // Recuperar o total de tarefas por nome parcial da categoria usando JPQL
    @Query("SELECT COUNT(a) FROM Aluno a WHERE a.curso.nome LIKE %:nomeParcial%")
    Long contarAlunoPorCursoNomeParcial(@Param("nomeParcial") String nomeParcial);
}