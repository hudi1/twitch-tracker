package org.tomass.twitch.twitchtracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.sqlproc.engine.SqlFeature;
import org.sqlproc.engine.plugin.SimpleSqlPluginFactory;
import org.sqlproc.engine.spring.SpringEngineFactory;
import org.sqlproc.engine.spring.SpringSessionFactory;
import org.tomass.twitch.twitchtracker.dao.TwitchStreamDao;
import org.tomass.twitch.twitchtracker.dao.TwitchStreamDataDao;
import org.tomass.twitch.twitchtracker.dao.TwitchUserDao;

@Configuration
public class DaoConfig {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public SpringEngineFactory engineFactory() {
        SpringEngineFactory sqlFactory = new SpringEngineFactory();
        sqlFactory.setMetaFilesNames("statements.meta");
        sqlFactory.setFilter(SqlFeature.MYSQL);

        SimpleSqlPluginFactory sqlPluginFactory = SimpleSqlPluginFactory.getInstance();
        sqlFactory.setPluginFactory(sqlPluginFactory);
        return sqlFactory;
    }

    @Bean
    public SpringSessionFactory springSessionFactory() {
        SpringSessionFactory sqlSessionFactory = new SpringSessionFactory(jdbcTemplate);
        return sqlSessionFactory;
    }

    @Bean
    public TwitchUserDao twitchUserDao() {
        return new TwitchUserDao(engineFactory(), springSessionFactory());
    }

    @Bean
    public TwitchStreamDao twitchStreamDao() {
        return new TwitchStreamDao(engineFactory(), springSessionFactory());
    }

    @Bean
    public TwitchStreamDataDao twitchStreamDataDao() {
        return new TwitchStreamDataDao(engineFactory(), springSessionFactory());
    }

}
