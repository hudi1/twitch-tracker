package org.tomass.twitch.twitch.tracker.web.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class HikariDatabaseConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${datasource.db.pass}")
    private String pass;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.db")
    public HikariConfig refConfig() {
        return new HikariConfig();
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        HikariConfig config = refConfig();
        String password = getSecret(pass);
        if (password != null)
            config.setPassword(password);
        else
            config.setPassword(pass);

        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    public String getSecret(String name) {
        Path file = Paths.get("/run/secrets", name);
        if (!Files.isReadable(file)) {
            file = Paths.get("/mnt/secrets", name);
            if (!Files.isReadable(file)) {
                return null;
            }
        }
        try (BufferedReader br = Files.newBufferedReader(file)) {
            List<String> list = br.lines().collect(Collectors.toList());
            return (list.isEmpty()) ? null : list.get(0);
        } catch (IOException e) {
            logger.error("Nemohu nacist secrets", e);
        }
        return null;
    }

}