package baralho.carta.application.service;


import baralho.jogador.domain.Carta;

import java.util.List;

public interface CartaService {
    List<Carta> buscaCartas(String idDeck, Integer quantidadeCartas);
}
