package com.WarrantyTrackingApplication.demo.Device.service.abstracts;

import com.WarrantyTrackingApplication.demo.Device.model.entity.Device;

public interface IDeviceService {

       Device save(Device device);

       Device update(Device device);

       Device get(Long id);

       boolean delete(long id);
}
