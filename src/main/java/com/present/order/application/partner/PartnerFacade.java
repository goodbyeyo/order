package com.present.order.application.partner;

import com.present.order.domain.notification.NotificationService;
import com.present.order.domain.partner.PartnerCommand;
import com.present.order.domain.partner.PartnerInfo;
import com.present.order.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {

    private final PartnerService partnerService;
    private final NotificationService notificationService;

    public PartnerInfo registerPartner(PartnerCommand command) {
         var partnerInfo = partnerService.registerPartner(command);
         notificationService.sendEmail(partnerInfo.getEmail(), "title", "description");
         return partnerInfo;
    }
}
