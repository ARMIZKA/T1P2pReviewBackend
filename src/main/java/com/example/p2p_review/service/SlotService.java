package com.example.p2p_review.service;


import com.example.p2p_review.model.Slot;
import com.example.p2p_review.repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlotService {

    private final SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public List<Slot> getAvailableSlots(Integer expertId) {
        return slotRepository.findByExpertIdAndAvailableTrue(expertId);
    }

    public Slot createSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    public Optional<Slot> getSlotById(Integer id) {
        return slotRepository.findById(id);
    }

    public Slot updateSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    public void deleteSlot(Integer id) {
        slotRepository.deleteById(id);
    }
}

