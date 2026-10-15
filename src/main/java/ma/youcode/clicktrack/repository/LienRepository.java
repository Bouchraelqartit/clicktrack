package ma.youcode.clicktrack.repository;

import ma.youcode.clicktrack.entity.Lien;
import java.util.Optional;

public interface LienRepository {
    void save(Lien lien);
    Optional<Lien> findById(int id);

}
