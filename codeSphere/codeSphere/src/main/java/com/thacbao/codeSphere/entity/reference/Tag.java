package com.thacbao.codeSphere.entity.reference;

import com.thacbao.codeSphere.entity.core.Blog;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
@Getter
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Blog> blogs = new HashSet<>();
}
