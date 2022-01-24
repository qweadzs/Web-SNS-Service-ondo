package com.nextlevel.ondo.domain;

import com.nextlevel.ondo.util.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class User extends BaseTimeEntity {
    public enum Role { user, admin;}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false, columnDefinition = "number(10) default 36")
    private int ondo;
    @Column(columnDefinition = "varchar(255) default 'ㅋㅋ'") // 경로는 추후 설정
    private String image;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10) default 'user'")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<ChallengeParticipate> challengeParticipate = new ArrayList<>();

}
