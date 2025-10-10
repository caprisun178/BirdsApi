package com.example.demo.birds;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "birds")
public class Bird {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long birdId;

  @Column(nullable = false)
  private String name;

  private String description;
  private String habitat;
  private String idInfo;
  private String Gender;

  @Column(nullable = false)
  private Date lastSeen;

  public Bird() {
  }

  public Bird(Long birdId, String name, String description, String habitat, String idInfo, String gender) {
    this.birdId = birdId;
    this.name = name;
    this.description = description;
    this.habitat = habitat;
    this.idInfo = idInfo;
    this.Gender = gender;
  }

  public Bird(String name, String description, String habitat, String idInfo) {
    this.name = name;
    this.description = description;
    this.habitat = habitat;
    this.idInfo = idInfo;
  }

  public Long getBirdId() {
    return birdId;
  }

  public void setBirdId(Long id) {
    this.birdId = id;
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
    return Gender;
  }

  public void setGender(String gender) {
    this.Gender = gender;
  }
}
