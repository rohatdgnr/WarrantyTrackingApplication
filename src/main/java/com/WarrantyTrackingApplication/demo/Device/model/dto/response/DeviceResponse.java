package com.WarrantyTrackingApplication.demo.Device.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceResponse {
    private Long id;
    private String brand;
    private String serialNumber;
    private String model;

}
