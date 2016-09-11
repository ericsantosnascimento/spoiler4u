package com.spoiler.dao;

import com.spoiler.Spoiler;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by User on 17/03/2016.
 */
public interface SpoilerDAO extends CrudRepository<Spoiler, Long>{

    @Query("SELECT sp FROM Spoiler sp ORDER BY RANDOM()")
    List<Spoiler> findByRandomSpoiler();
}
