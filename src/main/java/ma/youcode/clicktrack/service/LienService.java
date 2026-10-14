package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.entity.Lien;

public interface LienService {
    Lien createLien(int publisherId, String offre, String urlDestination);
}
