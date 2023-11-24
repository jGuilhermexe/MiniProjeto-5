import java.util.ArrayList;
import java.util.Scanner;

public class Capitulo {
    String texto;
    Personagem Cebolinha;
    Personagem Cascao;
    int incrementoCebolinha;
    int incrementoCascao;
    Scanner plano;
    ArrayList<Escolhas> escolhas;

    public Capitulo(String texto, Personagem Cebolinha, Personagem Cascao, int incrementoCebolinha, int incrementoCascao, Scanner plano) {
        this.texto = texto;
        this.Cebolinha = Cebolinha;
        this.Cascao = Cascao;
        this.incrementoCascao = incrementoCascao;
        this.incrementoCebolinha = incrementoCebolinha;
        this.plano = plano;
        this.escolhas = new ArrayList<>();
    }

    public void adicionarEscolha(String texto, Capitulo proximoCapitulo) {
        Escolhas escolha = new Escolhas(texto, proximoCapitulo);
        escolhas.add(escolha);
    }

    public void mostrar() {
        System.out.println(texto);
        Cebolinha.atualizarCoragem(incrementoCebolinha);
        Cascao.atualizarCoragem(incrementoCascao);

        for (int i = 0; i < escolhas.size(); i++) {
            System.out.println("- " + escolhas.get(i).texto);
        }

        System.out.println();
        System.out.println(". . .");
        System.out.println();
    }

    public Capitulo escolher() {
        int opcaoEscolhida = 0;
        String escolha;
        boolean escolhaCorreta = false;

        if (escolhas.isEmpty()) {
            System.out.println("OBRIGADO POR PARTICIPAR DAS AVENTURAS DE CASCAO E CEBOLINHA, ESPERO QUE TENHA CHEGADO AO FINAL DESEJADO!!");
            System.exit(0);
        } else {
            while (!escolhaCorreta) {
                escolha = plano.nextLine();
                for (int i = 0; i < escolhas.size(); i++) {
                    if (escolha.equals(escolhas.get(i).texto)) {
                        escolhaCorreta = true;
                        opcaoEscolhida = i;
                    }
                }
                if (!escolhaCorreta) {
                    System.out.println("Escolha inválida, Tente novamente!");
                    escolhaCorreta = false;
                    return null;
                }
            }
        }
        return escolhas.get(opcaoEscolhida).proximo;
    }

    public void executar() {
        mostrar();
        Capitulo proximoCapitulo = escolher();

        if (proximoCapitulo != null) {
            proximoCapitulo.executar();
        } else {
            System.out.println("Obrigado por jogar!");
            System.exit(0);
        }
    }
}
