package org.tomass.twitch.dao;

import java.util.List;
import org.slf4j.Logger;
import org.sqlproc.engine.SqlControl;
import org.sqlproc.engine.SqlEngineFactory;
import org.sqlproc.engine.SqlRowProcessor;
import org.sqlproc.engine.SqlSession;
import org.sqlproc.engine.SqlSessionFactory;
import org.tomass.twitch.model.TwitchUser;

@SuppressWarnings("all")
public class TwitchUserDao {
  protected final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
  
  public TwitchUserDao() {
  }
  
  public TwitchUserDao(final SqlEngineFactory sqlEngineFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
  }
  
  public TwitchUserDao(final SqlEngineFactory sqlEngineFactory, final SqlSessionFactory sqlSessionFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  protected SqlEngineFactory sqlEngineFactory;
  
  protected SqlSessionFactory sqlSessionFactory;
  
  public TwitchUser insert(final SqlSession sqlSession, final TwitchUser twitchUser, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert twitchUser: " + twitchUser + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "INSERT_TWITCH_USER";
    org.sqlproc.engine.SqlCrudEngine sqlInsertTwitchUser = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlInsertTwitchUser.insert(sqlSession, twitchUser, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert twitchUser result: " + count + " " + twitchUser);
    }
    return (count > 0) ? twitchUser : null;
  }
  
  public TwitchUser insert(final TwitchUser twitchUser, SqlControl sqlControl) {
    return insert(sqlSessionFactory.getSqlSession(), twitchUser, sqlControl);
  }
  
  public TwitchUser insert(final SqlSession sqlSession, final TwitchUser twitchUser) {
    return insert(sqlSession, twitchUser, null);
  }
  
  public TwitchUser insert(final TwitchUser twitchUser) {
    return insert(twitchUser, null);
  }
  
  public TwitchUser get(final SqlSession sqlSession, final TwitchUser twitchUser, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get: " + twitchUser + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "GET_TWITCH_USER";
    org.sqlproc.engine.SqlCrudEngine sqlGetEngineTwitchUser = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    //sqlControl = getMoreResultClasses(twitchUser, sqlControl);
    TwitchUser twitchUserGot = sqlGetEngineTwitchUser.get(sqlSession, TwitchUser.class, twitchUser, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get twitchUser result: " + twitchUserGot);
    }
    return twitchUserGot;
  }
  
  public TwitchUser get(final TwitchUser twitchUser, SqlControl sqlControl) {
    return get(sqlSessionFactory.getSqlSession(), twitchUser, sqlControl);
  }
  
  public TwitchUser get(final SqlSession sqlSession, final TwitchUser twitchUser) {
    return get(sqlSession, twitchUser, null);
  }
  
  public TwitchUser get(final TwitchUser twitchUser) {
    return get(twitchUser, null);
  }
  
  public int update(final SqlSession sqlSession, final TwitchUser twitchUser, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update twitchUser: " + twitchUser + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "UPDATE_TWITCH_USER";
    org.sqlproc.engine.SqlCrudEngine sqlUpdateEngineTwitchUser = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlUpdateEngineTwitchUser.update(sqlSession, twitchUser, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update twitchUser result count: " + count);
    }
    return count;
  }
  
  public int update(final TwitchUser twitchUser, SqlControl sqlControl) {
    return update(sqlSessionFactory.getSqlSession(), twitchUser, sqlControl);
  }
  
  public int update(final SqlSession sqlSession, final TwitchUser twitchUser) {
    return update(sqlSession, twitchUser, null);
  }
  
  public int update(final TwitchUser twitchUser) {
    return update(twitchUser, null);
  }
  
  public int delete(final SqlSession sqlSession, final TwitchUser twitchUser, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete twitchUser: " + twitchUser + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "DELETE_TWITCH_USER";
    org.sqlproc.engine.SqlCrudEngine sqlDeleteEngineTwitchUser = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlDeleteEngineTwitchUser.delete(sqlSession, twitchUser, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete twitchUser result count: " + count);
    }
    return count;
  }
  
  public int delete(final TwitchUser twitchUser, SqlControl sqlControl) {
    return delete(sqlSessionFactory.getSqlSession(), twitchUser, sqlControl);
  }
  
  public int delete(final SqlSession sqlSession, final TwitchUser twitchUser) {
    return delete(sqlSession, twitchUser, null);
  }
  
  public int delete(final TwitchUser twitchUser) {
    return delete(twitchUser, null);
  }
  
  public List<TwitchUser> list(final SqlSession sqlSession, final TwitchUser twitchUser, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list twitchUser: " + twitchUser + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_TWITCH_USER";
    org.sqlproc.engine.SqlQueryEngine sqlEngineTwitchUser = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(twitchUser, sqlControl);
    List<TwitchUser> twitchUserList = sqlEngineTwitchUser.query(sqlSession, TwitchUser.class, twitchUser, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list twitchUser size: " + ((twitchUserList != null) ? twitchUserList.size() : "null"));
    }
    return twitchUserList;
  }
  
  public List<TwitchUser> list(final TwitchUser twitchUser, SqlControl sqlControl) {
    return list(sqlSessionFactory.getSqlSession(), twitchUser, sqlControl);
  }
  
  public List<TwitchUser> list(final SqlSession sqlSession, final TwitchUser twitchUser) {
    return list(sqlSession, twitchUser, null);
  }
  
  public List<TwitchUser> list(final TwitchUser twitchUser) {
    return list(twitchUser, null);
  }
  
  public int query(final SqlSession sqlSession, final TwitchUser twitchUser, SqlControl sqlControl, final SqlRowProcessor<TwitchUser> sqlRowProcessor) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query twitchUser: " + twitchUser + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_TWITCH_USER";
    org.sqlproc.engine.SqlQueryEngine sqlEngineTwitchUser = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(twitchUser, sqlControl);
    int rownums = sqlEngineTwitchUser.query(sqlSession, TwitchUser.class, twitchUser, sqlControl, sqlRowProcessor);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query twitchUser size: " + rownums);
    }
    return rownums;
  }
  
  public int query(final TwitchUser twitchUser, SqlControl sqlControl, final SqlRowProcessor<TwitchUser> sqlRowProcessor) {
    return query(sqlSessionFactory.getSqlSession(), twitchUser, sqlControl, sqlRowProcessor);
  }
  
  public int query(final SqlSession sqlSession, final TwitchUser twitchUser, final SqlRowProcessor<TwitchUser> sqlRowProcessor) {
    return query(sqlSession, twitchUser, null, sqlRowProcessor);
  }
  
  public int query(final TwitchUser twitchUser, final SqlRowProcessor<TwitchUser> sqlRowProcessor) {
    return query(twitchUser, null, sqlRowProcessor);
  }
  
  public int count(final SqlSession sqlSession, final TwitchUser twitchUser, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("count twitchUser: " + twitchUser + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_TWITCH_USER";
    org.sqlproc.engine.SqlQueryEngine sqlEngineTwitchUser = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(twitchUser, sqlControl);
    int count = sqlEngineTwitchUser.queryCount(sqlSession, twitchUser, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("count: " + count);
    }
    return count;
  }
  
  public int count(final TwitchUser twitchUser, SqlControl sqlControl) {
    return count(sqlSessionFactory.getSqlSession(), twitchUser, sqlControl);
  }
  
  public int count(final SqlSession sqlSession, final TwitchUser twitchUser) {
    return count(sqlSession, twitchUser, null);
  }
  
  public int count(final TwitchUser twitchUser) {
    return count(twitchUser, null);
  }
}
