package baralho.deck.application.api;

import baralho.deck.infra.DeckFeignReponse;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class DeckResponse {

    private String idDeck;
    private Integer quantidadeRestante;
    private boolean embaralhado;

    public DeckResponse(DeckFeignReponse cartasEmbaralhadas) {
        this.idDeck = cartasEmbaralhadas.getDeck_id();
        this.quantidadeRestante = cartasEmbaralhadas.getRemaining();
        this.embaralhado = cartasEmbaralhadas.isShuffled();
    }
}
