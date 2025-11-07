package com.example.demo.birds;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "birds")
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long birdId;

    private String name;
    @Column(length = 1000)
    private String description;

    private String habitat;
    private String idInfo;
    private String gender;
    private LocalDate lastSeen;

    // ✅ New field to store uploaded image file name
    private String imageFileName;

    // ===== Constructors =====
    public Bird() {}

    public Bird(String name, String description, String habitat,
                String idInfo, String gender, LocalDate lastSeen, String imageFileName) {
        this.name = name;
        this.description = description;
        this.habitat = habitat;
        this.idInfo = idInfo;
        this.gender = gender;
        this.lastSeen = lastSeen;
        this.imageFileName = imageFileName;
    }

    // ===== Getters / Setters =====
    public Long getBirdId() {
        return birdId;
    }

    public void setBirdId(Long birdId) {
        this.birdId = birdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(String idInfo) {
        this.idInfo = idInfo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(LocalDate lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
