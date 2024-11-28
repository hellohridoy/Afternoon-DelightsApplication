package com.example.Afternoon.Delights.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class FoodOrderResponseDto {
    private Long id;
    private String date;
    private String orderPin;
    private Double totalCost;
    private String foodItem;
    private List<PinResponse> pins;
    private Map<String, Double> amountPerMember;

    @Getter
    @Setter
    public static class PinResponse {
        private String pin;

        public PinResponse(String pin) {
            this.pin = pin;
        }
    }
}
