package com.mogila.api.mapper;

import com.mogila.api.dto.VerificationDto;
import com.mogila.api.model.Verification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VerificationMapper {
    @Mapping(target = "id", ignore = true)
    Verification toVerificationModel(VerificationDto verificationDto);

    VerificationDto toVerificationDto(Verification verification);
}
