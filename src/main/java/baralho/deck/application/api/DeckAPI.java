package baralho.deck.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deck")
public interface DeckAPI {
    @GetMapping("/embaralhamento")
    @ResponseStatus(code = HttpStatus.OK)
    DeckResponse embaralhaCartas(@RequestParam Integer quantidadeDeck);
}
