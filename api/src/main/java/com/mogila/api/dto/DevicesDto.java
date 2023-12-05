package com.mogila.api.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DevicesDto {
    private List<DeviceDto> devices;
}
