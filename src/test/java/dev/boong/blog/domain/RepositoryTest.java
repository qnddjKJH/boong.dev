package dev.boong.blog.domain;

import dev.boong.blog.config.jpa.JpaConfig;
import dev.boong.blog.domain.article.Article;
import dev.boong.blog.domain.article.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 및 CRUD 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class RepositoryTest {

    private ArticleRepository articleRepository;

    public RepositoryTest(
            @Autowired ArticleRepository articleRepository
    ) {
        this.articleRepository = articleRepository;
    }

    @DisplayName("insert 테스트")
    @Test
    public void article_create_test() throws Exception {
        // given
        long count = articleRepository.count();
        
        // when
        Article savedArticle = articleRepository.save(Article.of("test", "test content"));

        // then
        assertThat(articleRepository.count()).isNotEqualTo(count);
        assertThat(savedArticle.getTitle()).isEqualTo("test");
        assertThat(savedArticle.getContent()).isEqualTo("test content");
    }

}