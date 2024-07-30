package com.WarrantyTrackingApplication.demo.Device.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceUpdateRequest {

    private Long id;
    private String brand;
    private String serialNumber;
    private String model;
}
