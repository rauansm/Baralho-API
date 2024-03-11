package baralho.deck.application.api;

import baralho.deck.application.service.DeckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class DeckController implements DeckAPI {
    private final DeckService deckService;

    @Override
    public DeckResponse embaralhaCartas(Integer quantidadeDeck) {
        log.info("[inicia] DeckController - embaralhaCartas");
        DeckResponse cartasEmbaralhadas = deckService.embaralhaCartas(quantidadeDeck);
        log.info("[finaliza] DeckController - embaralhaCartas");
        return cartasEmbaralhadas;
    }
}
