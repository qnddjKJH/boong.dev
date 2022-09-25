package dev.boong.blog.domain.article;

import dev.boong.blog.config.jpa.auditing.BaseEntity;
import dev.boong.blog.domain.comment.Comment;
import dev.boong.blog.domain.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "content"),
        @Index(columnList = "member_id"),
})
@Entity
public class Article extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;
    @Column(nullable = false, length = 500)
    private String title;
    @Column(nullable = false, length = 65535)
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "article")
    private List<ArticleHashtag> articleHashtags = new ArrayList<>();

    private Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Article of(String title, String content) {
        return new Article(title, content);
    }
}
