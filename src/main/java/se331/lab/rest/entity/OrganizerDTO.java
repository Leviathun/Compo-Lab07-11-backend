package se331.lab.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerDTO {
    Long id;
    String name;
    List<String> imageUrl;
    List<OrganizerOwnEventsDTO> organizerOwnEvents = new ArrayList<>();
//    List<EventDTO> ownEvents = new ArrayList<>();
}


