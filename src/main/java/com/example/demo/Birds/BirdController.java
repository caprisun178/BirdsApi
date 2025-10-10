package com.example.demo.birds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BirdController {

  @Autowired
  private BirdService birdService;

  /**
   * Endpoint to get all birds
   *
   * @return List of all birds
   */
  @GetMapping("/birds")
  public Object getAllBirds() {
    return birdService.getAllBirds();
  }

  /**
   * Endpoint to get a bird by ID
   *
   * @param id The ID of the bird to retrieve
   * @return The bird with the specified ID
   */
  @GetMapping("/birds/{id}")
  public Bird getBirdById(@PathVariable long id) {
    return birdService.getBirdById(id);
  }

  /**
   * Endpoint to get birds by name
   *
   * @param name The name of the bird to search for
   * @return List of birds with the specified name
   */
  @GetMapping("/birds/name")
  public Object getBirdsByName(@RequestParam String key) {
    if (key != null) {
      return birdService.getBirdsByName(key);
    } else {
      return birdService.getAllBirds();
    }

  }

  /**
   * Endpoint to get birds by gender
   *
   * @param gender The gender to search for
   * @return List of birds with the specified gender
   */
  @GetMapping("/birds/gender/{gender}")
  public Object getBirdsByGender(@PathVariable String gender) {
    return birdService.getBirdsByGender(gender);
  }
    /**
   * Endpoint to add a new bird
   *
   * @param bird The bird to add
   * @return List of all birds
   */
  @PostMapping("/birds")
  public Object addBird(@RequestBody Bird bird) {
    return birdService.addBird(bird);
  }

  /**
   * Endpoint to update a bird
   *
   * @param id      The ID of the bird to update
   * @param bird The updated bird information
   * @return The updated bird
   */
  @PutMapping("/birds/{id}")
  public Bird updateBird(@PathVariable Long id, @RequestBody Bird bird) {
    birdService.updateBird(id, bird);
    return birdService.getBirdById(id);
  }

  /**
   * Endpoint to delete a bird
   *
   * @param id The ID of the bird to delete
   * @return List of all birds
   */
  @DeleteMapping("/birds/{id}")
  public Object deleteBird(@PathVariable Long id) {
    birdService.deleteBird(id);
    return birdService.getAllBirds();
  }

  /**
   * Endpoint to write a bird to a JSON file
   *
   * @param bird The bird to write
   * @return An empty string indicating success
   */
  @PostMapping("/birds/writeFile")
  public Object writeJson(@RequestBody Bird bird) {
    return birdService.writeJson(bird);
  }

  /**
   * Endpoint to read a JSON file and return its contents
   *
   * @return The contents of the JSON file
   */
  @GetMapping("/birds/readFile")
  public Object readJson() {
    return birdService.readJson();

  }
}