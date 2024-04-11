package arquitetura.web.demo.services;

import arquitetura.web.demo.exceptions.AlunoNaoEncontradoException;
import arquitetura.web.demo.models.Aluno;
import arquitetura.web.demo.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {
    private final AlunoRepository alunoRepository;

    // public AlunoServiceImpl(AlunoRepository alunoRepository) {
    //    this.alunoRepository = alunoRepository;
    // }
    @Override
    public List<Aluno> obterTodos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno obter(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    @Override
    public Aluno adicionar(Aluno aluno) {
        aluno.setDocumento(aluno.getDocumento().replaceAll("[.-]", ""));
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno atualizar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public void excluir(Long id) {
        // Recuperar para verificar se o dado realmente existe
        Aluno task = obter(id);
        // Se não existe, lançamos uma exceção para que seja capturada no controller de forma que o erro seja exibido na resposta
        if (task == null)
            throw new AlunoNaoEncontradoException("O aluno com ID: " + id + " não foi encontrada.");

        alunoRepository.deleteById(id);
    }
}