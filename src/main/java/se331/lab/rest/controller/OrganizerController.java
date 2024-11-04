package se331.lab.rest.controller;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.OrganizerDTO;
import se331.lab.rest.service.OrganizerService;
import se331.lab.rest.util.CloudStorageHelper;
import se331.lab.rest.util.LabMapper;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class OrganizerController {
    final OrganizerService organizerService;
    final CloudStorageHelper cloudStorageHelper;

    @GetMapping("/organizers")
    public ResponseEntity<?> getOrganizers() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDTO(organizerService.getAllOrganizer()));
    }

    @PostMapping("/organizers")
    public ResponseEntity<?> createOrganizer(
            @RequestBody Organizer organizer)throws IOException, ServletException {
        Organizer savedOrganizer = organizerService.save(organizer);
        OrganizerDTO organizerDTO = LabMapper.INSTANCE.getOrganizerDTO(savedOrganizer);
        return ResponseEntity.ok(organizerDTO);
    }
    @GetMapping("/organizers/{id}")
    public ResponseEntity<?> getOrganizerDetails(@PathVariable Long id) {
        Organizer organizer = organizerService.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizer not found"));
        return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDTO(organizer));
    }
}