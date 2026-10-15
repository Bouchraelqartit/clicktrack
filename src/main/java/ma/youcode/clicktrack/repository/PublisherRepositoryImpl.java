package ma.youcode.clicktrack.repository;

import ma.youcode.clicktrack.entity.Categorie;
import ma.youcode.clicktrack.entity.Publisher;
import java.util.ArrayList;
import java.util.List;

public class PublisherRepositoryImpl implements PublisherRepository {

    private final List<Publisher> publishers = new ArrayList<>();
    private int nextId = 3;

    public PublisherRepositoryImpl() {
        publishers.add(new Publisher(
                1, "Ali", "Sara", "ali@example.com", Categorie.blogger
        ));

        publishers.add(new Publisher(
                2, "Amine", "Youssef", "amine@example.com", Categorie.youtuber
        ));
    }

    @Override
    public List<Publisher> findAll() {
        return publishers;
    }

    @Override
    public Publisher save(Publisher publisher) {
        publisher.setId(nextId++);
        publishers.add(publisher);
        return publisher;
    }
}