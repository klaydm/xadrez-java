package aplicacao;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoNoXadrez;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        PartidaDeXadrez partida = new PartidaDeXadrez();

        while (true){
            UI.imprimirTabuleiro(partida.getPecas());
            System.out.println();
            System.out.print("Origem: ");
            PosicaoNoXadrez origem = UI.lerPosicaoDaPeca(scan);
            System.out.println();
            System.out.print("Destino: ");
            PosicaoNoXadrez destino = UI.lerPosicaoDaPeca(scan);

            PecaDeXadrez pecaCapturada = partida.movimentarPeca(origem, destino);
        }
    }
}
