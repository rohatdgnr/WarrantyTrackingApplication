package com.WarrantyTrackingApplication.demo.Warranty.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarrantyUpdateRequest {

    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH")
    private LocalDate purchaseDate;
    private String warrantyStatus;
    private long deviceId;

}
