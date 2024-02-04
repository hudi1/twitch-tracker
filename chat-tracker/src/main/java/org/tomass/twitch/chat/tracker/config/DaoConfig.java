package org.tomass.twitch.chat.tracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.sqlproc.engine.SqlFeature;
import org.sqlproc.engine.plugin.SimpleSqlPluginFactory;
import org.sqlproc.engine.spring.SpringEngineFactory;
import org.sqlproc.engine.spring.SpringSessionFactory;
import org.tomass.twitch.dao.ChatLogDao;
import org.tomass.twitch.dao.TwitchUserDao;

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
    public TwitchUserDao userDao() {
        return new TwitchUserDao(engineFactory(), springSessionFactory());
    }

    @Bean
    public ChatLogDao chatLogDao() {
        return new ChatLogDao(engineFactory(), springSessionFactory());
    }

}
