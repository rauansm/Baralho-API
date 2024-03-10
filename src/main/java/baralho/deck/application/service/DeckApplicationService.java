package baralho.deck.application.service;

import baralho.deck.application.api.DeckResponse;
import baralho.deck.infra.DeckClientFeign;
import baralho.deck.infra.DeckFeignReponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class DeckApplicationService implements DeckService {
    private final DeckClientFeign deckClientFeign;
    @Override
    public DeckResponse embaralhaCartas(Integer quantidadeDeck) {
        log.debug("[inicia] DeckApplicationService - embaralhaCartas");
        DeckFeignReponse cartasEmbaralhadas = deckClientFeign.embaralhaCartas(quantidadeDeck);
        log.debug("[finaliza] DeckApplicationService - embaralhaCartas");
        return new DeckResponse(cartasEmbaralhadas);
    }

}
