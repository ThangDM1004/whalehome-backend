package com.example.vinhomeproject.models;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @LastModifiedBy
    private String modifiedBy;
    @Column
    @CreatedBy
    private String createBy;
    @Column
    @CreatedBy
    private String deleteBy;
    @Column
    @LastModifiedDate
    private Date modifiedDate;
    @Column
    @CreatedDate
    private LocalDate createDate;
    @Column
    @CreatedDate
    private LocalDate deleteAt;
    @Column
    @CreatedBy
    private boolean status = true;

}
