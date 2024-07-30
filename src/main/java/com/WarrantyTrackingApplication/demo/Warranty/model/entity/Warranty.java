package com.WarrantyTrackingApplication.demo.Warranty.model.entity;

import com.WarrantyTrackingApplication.demo.Device.model.entity.Device;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "warranty")
public class Warranty {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warranty_id")
    private Long id;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "warranty_status", nullable = false)
    private String warrantyStatus;

    @OneToOne
    @JoinColumn(name = "device_id")
    private Device device;

    public void checkWarrantyStatus() {
        if (purchaseDate != null) {
            LocalDate now = LocalDate.now();
            LocalDate warrantyExpiryDate = purchaseDate.plusYears(2);
            if (now.isAfter(warrantyExpiryDate)) {
                this.warrantyStatus = "Garanti Süresi Dolmuş";
            } else {
                this.warrantyStatus = "Garanti Geçerli";
            }
        }
    }




}
