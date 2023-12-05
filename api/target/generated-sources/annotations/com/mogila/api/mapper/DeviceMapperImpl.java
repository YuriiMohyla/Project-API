package com.mogila.api.mapper;

import com.mogila.api.dto.DeviceDto;
import com.mogila.api.model.Device;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-05T22:17:12+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class DeviceMapperImpl implements DeviceMapper {

    @Override
    public Device toDeviceModel(DeviceDto deviceDto) {
        if ( deviceDto == null ) {
            return null;
        }

        Device device = new Device();

        device.setTitle( deviceDto.getTitle() );
        device.setTypeBrand( deviceDto.getTypeBrand() );
        device.setRegistryNumber( deviceDto.getRegistryNumber() );
        device.setInventoryNumber( deviceDto.getInventoryNumber() );
        device.setDateOfLastVerification( deviceDto.getDateOfLastVerification() );
        device.setVerificationPeriod( deviceDto.getVerificationPeriod() );
        device.setDateOfLastRepair( deviceDto.getDateOfLastRepair() );
        device.setNote( deviceDto.getNote() );

        return device;
    }

    @Override
    public DeviceDto toDeviceDto(Device device) {
        if ( device == null ) {
            return null;
        }

        DeviceDto deviceDto = new DeviceDto();

        deviceDto.setTitle( device.getTitle() );
        deviceDto.setTypeBrand( device.getTypeBrand() );
        deviceDto.setRegistryNumber( device.getRegistryNumber() );
        deviceDto.setInventoryNumber( device.getInventoryNumber() );
        deviceDto.setDateOfLastVerification( device.getDateOfLastVerification() );
        deviceDto.setVerificationPeriod( device.getVerificationPeriod() );
        deviceDto.setDateOfLastRepair( device.getDateOfLastRepair() );
        deviceDto.setNote( device.getNote() );

        return deviceDto;
    }
}
