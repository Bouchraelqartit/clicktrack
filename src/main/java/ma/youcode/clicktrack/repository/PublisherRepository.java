package ma.youcode.clicktrack.repository;

import ma.youcode.clicktrack.entity.Publisher;
import java.util.List;

public interface PublisherRepository {

    List<Publisher> findAll();
    Publisher save(Publisher publisher);
}
