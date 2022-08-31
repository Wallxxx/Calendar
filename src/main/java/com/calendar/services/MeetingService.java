package com.calendar.services;

import com.calendar.dao.MeetingRepository;
import com.calendar.model.MeetingEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class MeetingService {

    private MeetingRepository meetingRepository;

    @Autowired
    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public MeetingEntity save(MeetingEntity meeting) {
        meetingRepository.save(meeting);
        return meeting;
    }

    public MeetingEntity delete(MeetingEntity meeting) {
        meetingRepository.delete(meeting);
        return meeting;
    }

    public void clear() {
        meetingRepository.deleteAll();
    }

    public List<MeetingEntity> getMeetingsByDate(String date) {
        return meetingRepository.findByDate(date);
    }


}
