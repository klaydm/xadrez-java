package aplicacao;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoNoXadrez;
import xadrez.XadrezException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        PartidaDeXadrez partida = new PartidaDeXadrez();

        while (true){
            try {
                UI.limparTela();
                UI.imprimirTabuleiro(partida.getPecas());
                System.out.println();
                System.out.print("Origem: ");
                PosicaoNoXadrez origem = UI.lerPosicaoDaPeca(scan);
                System.out.println();
                System.out.print("Destino: ");
                PosicaoNoXadrez destino = UI.lerPosicaoDaPeca(scan);

                PecaDeXadrez pecaCapturada = partida.movimentarPeca(origem, destino);
            }catch(XadrezException e){
                System.out.println(e.getMessage());
                scan.nextLine();
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }
    }
}
