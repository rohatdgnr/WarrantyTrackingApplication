package com.WarrantyTrackingApplication.demo.Warranty.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarrantySaveRequest {

    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH")
    private LocalDate purchaseDate;
    private String warrantyStatus;
    private long deviceId;
}
