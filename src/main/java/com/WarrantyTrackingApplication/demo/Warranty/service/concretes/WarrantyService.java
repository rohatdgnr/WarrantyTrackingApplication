package com.WarrantyTrackingApplication.demo.Warranty.service.concretes;

import com.WarrantyTrackingApplication.demo.Warranty.repository.WarrantyRepository;
import com.WarrantyTrackingApplication.demo.Warranty.model.entity.Warranty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarrantyService {


    @Autowired
    private WarrantyRepository warrantyRepository;

    public void updateWarrantyStatus(Long warrantyId) {
        Warranty warranty = warrantyRepository.findById(warrantyId)
                .orElseThrow(() -> new RuntimeException("Garanti bulunamadı"));

        warranty.checkWarrantyStatus();
        warrantyRepository.save(warranty);
    }

    public Warranty saveWarranty(Warranty warranty) {
        warranty.checkWarrantyStatus();
        return warrantyRepository.save(warranty);
    }

    public List<Warranty> getAllWarranties() {
        return warrantyRepository.findAll();
    }

    public Warranty getWarrantyById(Long id) {
        return warrantyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Garanti bulunamadı"));
    }

}
