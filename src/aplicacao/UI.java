package aplicacao;

import xadrez.Cor;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoNoXadrez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static PosicaoNoXadrez lerPosicaoDaPeca(Scanner scan) {
        try {
            String s = scan.nextLine();
            char coluna = s.charAt(0);
            int linha = Integer.parseInt(s.substring(1));
            return new PosicaoNoXadrez(coluna, linha);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Erro ao ler posição do xadrez, valores válidos são de A1 até H8");
        }
    }

    public static void imprimirTabuleiro(PecaDeXadrez[][] pecas){
        for (int i = 0; i < pecas.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                imprimirPeca(pecas[i][j]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    private static void imprimirPeca(PecaDeXadrez peca){
        if(peca == null){
            System.out.print("-");
        }else{
            if(peca.getCor() == Cor.BRANCA){
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);
            }else{
                System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }
}
