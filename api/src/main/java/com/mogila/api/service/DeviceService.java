package com.mogila.api.service;

import com.mogila.api.dto.DeviceDto;
import com.mogila.api.mapper.DeviceMapper;
import com.mogila.api.model.Device;
import com.mogila.api.model.User;
import com.mogila.api.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DeviceService {
    private final DeviceMapper deviceMapper;
    private final DatabaseUserDetailsService userDetailsService;
    private final DeviceRepository deviceRepository;

    @Transactional
    public void upload(@NonNull List<DeviceDto> devices, @NonNull String username) {
        final User user = userDetailsService.findUserByLogin(username);
        final List<Device> modelDevices = deviceMapper.toDeviceModel(devices).stream()
                        .map(device -> device.setUser(user))
                        .toList();

        deviceRepository.deleteAllUsersDevices(user.getId());
        deviceRepository.saveAll(modelDevices);
    }

    public List<DeviceDto> load(@NonNull String username) {
        return deviceRepository.findAllByUserLogin(username).stream()
                .map(deviceMapper::toDeviceDto)
                .toList();
    }
}
