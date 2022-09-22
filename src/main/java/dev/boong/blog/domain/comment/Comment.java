package dev.boong.blog.domain.comment;

import dev.boong.blog.config.jpa.auditing.BaseEntity;
import dev.boong.blog.domain.article.Article;
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
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private Article article;
    private Member member;

    public Comment(String comment, Article article, Member member) {
        this.comment = comment;
        this.article = article;
        this.member = member;
    }
}
