package com.mogila.api.mapper;

import com.mogila.api.dto.VerificationDto;
import com.mogila.api.model.Verification;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-10T22:18:36+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class VerificationMapperImpl implements VerificationMapper {

    @Override
    public Verification toVerificationModel(VerificationDto verificationDto) {
        if ( verificationDto == null ) {
            return null;
        }

        Verification verification = new Verification();

        verification.setDateOfVerification( verificationDto.getDateOfVerification() );
        verification.setVerificationPlace( verificationDto.getVerificationPlace() );
        verification.setTypeOfVerification( verificationDto.getTypeOfVerification() );
        verification.setConclusion( verificationDto.getConclusion() );

        return verification;
    }

    @Override
    public VerificationDto toVerificationDto(Verification verification) {
        if ( verification == null ) {
            return null;
        }

        VerificationDto verificationDto = new VerificationDto();

        verificationDto.setDateOfVerification( verification.getDateOfVerification() );
        verificationDto.setVerificationPlace( verification.getVerificationPlace() );
        verificationDto.setTypeOfVerification( verification.getTypeOfVerification() );
        verificationDto.setConclusion( verification.getConclusion() );

        return verificationDto;
    }
}
