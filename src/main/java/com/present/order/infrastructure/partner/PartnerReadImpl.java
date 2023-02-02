package com.present.order.infrastructure.partner;

import com.present.order.common.exception.EntityNotFoundException;
import com.present.order.domain.partner.Partner;
import com.present.order.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerReadImpl implements PartnerReader {

    private final PartnerRepository partnerRepository;

    @Override
    public Partner getPartner(String partnerToken) {
        return partnerRepository.findByPartnerToken(partnerToken)
                .orElseThrow(EntityNotFoundException::new);
    }
}
