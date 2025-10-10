package com.example.demo.birds;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {
    
    List<Bird> getBirdsByHabitat(String habitat);

    @Query(value = "select * from birds s where s.name like %?1% ", nativeQuery = true)
    List<Bird> getBirdsByName(String name);

    @Query(value = "select * from birds s where s.gender like %?1% ", nativeQuery = true)
    List<Bird> getBirdsByGender(String gender);
}
