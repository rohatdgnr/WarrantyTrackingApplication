package com.WarrantyTrackingApplication.demo.core.modelMapper;
import org.modelmapper.ModelMapper;
public interface IModelMapperService {

    ModelMapper forRequest();
    ModelMapper forResponse();
}
