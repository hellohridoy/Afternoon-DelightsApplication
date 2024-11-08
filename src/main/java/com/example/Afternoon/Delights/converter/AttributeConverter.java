package com.example.Afternoon.Delights.converter;

import java.util.List;
import java.util.Map;

public interface AttributeConverter<T, T1> {
    String convertToDatabaseColumn(List<Map<String, Object>> attribute);
    List<Map<String, Object>> convertToEntityAttribute(String dbData);
}
