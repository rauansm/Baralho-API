package baralho.deck.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "deckClienteFein", url = "https://deckofcardsapi.com/api/deck")
public interface DeckClientFeign {

    @GetMapping("/new/shuffle/")
    DeckFeignReponse embaralhaCartas(@RequestParam("deck_count") Integer quantidadeDeck);
}
