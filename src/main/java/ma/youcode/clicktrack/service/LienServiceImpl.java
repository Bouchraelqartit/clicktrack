package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.entity.Lien;
import ma.youcode.clicktrack.repository.LienRepository;

public class LienServiceImpl implements LienService {

    private final LienRepository lienRepository;

    public LienServiceImpl(LienRepository lienRepository){
        this.lienRepository = lienRepository;
    }

    public Lien createLien(int publisherId, String offre, String urlDestination){
        Lien lien = new Lien(0, offre, urlDestination, 0, publisherId);        lienRepository.save(lien);
        return lien;
    }
}
