package com.WarrantyTrackingApplication.demo.Warranty.repository;

import com.WarrantyTrackingApplication.demo.Warranty.model.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarrantyRepository extends JpaRepository<Warranty,Long> {
}
