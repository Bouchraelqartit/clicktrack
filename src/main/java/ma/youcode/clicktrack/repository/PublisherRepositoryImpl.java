package ma.youcode.clicktrack.repository;

import ma.youcode.clicktrack.entity.Publisher;
import java.util.ArrayList;
import java.util.List;

public class PublisherRepositoryImpl implements PublisherRepository{
    private final List<Publisher> publishers = new ArrayList<>();

    public List<Publisher> findAll(){
        return publishers;
    }

}
