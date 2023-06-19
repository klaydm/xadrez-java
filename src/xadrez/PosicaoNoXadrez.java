package xadrez;

import tabuleiro.Posicao;

public class PosicaoNoXadrez {
    private char coluna;
    private int linha;

    public PosicaoNoXadrez(char coluna, int linha) {
        if (coluna < 'A' || coluna > 'H' || linha < 1 || linha > 8) {
            throw new XadrezException("Erro ao digitar posição: Posições válidas são de A1 até H8");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    public char getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }

    protected Posicao converterPosicao() {
        return new Posicao(8 - linha, coluna - 'A');
    }

    protected static PosicaoNoXadrez converterPosicao(Posicao posicao) {
        return new PosicaoNoXadrez((char) ('A' - posicao.getColuna()), 8 - posicao.getLinha());
    }

    @Override
    public String toString() {
        return "" + coluna + linha;
    }
}
