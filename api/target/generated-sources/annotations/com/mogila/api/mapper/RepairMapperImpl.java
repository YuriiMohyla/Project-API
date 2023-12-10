package com.mogila.api.mapper;

import com.mogila.api.dto.RepairDto;
import com.mogila.api.model.Repair;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-10T22:18:35+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class RepairMapperImpl implements RepairMapper {

    @Override
    public Repair toRepairModel(RepairDto repairDto) {
        if ( repairDto == null ) {
            return null;
        }

        Repair repair = new Repair();

        repair.setDateOfRepair( repairDto.getDateOfRepair() );
        repair.setCharacteristic( repairDto.getCharacteristic() );

        return repair;
    }

    @Override
    public RepairDto toRepairDto(Repair repair) {
        if ( repair == null ) {
            return null;
        }

        RepairDto repairDto = new RepairDto();

        repairDto.setDateOfRepair( repair.getDateOfRepair() );
        repairDto.setCharacteristic( repair.getCharacteristic() );

        return repairDto;
    }
}
