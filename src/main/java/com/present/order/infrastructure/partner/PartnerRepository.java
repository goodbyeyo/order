package com.present.order.infrastructure.partner;

import com.present.order.domain.partner.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
    Optional<Partner> findByPartnerToken(String partnerToken);
}
