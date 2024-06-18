package com.example.GetRide.repository;

import com.example.GetRide.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CabRepository extends JpaRepository<Cab,Integer> {

    @Query(value = "select * from cab where booked = 0 order by rand() limit 1",nativeQuery = true)
    Optional<Cab> getRandomAvailableCab();
}
