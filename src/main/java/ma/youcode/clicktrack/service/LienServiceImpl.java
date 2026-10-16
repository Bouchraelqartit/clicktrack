package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.entity.Lien;
import ma.youcode.clicktrack.repository.LienRepository;
import java.util.*;

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

    @Override
    public List<Lien> findByPublisherId(int publisherId) {
        return lienRepository.findByPublisherId(publisherId);
    }

    @Override
    public List<Map<String, Object>> findOffresByPublisherId(int publisherId) {
        List<Lien> liens = lienRepository.findByPublisherId(publisherId);

        Map<String, Map<String, Object>> offres = new LinkedHashMap<>();

        for (Lien lien : liens) {
            String nomOffre = lien.getOffre();

            if (!offres.containsKey(nomOffre)) {
                Map<String, Object> statistiques = new LinkedHashMap<>();
                statistiques.put("offre", nomOffre);
                statistiques.put("nombreLiens", 0);
                statistiques.put("totalClicks", 0);

                offres.put(nomOffre, statistiques);
            }

            Map<String, Object> statistiques = offres.get(nomOffre);

            int nombreLiens = (int) statistiques.get("nombreLiens");
            statistiques.put("nombreLiens", nombreLiens + 1);

            int totalClicks = (int) statistiques.get("totalClicks");
            statistiques.put("totalClicks", totalClicks + lien.getClicks());
        }

        return new ArrayList<>(offres.values());
    }
}
