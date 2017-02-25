package com.joshphilpott.repository;

import com.joshphilpott.models.Pledge;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pterodactyl on 2/18/17.
 */
public interface PledgeRepository extends CrudRepository<Pledge, Long>{
}
