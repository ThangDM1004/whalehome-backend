package com.example.vinhomeproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class PostImage extends Base{
    private String image_url;
    private String image_alt;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
