package com.mogila.api.controller;

import com.mogila.api.dto.DeviceDto;
import com.mogila.api.dto.DevicesDto;
import com.mogila.api.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/store")
public class StoreController {
    private final DeviceService deviceService;

    @PostMapping("/upload")
    public void upload(@RequestBody DevicesDto devices, Principal user) {
        deviceService.upload(devices.getDevices(), user.getName());
    }

    @GetMapping
    public List<DeviceDto> load(Principal user) {
        return deviceService.load(user.getName());
    }
}
