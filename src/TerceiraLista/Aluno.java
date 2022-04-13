package TerceiraLista;

public class Aluno {
    private String matr;
    private String nome;

    // método construtor
    public Aluno(String matr, String nome) {
        this.matr = matr;
        this.nome = nome;
    }

    public Aluno(String matr) {
        this.matr = matr;
    }

    // métodos get e set

    public void setMatr(String matr) {
        this.matr = matr;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatr() {
        return this.matr;
    }

    public String getNome() {
        return this.nome;
    }

    // método toString
    public String toString() {
        return this.matr + " " + this.nome;
    }

    public boolean equals(Aluno al) {
        if (this.matr.equals(al.matr) == true) {
            return true;
        } else {
            return false;
        }
    }
}