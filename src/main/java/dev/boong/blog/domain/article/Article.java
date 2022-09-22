package dev.boong.blog.domain.article;

import dev.boong.blog.config.jpa.auditing.BaseEntity;
import dev.boong.blog.domain.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "content"),
        @Index(columnList = "member"),
})
@Entity
public class Article extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 100)
    private String content;
    @OneToMany(mappedBy = "")
    private Member member;
}
