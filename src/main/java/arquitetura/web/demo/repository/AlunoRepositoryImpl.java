package arquitetura.web.demo.repository;

import arquitetura.web.demo.config.HibernateConfig;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import arquitetura.web.demo.models.Aluno;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {
    private final SessionFactory sessionFactory;
    public AlunoRepositoryImpl() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Aluno> obterTodos() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        List<Aluno> alunos = session.createQuery("FROM Aluno", Aluno.class).getResultList();
        transaction.commit();
        return alunos;
    }

    @Override
    public Aluno obter(Long id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        Aluno student = session.find(Aluno.class, id);
        transaction.commit();
        return student;
    }

    @Override
    @Deprecated(since = "6.0")
    public Aluno adicionar(Long id, Aluno aluno) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(aluno);
        transaction.commit();

        return aluno;
    }

    @Override
    public Aluno excluir(Long id){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        String hqlQuery = "DELETE FROM Aluno WHERE id = :alunoId";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("alunoId", id);

        int deletedCount = query.executeUpdate();
        transaction.commit();

        if (deletedCount > 0) {
            return new Aluno();
        } else {
            return null;
        }
    }
}