package com.WarrantyTrackingApplication.demo.Device.service.concretes;

import com.WarrantyTrackingApplication.demo.Device.service.abstracts.IDeviceService;
import com.WarrantyTrackingApplication.demo.core.exception.NotFoundException;
import com.WarrantyTrackingApplication.demo.core.utiles.Msg;
import com.WarrantyTrackingApplication.demo.Device.repository.DeviceRepository;
import com.WarrantyTrackingApplication.demo.Device.model.entity.Device;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService implements IDeviceService {

    private final DeviceRepository deviceRepository;

    // Save a Device entity and return it
    @Override
    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    // Update an existing Device entity and return the updated entity
    @Override
    public Device update(Device device) {
        // Ensure the device exists before updating
        this.get(device.getId());
        return this.deviceRepository.save(device);
    }

    // Get a Device by ID, or throw NotFoundException if not found
    @Override
    public Device get(Long id) {
        return this.deviceRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    // Delete a Device by ID and return true if successful
    @Override
    public boolean delete(long id) {
        // Get the device to ensure it exists before deletion
        Device device = this.get(id);
        this.deviceRepository.delete(device);
        return true;
    }
}
