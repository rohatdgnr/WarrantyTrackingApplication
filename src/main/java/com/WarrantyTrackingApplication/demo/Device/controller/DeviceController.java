package com.WarrantyTrackingApplication.demo.Device.controller;

import com.WarrantyTrackingApplication.demo.Device.service.abstracts.IDeviceService;
import com.WarrantyTrackingApplication.demo.core.modelMapper.IModelMapperService;
import com.WarrantyTrackingApplication.demo.core.result.Result;
import com.WarrantyTrackingApplication.demo.core.result.ResultData;
import com.WarrantyTrackingApplication.demo.core.utiles.ResultHelper;
import com.WarrantyTrackingApplication.demo.Device.model.dto.request.DeviceSaveRequest;
import com.WarrantyTrackingApplication.demo.Device.model.dto.request.DeviceUpdateRequest;
import com.WarrantyTrackingApplication.demo.Device.model.dto.response.DeviceResponse;
import com.WarrantyTrackingApplication.demo.Device.model.entity.Device;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("device")
@RequiredArgsConstructor
public class DeviceController {

    private final IDeviceService deviceService;
    private final IModelMapperService modelMapper;



    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DeviceResponse> get(@PathVariable ("id") Long id){
        Device device =this.deviceService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(device , DeviceResponse.class));
    }





    @PostMapping("/created")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<DeviceResponse> save(@Valid @RequestBody DeviceSaveRequest deviceSaveRequest){
        Device saveDevice = this.modelMapper.forRequest().map(deviceSaveRequest , Device.class);
        this.deviceService.save(saveDevice);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveDevice,DeviceResponse.class));
    }



    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DeviceResponse> update(@PathVariable Long id, @Valid @RequestBody DeviceUpdateRequest deviceUpdateRequest){
        Device updateDevice = this.modelMapper.forRequest().map(deviceUpdateRequest , Device.class);
        this.deviceService.update(updateDevice);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateDevice, DeviceResponse.class));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable ("id") Long id){
        this.deviceService.delete(id);
        return ResultHelper.Ok();
    }
}
