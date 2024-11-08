package com.example.Afternoon.Delights.service;


import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.entity.JSONB;

import java.util.List;
import java.util.Optional;

public interface JSONBService {
    JSONB createJSONB(JSONB jsonbExample);
    List<JSONB> getAllJSONB();
    JSONB getJSONBById(Long id);
    JSONB updateJSONB(Long id, JSONB jsonbExample);
    void deleteJSONB(Long id);

}
