package com.mogila.api.mapper;

import com.mogila.api.dto.DeviceDto;
import com.mogila.api.model.Device;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        RepairMapper.class,
        VerificationMapper.class
})
public interface DeviceMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Device toDeviceModel(DeviceDto deviceDto);

    DeviceDto toDeviceDto(Device device);

    default List<Device> toDeviceModel(@NonNull List<DeviceDto> devices) {
        return devices.stream()
                .map(this::toDeviceModel)
                .toList();
    }

    default List<DeviceDto> toDeviceDto(@NonNull List<Device> devices) {
        return devices.stream()
                .map(this::toDeviceDto)
                .toList();
    }
}
