package com.mogila.api.mapper;

import com.mogila.api.dto.DeviceDto;
import com.mogila.api.dto.RepairDto;
import com.mogila.api.dto.VerificationDto;
import com.mogila.api.model.Device;
import com.mogila.api.model.Repair;
import com.mogila.api.model.Verification;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-10T16:16:15+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class DeviceMapperImpl implements DeviceMapper {

    @Autowired
    private RepairMapper repairMapper;
    @Autowired
    private VerificationMapper verificationMapper;

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
        device.setVerificationPeriod( deviceDto.getVerificationPeriod() );
        device.setNote( deviceDto.getNote() );
        device.setVerifications( verificationDtoListToVerificationList( deviceDto.getVerifications() ) );
        device.setRepairs( repairDtoListToRepairList( deviceDto.getRepairs() ) );

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
        deviceDto.setVerificationPeriod( device.getVerificationPeriod() );
        deviceDto.setNote( device.getNote() );
        deviceDto.setVerifications( verificationListToVerificationDtoList( device.getVerifications() ) );
        deviceDto.setRepairs( repairListToRepairDtoList( device.getRepairs() ) );

        return deviceDto;
    }

    protected List<Verification> verificationDtoListToVerificationList(List<VerificationDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Verification> list1 = new ArrayList<Verification>( list.size() );
        for ( VerificationDto verificationDto : list ) {
            list1.add( verificationMapper.toVerificationModel( verificationDto ) );
        }

        return list1;
    }

    protected List<Repair> repairDtoListToRepairList(List<RepairDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Repair> list1 = new ArrayList<Repair>( list.size() );
        for ( RepairDto repairDto : list ) {
            list1.add( repairMapper.toRepairModel( repairDto ) );
        }

        return list1;
    }

    protected List<VerificationDto> verificationListToVerificationDtoList(List<Verification> list) {
        if ( list == null ) {
            return null;
        }

        List<VerificationDto> list1 = new ArrayList<VerificationDto>( list.size() );
        for ( Verification verification : list ) {
            list1.add( verificationMapper.toVerificationDto( verification ) );
        }

        return list1;
    }

    protected List<RepairDto> repairListToRepairDtoList(List<Repair> list) {
        if ( list == null ) {
            return null;
        }

        List<RepairDto> list1 = new ArrayList<RepairDto>( list.size() );
        for ( Repair repair : list ) {
            list1.add( repairMapper.toRepairDto( repair ) );
        }

        return list1;
    }
}
