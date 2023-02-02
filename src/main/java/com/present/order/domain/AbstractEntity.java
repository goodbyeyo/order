package com.present.order.domain;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

    // @CreatedDate     // LocalDateTime 타입으로 저장된다.
    @CreationTimestamp  // ZonedDateTime 타입으로 저장된다.
    private ZonedDateTime createdAt;

    // @LastModifiedDate  // LocalDateTime 타입으로 저장된다.
    @UpdateTimestamp      // ZonedDateTime 타입으로 저장된다.
    private ZonedDateTime updatedAt;

}
