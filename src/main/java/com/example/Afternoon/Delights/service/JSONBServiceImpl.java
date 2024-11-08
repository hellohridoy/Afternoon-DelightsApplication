package com.example.Afternoon.Delights.service;


import com.example.Afternoon.Delights.entity.JSONB;
import com.example.Afternoon.Delights.repository.JSONBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JSONBServiceImpl implements JSONBService {

    private final JSONBRepository jsonBRepository;

    @Override
    public JSONB createJSONB(JSONB jsonbExample) {
        // Set default 'pin' value (if not set already)
        if (jsonbExample.getPin() == null) {

        }
        return jsonBRepository.save(jsonbExample);
    }

    @Override
    public List<JSONB> getAllJSONB() {
        return jsonBRepository.findAll();
    }

    @Override
    public JSONB getJSONBById(Long id) {
        Optional<JSONB> optionalJSONB = jsonBRepository.findById(id);
        return optionalJSONB.orElse(null); // Return null if not found
    }

    @Override
    public JSONB updateJSONB(Long id, JSONB jsonbExample) {
        Optional<JSONB> existingJSONB = jsonBRepository.findById(id);
        if (existingJSONB.isPresent()) {
            JSONB jsonbToUpdate = existingJSONB.get();
            jsonbToUpdate.setPinDateMapping(jsonbExample.getPinDateMapping());
            return jsonBRepository.save(jsonbToUpdate);
        }
        return null; // Return null if not found
    }

    @Override
    public void deleteJSONB(Long id) {
        jsonBRepository.deleteById(id);
    }
}
