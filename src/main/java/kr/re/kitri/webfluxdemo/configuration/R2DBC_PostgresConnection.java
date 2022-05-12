package kr.re.kitri.webfluxdemo.configuration;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories
public class R2DBC_PostgresConnection {

    @Bean
    public PostgresqlConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host("database-1.csebiuu6q8pc.ap-northeast-2.rds.amazonaws.com")
                        .database("postgres")
                        .username("postgres")
                        .password("12345678")
                        .build()
                );
    }
}
