package xadrez;

import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {

    private Tabuleiro tabuleiro;

    public PartidaDeXadrez(){
        tabuleiro = new Tabuleiro(8, 8);
        posicaoInicial();
    }

    public PecaDeXadrez[][] getPecas(){
        PecaDeXadrez[][] matriz = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                matriz[i][j] = (PecaDeXadrez) tabuleiro.peca(i,j);
            }
        }
        return matriz;
    }

    private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca){
        tabuleiro.colocarPeca(peca, new PosicaoNoXadrez(coluna, linha).converterPosicao());
    }

    private void posicaoInicial(){
        colocarNovaPeca('C', 1, new Torre(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('C', 2, new  Torre(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('D', 2, new  Torre(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('E', 2, new  Torre(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('E', 1, new  Torre(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('D', 1, new Rei(tabuleiro, Cor.BRANCA));

        colocarNovaPeca('C', 7, new  Torre(tabuleiro, Cor.PRETA));
        colocarNovaPeca('C', 8, new Torre(tabuleiro, Cor.PRETA));
        colocarNovaPeca('D', 7, new Torre(tabuleiro, Cor.PRETA));
        colocarNovaPeca('D', 8, new Torre(tabuleiro, Cor.PRETA));
        colocarNovaPeca('E', 7, new Torre(tabuleiro, Cor.PRETA));
        colocarNovaPeca('E', 8, new Rei(tabuleiro, Cor.PRETA));
    }
}
