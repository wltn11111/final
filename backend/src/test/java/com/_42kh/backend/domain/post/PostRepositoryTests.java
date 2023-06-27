package com._42kh.backend.domain.post;

import com._42kh.backend.config.JpaConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(JpaConfig.class)
class PostRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PostRepository postRepository;

    @AfterEach
    public void teardown() {
        entityManager.clear();
    }

    @DisplayName("조회 실패")
    @ParameterizedTest
    @MethodSource
    public void whenFindById_thenExceptionIsThrown(Long id) {
        assertThatThrownBy(() -> {
            postRepository.findById(id).orElseThrow();
        }).isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> whenFindById_thenExceptionIsThrown() {
        return Stream.of(
            Arguments.of(0L)
        );
    }

    @DisplayName("생성 실패")
    @ParameterizedTest
    @MethodSource
    public void whenSaveWithInvalidProperties_thenExceptionIsThrown(
        String title,
        String contents
    ) {
        Post post = Post.builder()
            .title(title)
            .contents(contents)
            .build();

        assertThatThrownBy(() -> {
            postRepository.saveAndFlush(post);
        }).isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> whenSaveWithInvalidProperties_thenExceptionIsThrown() {
        return Stream.of(
            Arguments.of(null, "contents"),
            Arguments.of("title", null),
            Arguments.of(null, null)
        );
    }

    @DisplayName("수정 실패")
    @ParameterizedTest
    @MethodSource
    public void givenPost_whenUpdateWithInvalidProperties_thenExceptionIsThrown(
        Post post,
        String titleToUpdate,
        String contentsToUpdate
    ) {
        postRepository.saveAndFlush(post);

        assertThatThrownBy(() -> {
            post.update(titleToUpdate, contentsToUpdate);
            postRepository.flush();
        }).isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> givenPost_whenUpdateWithInvalidProperties_thenExceptionIsThrown() {
        return Stream.of(
            Arguments.of(
                Post.builder()
                    .title("title")
                    .contents("contents")
                    .build(),
                null,
                "updated contents"
            ),
            Arguments.of(
                Post.builder()
                    .title("title")
                    .contents("contents")
                    .build(),
                "updated title",
                null
            ),
            Arguments.of(
                Post.builder()
                    .title("title")
                    .contents("contents")
                    .build(),
                null,
                null
            )
        );
    }

    @DisplayName("생성 성공")
    @ParameterizedTest
    @MethodSource
    public void whenSaveWithValidProperties_thenCorrect(
        String title,
        String contents
    ) {
        Post post = Post.builder()
            .title(title)
            .contents(contents)
            .build();
        LocalDateTime now = LocalDateTime.now();

        postRepository.saveAndFlush(post);

        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContents()).isEqualTo(contents);
        assertThat(post.getCreatedDate()).isAfterOrEqualTo(now);
    }

    private static Stream<Arguments> whenSaveWithValidProperties_thenCorrect() {
        return Stream.of(
            Arguments.of("title", "contents")
        );
    }

    @DisplayName("수정 성공")
    @ParameterizedTest
    @MethodSource
    public void givenPost_whenUpdateWithValidProperties_thenCorrect(
        Post post,
        String titleToUpdate,
        String contentsToUpdate
    ) {
        postRepository.saveAndFlush(post);

        LocalDateTime now = LocalDateTime.now();
        post.update(titleToUpdate, contentsToUpdate);
        postRepository.flush();

        assertThat(post.getTitle()).isEqualTo(titleToUpdate);
        assertThat(post.getContents()).isEqualTo(contentsToUpdate);
        assertThat(post.getModifiedDate()).isAfterOrEqualTo(now);
    }

    private static Stream<Arguments> givenPost_whenUpdateWithValidProperties_thenCorrect() {
        return Stream.of(
            Arguments.of(
                Post.builder()
                    .title("title")
                    .contents("contents")
                    .build(),
                "updated title",
                "updated contents"
            )
        );
    }

    @DisplayName("삭제 성공")
    @ParameterizedTest
    @MethodSource
    public void givenPosts_whenDeleteById_thenCorrect(List<Post> posts) {
        posts.forEach(postRepository::saveAndFlush);
        Post post = posts.get(0);

        postRepository.delete(post);

        Optional<Post> optionalPost = postRepository.findById(post.getId());
        assertThat(optionalPost.isPresent()).isFalse();
    }

    private static Stream<Arguments> givenPosts_whenDeleteById_thenCorrect() {
        return Stream.of(
            Arguments.of(
                List.of(
                    Post.builder()
                        .title("title1")
                        .contents("contents1")
                        .build(),
                    Post.builder()
                        .title("title2")
                        .contents("contents2")
                        .build()
                )
            )
        );
    }
}