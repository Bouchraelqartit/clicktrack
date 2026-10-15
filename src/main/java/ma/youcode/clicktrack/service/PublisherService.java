package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.entity.Publisher;

import java.util.List;

public interface PublisherService {
    List<Publisher> findAll();
    Publisher save(Publisher publisher);
}
