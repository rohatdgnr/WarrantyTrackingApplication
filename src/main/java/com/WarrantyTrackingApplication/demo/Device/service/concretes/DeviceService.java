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


    @Override
    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device update(Device device) {
        this.get(device.getId());
        return this.deviceRepository.save(device);
    }

    @Override
    public Device get(Long id) {
        return this.deviceRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public boolean delete(long id) {
        Device device =this.get(id);
        this.deviceRepository.delete(device);
        return true;
} }
