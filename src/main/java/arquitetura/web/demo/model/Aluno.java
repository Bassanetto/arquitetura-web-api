package arquitetura.web.demo.model;

public class Aluno {
    private Long id;
    private String nome;
    private String documento;
    private String curso;
    private int idade;

    public Aluno(Long id, String nome, String documento, String curso, int idade) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.curso = curso;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
