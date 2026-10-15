package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.entity.Lien;
import java.util.Optional;

public interface LienService {
    Lien createLien(int publisherId, String offre, String urlDestination);
    Optional<Lien> trackClick(int id);
}
