package TerceiraLista;

import java.util.Scanner;

public class LSE {
    private Node primeiro;
    private int qtd;
    private Node ultimo;

    public boolean isEmpty() { // está vazia??
        if (this.primeiro == null && this.qtd == 0 && this.ultimo == null) {
            return true;
        } else {
            return false;
        }
    }

    public void alterarInfo(String matr) {
        Scanner in = new Scanner(System.in);
        Node aux;
        Aluno al;
        String nome;
        double media;
        int faltas;
        aux = this.buscar(matr);
        if (aux == null) {
            System.out.println("Matrícula inexistente!!!");
        } else {
            al = aux.getInfo();
            System.out.println("Aluno encontrado");
            System.out.print("Informe o nome do aluno: ");
            nome = in.nextLine();
            al.setNome(nome);
            System.out.print("Informe a média do aluno: ");
            media = in.nextDouble();
            in.nextLine();
            al.setMedia(media);
            System.out.print("Informe as faltas do aluno: ");
            faltas = in.nextInt();
            in.nextLine();
            al.setFaltas(faltas);
            System.out.println("Alterações efetuadas!");
        }
    }

    private Node buscar(String matr) {
        Node aux;
        if (this.isEmpty() == true) {
            return null;
        } else {
            Aluno proc = new Aluno(matr);
            aux = this.primeiro;
            while (aux != null) {
                if (aux.getInfo().equals(proc) == true) {
                    return aux;
                } else {
                    aux = aux.getProx();
                }
            }
            return null;
        }
    }

    public void inserirFinal(Aluno al) {
        Node novo = new Node(al);
        Node aux;
        if (this.isEmpty() == true) {
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd++;
            System.out.println("Inserção efetuada com sucesso!!!");
        } else {
            aux = this.buscar(al.getMatr());
            if (aux == null) {
                this.ultimo.setProx(novo);
                this.ultimo = novo;
                this.qtd++;
                System.out.println("Inserção efetuada com sucesso!!!");
            } else {
                System.out.println("Valor repetido. Não pode inserir.");
            }
        }
    }

    public void inserirInicio(Aluno al) {
        Node novo = new Node(al);
        Node aux;
        if (this.isEmpty() == true) {
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd++;
            System.out.println("Inserção efetuada com sucesso!!!");
        } else {
            aux = this.buscar(al.getMatr());
            if (aux == null) {
                novo.setProx(this.primeiro);
                this.primeiro = novo;
                this.qtd++;
                System.out.println("Inserção efetuada com sucesso!!!");
            } else {
                System.out.println("Valor repetido. Não pode inserir.");
            }
        }
    }

    public void exibirLista() {
        Node aux;
        if (this.isEmpty() == true) {
            System.out.println("Não existem alunos cadastrados!");
        } else {
            aux = this.primeiro;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    public void removerPrimeiro() {
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!!");
        } else if (this.qtd == 1) {
            this.primeiro = null;
            this.ultimo = null;
            this.qtd = 0;
            System.out.println("Remoção efetuada!");
        } else {
            this.primeiro = this.primeiro.getProx();
            this.qtd--;
            System.out.println("Remoção efetuada!");
        }
    }

    public void removerUltimo() {
        Node aux;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!!");
        } else if (this.qtd == 1) {
            this.primeiro = null;
            this.ultimo = null;
            this.qtd = 0;
            System.out.println("Remoção efetuada!");
        } else {
            aux = this.primeiro;
            while (aux.getProx() != this.ultimo) {
                aux = aux.getProx();
            }
            aux.setProx(null);
            this.ultimo = aux;
            this.qtd--;
            System.out.println("Remoção efetuada!");
        }
    }

    public void searchAndDelete(String matr) {
        Node aux;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!!");
        } else {
            aux = this.buscar(matr);
            if (aux != null) {
                if (aux.equals(this.primeiro)) {
                    this.removerPrimeiro();
                } else if (aux.equals(this.ultimo)) {
                    this.removerUltimo();
                } else {
                    Node proximo = aux.getProx();
                    Node anterior = this.primeiro;
                    while (anterior.getProx() != aux) {
                        anterior = anterior.getProx();
                    }
                    anterior.setProx(proximo);
                    System.out.println("Remoção efetuada!");
                    this.qtd--;
                }

            } else {
                System.out.println("Matrícula inexistente!!!");
            }
        }
    }
}