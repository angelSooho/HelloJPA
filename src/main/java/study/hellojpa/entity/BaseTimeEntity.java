package study.hellojpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseTimeEntity {

    @Column(name = "insert_member")
    private String createdBy;
    private LocalDateTime createdDate;

    @Column(name = "update_member")
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
