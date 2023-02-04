package com.present.order.infrastructure;

import com.present.order.domain.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationExecutor implements NotificationService {

    @Override
    public void sendEmail(String email, String title, String description) {
        log.info("sendEmail: {}, {}, {}", email, title, description);
    }

    @Override
    public void sendKakao(String phoneNo, String description) {
        log.info("sendKakao: {}, {}", phoneNo, description);
    }

    @Override
    public void sendSms(String phoneNo, String description) {
        log.info("sendSms: {}, {}", phoneNo, description);
    }
}
