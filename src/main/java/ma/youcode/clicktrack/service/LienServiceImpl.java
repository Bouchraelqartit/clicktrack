
package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.entity.Lien;
import ma.youcode.clicktrack.repository.LienRepository;

import java.util.Optional;

public class LienServiceImpl implements LienService {

    private final LienRepository lienRepository;

    public LienServiceImpl(LienRepository lienRepository) {
        this.lienRepository = lienRepository;
    }

    @Override
    public Lien createLien(int publisherId, String offre, String urlDestination) {
        Lien lien = new Lien(0, offre, urlDestination, 0, publisherId);
        lienRepository.save(lien);
        return lien;
    }

    @Override
    public synchronized Optional<Lien> trackClick(int id) {
        Optional<Lien> lienOptional = lienRepository.findById(id);

        if (lienOptional.isPresent()) {
            Lien lien = lienOptional.get();
            lien.setClicks(lien.getClicks() + 1);
        }

        return lienOptional;
    }
}
