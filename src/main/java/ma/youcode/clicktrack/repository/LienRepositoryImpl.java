package ma.youcode.clicktrack.repository;

import ma.youcode.clicktrack.entity.Lien;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LienRepositoryImpl implements LienRepository {

    private final List<Lien> liens = new ArrayList<>();
    private int nextId = 1;

    @Override
    public synchronized void save(Lien lien) {
        lien.setId(nextId++);
        liens.add(lien);
    }

    @Override
    public synchronized Optional<Lien> findById(int id) {
        return liens.stream()
                .filter(lien -> lien.getId() == id)
                .findFirst();
    }
}
