package com.workify.Workify.Repository;

import com.workify.Workify.Entity.TimePiece;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface TimePieceRepository extends CrudRepository<TimePiece, Long> {

    List<TimePiece> findByDate(Date date);

}
