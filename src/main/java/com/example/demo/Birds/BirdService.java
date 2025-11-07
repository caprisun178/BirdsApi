package com.example.demo.birds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BirdService {

    @Autowired
    private BirdRepository birdRepository;

    public List<Bird> getAllBirds() {
        return birdRepository.findAll();
    }

    public List<Bird> searchBirds(String name, String gender, String habitat) {
    if ((name == null || name.isEmpty()) &&
        (gender == null || gender.isEmpty()) &&
        (habitat == null || habitat.isEmpty())) {
        return birdRepository.findAll();
    }
    return birdRepository.findByFilters(
            name != null ? name.toLowerCase() : "",
            gender != null ? gender.toLowerCase() : "",
            habitat != null ? habitat.toLowerCase() : ""
    );
}


    public Bird getBirdById(Long id) {
        return birdRepository.findById(id).orElse(null);
    }

    public Bird addBird(Bird bird) {
        return birdRepository.save(bird);
    }

    public Bird updateBird(Long id, Bird updatedBird) {
        Bird existing = birdRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(updatedBird.getName());
        existing.setDescription(updatedBird.getDescription());
        existing.setHabitat(updatedBird.getHabitat());
        existing.setIdInfo(updatedBird.getIdInfo());
        existing.setGender(updatedBird.getGender());
        existing.setLastSeen(updatedBird.getLastSeen());
        existing.setImageFileName(updatedBird.getImageFileName());

        return birdRepository.save(existing);
    }

    public void deleteBird(Long id) {
        birdRepository.deleteById(id);
    }

    public List<Bird> getBirdsByName(String name) {
        return birdRepository.getBirdsByName(name);
    }
}
