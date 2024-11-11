package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.dao.PinDao;
import com.example.Afternoon.Delights.entity.Detail;
import com.example.Afternoon.Delights.entity.Pin;
import com.example.Afternoon.Delights.repository.DetailRepository;
import com.example.Afternoon.Delights.repository.PinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PinServiceImpl implements PinService {

    private final PinDao pinDao;

    @Override
    public Pin savePin(Pin pin) {
        return pinDao.savePin(pin);
    }

    @Override
    public List<Pin> getAllPins() {
        return pinDao.getAllPins();
    }

    @Override
    public Pin getPinByPin(String pin) {
        return pinDao.findByPin(pin);
    }
}
