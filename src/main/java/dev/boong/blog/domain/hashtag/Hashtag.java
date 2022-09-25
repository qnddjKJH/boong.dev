package dev.boong.blog.domain.hashtag;

import dev.boong.blog.domain.article.ArticleHashtag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {
        @Index(columnList = "hashtag")
})
@Entity
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hashtag_id")
    private Long id;
    @Column(nullable = false, length = 10)
    private String hashtag;

    @OneToMany(mappedBy = "hashtag")
    private List<ArticleHashtag> articleHashtags = new ArrayList<>();

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private Hashtag(String hashtag) {
        this.hashtag = hashtag;
        this.createdAt = LocalDateTime.now();
    }

    public static Hashtag of(String hashtag) {
        return new Hashtag(hashtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hashtag hashtag)) return false;
        return id != null && id.equals(hashtag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
