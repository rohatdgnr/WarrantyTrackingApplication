package com.WarrantyTrackingApplication.demo.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Result {
    private boolean sutatus;
    private String message;
    private String code;
}