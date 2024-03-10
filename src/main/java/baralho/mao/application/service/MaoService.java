package baralho.mao.application.service;

import baralho.jogador.domain.Carta;
import baralho.jogador.domain.Jogador;
import baralho.jogo.domain.Mao;

import java.util.List;

public interface MaoService {
    List<Mao> adicionaMaos(List<Jogador> jogadores, List<Carta> cartas);
}
