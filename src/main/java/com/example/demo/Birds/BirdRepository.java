package com.example.demo.birds;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {

    List<Bird> getBirdsByHabitat(String habitat);

    @Query(value = "SELECT * FROM birds s WHERE s.name ILIKE CONCAT('%', :name, '%')", nativeQuery = true)
    List<Bird> getBirdsByName(@Param("name") String name);

    @Query(value = "SELECT * FROM birds s WHERE s.gender ILIKE CONCAT('%', :gender, '%')", nativeQuery = true)
    List<Bird> getBirdsByGender(@Param("gender") String gender);

    @Query("SELECT b FROM Bird b WHERE " +
       "(:name = '' OR LOWER(b.name) LIKE %:name%) AND " +
       "(:gender = '' OR LOWER(b.gender) LIKE %:gender%) AND " +
       "(:habitat = '' OR LOWER(b.habitat) LIKE %:habitat%)")
List<Bird> findByFilters(@Param("name") String name,
                         @Param("gender") String gender,
                         @Param("habitat") String habitat);

}
