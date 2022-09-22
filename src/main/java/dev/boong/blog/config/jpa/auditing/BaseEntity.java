package dev.boong.blog.config.jpa.auditing;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity extends BaseTimeEntity {
    @CreatedBy
    @Column(nullable = false, updatable = false, length = 50)
    private String createdBy;
    @Column(nullable = false, length = 50)
    private String modifiedBy;
}
