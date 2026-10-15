package ma.youcode.clicktrack.controller;

import ma.youcode.clicktrack.entity.Lien;
import ma.youcode.clicktrack.service.LienService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TrackingController {

    private final LienService lienService;

    public TrackingController(LienService lienService) {
        this.lienService = lienService;
    }

    @GetMapping("/t/{id}")
    public Lien trackClick(@PathVariable("id") int id) {
        return lienService.trackClick(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Lien introuvable")
                );
    }
}
