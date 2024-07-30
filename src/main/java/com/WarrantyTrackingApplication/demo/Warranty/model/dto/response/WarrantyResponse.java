package com.WarrantyTrackingApplication.demo.Warranty.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarrantyResponse {

    private Long id;
    private LocalDate purchaseDate;
    private String warrantyStatus;
    private Long deviceId;
}
