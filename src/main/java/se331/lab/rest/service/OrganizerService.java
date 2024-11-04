package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Organizer;

import java.util.List;
import java.util.Optional;

public interface OrganizerService {
    List<Organizer> getAllOrganizer();
    Page<Organizer> getOrganizer(Integer page, Integer pageSize);
    Organizer save(Organizer organizer);  // New method to save an organizer
    Optional<Organizer> findById(Long id);
}

