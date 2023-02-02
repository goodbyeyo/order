package com.present.order.domain.partner;

import com.present.order.common.util.TokenGenerator;
import com.present.order.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "partners")
public class Partner extends AbstractEntity {

    public static final String PREFIX_PARTNER = "ptn_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partnerToken;
    private String partnerName;
    private String businessNo;
    private String email;

    // EnumType.ORDINAL 은 순서를 기준으로 저장하기 때문에, Enum의 순서가 변경되면 DB에 저장된 값도 변경됨
    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public Partner(String partnerName, String businessNo, String email) {
        Assert.hasText(partnerName, "partnerName must not be empty");
        Assert.hasText(businessNo, "businessNo must not be empty");
        Assert.hasText(email, "email must not be empty");

        this.partnerToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER);
        this.partnerName = partnerName;
        this.businessNo = businessNo;
        this.email = email;
        this.status = Status.ENABLE;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("활성화"), DISABLE("비활성화");
        private final String description;
    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }
}
