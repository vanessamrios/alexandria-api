package com.betrybe.alexandria.services;

import com.betrybe.alexandria.entities.Publisher;
import com.betrybe.alexandria.exceptions.PublisherNOtFoundException;
import com.betrybe.alexandria.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher findById(Long id) throws PublisherNOtFoundException {
        return publisherRepository.findById(id).orElseThrow(PublisherNOtFoundException::new);
    }

    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    public Publisher create(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Publisher update(Publisher publisher, Long id) throws PublisherNOtFoundException {
        Publisher publisherDB = findById(id);

        publisherDB.setName(publisher.getName());
        publisherDB.setAddress(publisher.getAddress());

        return publisherRepository.save(publisherDB);
    }

    public Publisher deleteById(Long id) throws PublisherNOtFoundException {
        Publisher publisherDb = findById(id);
        publisherRepository.deleteById(id);
        return publisherDb;
    }
}
