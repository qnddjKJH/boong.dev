package dev.boong.blog.domain.member;

import dev.boong.blog.config.jpa.auditing.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = {
        @Index(columnList = "name"),
        @Index(columnList = "birth"),
        @Index(columnList = "memberName"),
        @Index(columnList = "email"),
})
@Entity
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false)
    private String birth;
    @Column(nullable = false, length = 20)
    private String memberName;
    @Column(nullable = false, length = 30)
    private String memberPassword;
    @Column(length = 50)
    private String email;

    private Member(String name, String birth, String memberName, String memberPassword, String email) {
        this.name = name;
        this.birth = birth;
        this.memberName = memberName;
        this.memberPassword = memberPassword;
        this.email = email;
    }

    public static Member of(String name, String birth, String memberName, String memberPassword, String email) {
        return new Member(name, birth, memberName, memberPassword, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member member)) return false;
        return id != null && id.equals(member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
