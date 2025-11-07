package com.example.demo.birds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/birds")
public class BirdController {

    @Autowired
    private BirdService birdService;

    private static final String UPLOAD_DIR = "uploads/images";

    @GetMapping
   @GetMapping
public String getAllBirds(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String gender,
        @RequestParam(required = false) String habitat,
        Model model) {

    List<Bird> birds;

    if ((name != null && !name.isEmpty()) ||
        (gender != null && !gender.isEmpty()) ||
        (habitat != null && !habitat.isEmpty())) {
        birds = birdService.searchBirds(name, gender, habitat);
    } else {
        birds = birdService.getAllBirds();
    }

    model.addAttribute("birdList", birds);
    model.addAttribute("searchTerm", name);
    model.addAttribute("gender", gender);
    model.addAttribute("habitat", habitat);

    return "bird-list";
}


    @GetMapping("/{id}")
    public String getBirdById(@PathVariable long id, Model model) {
        Bird bird = birdService.getBirdById(id);
        if (bird == null) {
            return "redirect:/birds";
        }
        model.addAttribute("bird", bird);
        return "bird-details";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("bird", new Bird());
        return "bird-create";
    }

    @PostMapping("/new")
    public String createBird(@ModelAttribute Bird bird,
                             @RequestParam("image") MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            String fileName = imageFile.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.write(filePath, imageFile.getBytes());
            bird.setImageFileName(fileName);
        }
        birdService.addBird(bird);
        return "redirect:/birds";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Bird bird = birdService.getBirdById(id);
        if (bird == null) return "redirect:/birds";
        model.addAttribute("bird", bird);
        return "bird-update";
    }

    @PostMapping("/update")
    public String updateBird(@ModelAttribute Bird bird,
                             @RequestParam("image") MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            String fileName = imageFile.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.write(filePath, imageFile.getBytes());
            bird.setImageFileName(fileName);
        }
        birdService.updateBird(bird.getBirdId(), bird);
        return "redirect:/birds/" + bird.getBirdId();
    }

    @GetMapping("/delete/{id}")
    public String deleteBird(@PathVariable Long id) {
        birdService.deleteBird(id);
        return "redirect:/birds";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
}
