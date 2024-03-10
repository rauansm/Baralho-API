package baralho.deck.application.service;


import baralho.deck.application.api.DeckResponse;

public interface DeckService {
    DeckResponse embaralhaCartas(Integer quantidadeDeck);
}
