package com.soluinoon.hasearch.domain;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    private String name;
    private String password;
    private String nickname;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Like> likes = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Report> reports = new ArrayList<>();
}
