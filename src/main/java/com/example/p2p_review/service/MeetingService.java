package com.example.p2p_review.service;


import com.example.p2p_review.model.Meeting;
import com.example.p2p_review.repository.MeetingRepository;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {

    private final MeetingRepository meetingRepository;

    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public Meeting bookMeeting(Meeting meeting) {
        meeting.getSlot().setAvailable(false);
        return meetingRepository.save(meeting);
    }
}

