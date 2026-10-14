
package ma.youcode.clicktrack.controller;

import ma.youcode.clicktrack.entity.Lien;
import ma.youcode.clicktrack.service.LienService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publishers")
public class LienController {

    private final LienService lienService;

    public LienController(LienService lienService) {
        this.lienService = lienService;
    }

    @PostMapping("/{id}/liens")
    @ResponseStatus(HttpStatus.CREATED)
    public Lien createLien(
            @PathVariable("id") int id,
            @RequestBody Lien lien) {

        return lienService.createLien(
                id,
                lien.getOffre(),
                lien.getUrlDestination()
        );
    }
}
