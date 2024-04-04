package arquitetura.web.demo.service;

import arquitetura.web.demo.model.Aluno;
import arquitetura.web.demo.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlunoServiceImpl implements AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    @Override
    public List<Aluno> obterTodos() {
        return alunoRepository.obterTodos();
    }

    @Override
    public Aluno obter(Long id) {
        return alunoRepository.obter(id);
    }

    @Override
    public Aluno adicionar(Aluno aluno) {
        return alunoRepository.adicionar(aluno);
    }

    @Override
    public Aluno atualizar(Long id, Aluno aluno) {
        return alunoRepository.atualizar(id, aluno);
    }

    @Override
    public Aluno excluir(Long id) {
        return alunoRepository.excluir(id);
    }
}