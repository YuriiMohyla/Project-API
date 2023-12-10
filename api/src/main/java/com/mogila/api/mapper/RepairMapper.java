package com.mogila.api.mapper;

import com.mogila.api.dto.RepairDto;
import com.mogila.api.model.Repair;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RepairMapper {
    Repair toRepairModel(RepairDto repairDto);

    RepairDto toRepairDto(Repair repair);
}
