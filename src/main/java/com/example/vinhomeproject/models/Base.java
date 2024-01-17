package com.example.vinhomeproject.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
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
    @LastModifiedDate
    private Date modifiedDate;
    @Column
    @CreatedDate
    private Date createDate;
}
