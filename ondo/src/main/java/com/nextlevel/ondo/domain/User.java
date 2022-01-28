package com.nextlevel.ondo.domain;

import com.nextlevel.ondo.util.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false, columnDefinition = "int(20) default 36")
    private int ondo;
    @Column(columnDefinition = "varchar(255) default 'null'") // 경로는 추후 설정
    private String image;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10) default 'user'")
    private RoleType role;


    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<ChallengeParticipate> challengeParticipate = new ArrayList<>();


    @Builder
    public User(String email, String password, String username, int ondo, String image, RoleType role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.ondo = ondo;
        this.image = image;
        this.role = role;
    }

}
