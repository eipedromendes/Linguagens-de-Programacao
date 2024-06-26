import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class LotoFacil {

    public static void main(String[] args) throws IOException {
        menu();
    }

    private static void menu() throws IOException {
        int opcao = -1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("**************************");
            System.out.println("Menu LOTOFÁCIL");
            System.out.println("1) Apostar de 0 a 100");
            System.out.println("2) Apostar de A á Z");
            System.out.println("3) Apostar em par ou ímpar");
            System.out.println("0) Sair");
            System.out.println("**************************");

            System.out.print("\nEscolha uma opção para jogar: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    apostaIntervalo(sc);
                    break;
                case 2:
                    apostaLetra(sc);
                    break;
                case 3:
                    apostaParImpar(sc);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        } while (opcao != 0);
        sc.close();
    }

    private static void apostaIntervalo(Scanner sc) {
        System.out.println("\nAposta de 0 a 100 selecionada.");
        Random rnd = new Random();
        int sorteio = rnd.nextInt(101);
        System.out.print("Digite um número de 0 a 100 para apostar: ");
        int aposta = sc.nextInt();

        if (aposta < 0 || aposta > 100) {
            System.out.println("Aposta inválida.");
        } else {
            if (aposta == sorteio) {
                System.out.println("Você ganhou R$ 1.000,00 reais.");
            } else {
                System.out.println("Que pena! O número sorteado foi: " + sorteio);
            }
        }
    }

    private static void apostaLetra(Scanner sc) throws IOException {
        System.out.println("\nAposta de A á Z selecionada.");
        Random rnd = new Random();
        char letraSorteada = (char) (rnd.nextInt(26) + 'A'); // Sorteia uma letra de A a Z
        System.out.print("Digite uma letra de A á Z para apostar: ");
        char letraApostada = sc.next().toUpperCase().charAt(0);

        if (Character.isLetter(letraApostada)) {
            if (letraApostada == letraSorteada) {
                System.out.println("Você ganhou R$ 500,00 reais.");
            } else {
                System.out.println("Que pena! A letra sorteada foi: " + letraSorteada);
            }
        } else {
            System.out.println("Aposta inválida.");
        }
    }

    private static void apostaParImpar(Scanner sc) {
        System.out.println("\nAposta em par ou ímpar selecionada.");
        System.out.print("Digite um número inteiro para apostar: ");
        int numeroDigitado = sc.nextInt();

        if (numeroDigitado % 2 == 0) {
            System.out.println("Você ganhou R$ 100,00 reais.");
        } else {
            System.out.println("Que pena! Você perdeu, o sorteio era para números pares.");
        }
    }
}