package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@HellobootTest
public class HelloRepositoryTest {
    @Autowired JdbcTemplateTest jdbcTemplateTest;
    @Autowired HelloRepository helloRepository;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void findHelloFailed() {
        Assertions.assertThat(helloRepository.findHello("Sana")).isNull();
    }
}
