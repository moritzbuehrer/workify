package com.workify.Workify.Repository;

import com.workify.Workify.Entity.TimePiece;
import com.workify.Workify.Entity.TrackerStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrackerRepository extends CrudRepository<TrackerStatus, Long> {

    List<TrackerStatus> findByUsername(String username);
}
