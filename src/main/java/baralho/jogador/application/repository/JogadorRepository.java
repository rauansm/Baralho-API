package baralho.jogador.application.repository;


import baralho.jogador.domain.Jogador;

import java.util.List;

public interface JogadorRepository {
    Jogador salva(Jogador jogador);

    List<Jogador> listaJogadores (List<Long> jogadres);
}
