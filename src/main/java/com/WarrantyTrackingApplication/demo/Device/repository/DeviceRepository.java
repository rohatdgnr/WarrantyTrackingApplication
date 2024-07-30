package com.WarrantyTrackingApplication.demo.Device.repository;

import com.WarrantyTrackingApplication.demo.Device.model.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Long> {
}
