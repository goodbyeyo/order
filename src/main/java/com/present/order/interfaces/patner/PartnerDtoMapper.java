package com.present.order.interfaces.patner;

import com.present.order.domain.partner.PartnerCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PartnerDtoMapper {

    PartnerCommand of(PartnerDto.RegisterRequest request);

}
