package baralho.jogador.application.service;


import baralho.jogador.application.JogadorRequest;
import baralho.jogador.application.api.JogadorResponse;

public interface JogadorService {
    JogadorResponse criaJogador(JogadorRequest jogadorRequest);
}
