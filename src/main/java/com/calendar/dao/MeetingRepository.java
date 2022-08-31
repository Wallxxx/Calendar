package com.calendar.dao;

import com.calendar.model.MeetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeetingRepository extends JpaRepository<MeetingEntity, Long> {

    @Query(value = "select u from MeetingEntity u where lower(u.name) = lower(:name)")
    List<MeetingEntity> findByName(@Param("name") String name);

    @Query(value = "select u from MeetingEntity u where u.date = :date")
    List<MeetingEntity> findByDate(@Param("date") String date);
}
