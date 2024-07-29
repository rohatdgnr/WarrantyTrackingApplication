# Warranty Tracking Application
## Overview

The Warranty Tracking System is a comprehensive application for managing device warranties. It provides endpoints to create, update, retrieve, and delete device and warranty records. The application uses Spring Boot for the backend and includes various features for handling device and warranty information.

## Features

- **Device Management**: Create, update, retrieve, and delete devices.
- **Warranty Management**: Add, update, retrieve, and delete warranties.
- **Exception Handling**: Global exception handling with custom error responses.
- **Data Validation**: Input validation for device and warranty requests.

## Technologies

- **Backend**: Spring Boot
- **Database**: PostgreSQL
- **Exception Handling**: Custom exceptions with detailed responses
- **Validation**: Jakarta Bean Validation
- **Mapping**: MapStruct

## Endpoints

### Device Endpoints

- **Create Device**
  - `POST /device`
  - Request Body: `CreateDeviceRequest`
  - Response: `DataResponse<DeviceResponse>`

- **Update Device**
  - `PUT /device`
  - Request Body: `UpdateDeviceRequest`
  - Response: `DataResponse<DeviceResponse>`

- **Get All Devices**
  - `GET /device`
  - Response: `DataResponse<List<DeviceResponse>>`

- **Get Device by ID**
  - `GET /device/{deviceId}`
  - Path Variable: `deviceId`
  - Response: `DataResponse<DeviceResponse>`

- **Delete Device**
  - `DELETE /device/{deviceId}`
  - Path Variable: `deviceId`
  - Response: `String`

### Warranty Endpoints

- **Create Warranty**
  - `POST /warranty`
  - Request Body: `AddWarrantRequest`
  - Response: `DataResponse<WarrantyResponse>`

- **Update Warranty**
  - `PUT /warranty`
  - Request Body: `UpdateWarrantRequest`
  - Response: `DataResponse<WarrantyResponse>`

- **Get Warranty by ID**
  - `GET /warranty/{warrantyId}`
  - Path Variable: `warrantyId`
  - Response: `DataResponse<WarrantyResponse>`

- **Get All Warranties**
  - `GET /warranty`
  - Response: `DataResponse<List<WarrantyResponse>>`

- **Delete Warranty**
  - `DELETE /warranty/{warrantyId}`
  - Path Variable: `warrantyId`
  - Response: `String`

## Error Handling

The application provides detailed error responses for various scenarios:

- **Validation Errors**
  - HTTP Status: `400 Bad Request`
  - Response: `ExceptionResponse`

- **Device Not Found**
  - HTTP Status: `404 Not Found`
  - Response: `ExceptionResponse`

- **Existing Device**
  - HTTP Status: `400 Bad Request`
  - Response: `ExceptionResponse`

- **Warranty Not Found**
  - HTTP Status: `404 Not Found`
  - Response: `ExceptionResponse`

## Models

### Device

- `DeviceEntity`: Represents a device in the database.
- `CreateDeviceRequest`: DTO for creating a new device.
- `UpdateDeviceRequest`: DTO for updating an existing device.
- `DeviceResponse`: DTO for responding with device information.

### Warranty

- `WarrantyEntity`: Represents a warranty in the database.
- `AddWarrantRequest`: DTO for adding a new warranty.
- `UpdateWarrantRequest`: DTO for updating an existing warranty.
- `WarrantyResponse`: DTO for responding with warranty information.
