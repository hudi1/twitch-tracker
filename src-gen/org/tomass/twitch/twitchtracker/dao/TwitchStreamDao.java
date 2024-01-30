package org.tomass.twitch.twitchtracker.dao;

import java.util.List;
import org.slf4j.Logger;
import org.sqlproc.engine.SqlControl;
import org.sqlproc.engine.SqlEngineFactory;
import org.sqlproc.engine.SqlRowProcessor;
import org.sqlproc.engine.SqlSession;
import org.sqlproc.engine.SqlSessionFactory;
import org.tomass.twitch.twitchtracker.model.TwitchStream;

@SuppressWarnings("all")
public class TwitchStreamDao {
  protected final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
  
  public TwitchStreamDao() {
  }
  
  public TwitchStreamDao(final SqlEngineFactory sqlEngineFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
  }
  
  public TwitchStreamDao(final SqlEngineFactory sqlEngineFactory, final SqlSessionFactory sqlSessionFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  protected SqlEngineFactory sqlEngineFactory;
  
  protected SqlSessionFactory sqlSessionFactory;
  
  public TwitchStream insert(final SqlSession sqlSession, final TwitchStream twitchStream, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert twitchStream: " + twitchStream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "INSERT_TWITCH_STREAM";
    org.sqlproc.engine.SqlCrudEngine sqlInsertTwitchStream = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlInsertTwitchStream.insert(sqlSession, twitchStream, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert twitchStream result: " + count + " " + twitchStream);
    }
    return (count > 0) ? twitchStream : null;
  }
  
  public TwitchStream insert(final TwitchStream twitchStream, SqlControl sqlControl) {
    return insert(sqlSessionFactory.getSqlSession(), twitchStream, sqlControl);
  }
  
  public TwitchStream insert(final SqlSession sqlSession, final TwitchStream twitchStream) {
    return insert(sqlSession, twitchStream, null);
  }
  
  public TwitchStream insert(final TwitchStream twitchStream) {
    return insert(twitchStream, null);
  }
  
  public TwitchStream get(final SqlSession sqlSession, final TwitchStream twitchStream, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get: " + twitchStream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "GET_TWITCH_STREAM";
    org.sqlproc.engine.SqlCrudEngine sqlGetEngineTwitchStream = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    //sqlControl = getMoreResultClasses(twitchStream, sqlControl);
    TwitchStream twitchStreamGot = sqlGetEngineTwitchStream.get(sqlSession, TwitchStream.class, twitchStream, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get twitchStream result: " + twitchStreamGot);
    }
    return twitchStreamGot;
  }
  
  public TwitchStream get(final TwitchStream twitchStream, SqlControl sqlControl) {
    return get(sqlSessionFactory.getSqlSession(), twitchStream, sqlControl);
  }
  
  public TwitchStream get(final SqlSession sqlSession, final TwitchStream twitchStream) {
    return get(sqlSession, twitchStream, null);
  }
  
  public TwitchStream get(final TwitchStream twitchStream) {
    return get(twitchStream, null);
  }
  
  public int update(final SqlSession sqlSession, final TwitchStream twitchStream, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update twitchStream: " + twitchStream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "UPDATE_TWITCH_STREAM";
    org.sqlproc.engine.SqlCrudEngine sqlUpdateEngineTwitchStream = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlUpdateEngineTwitchStream.update(sqlSession, twitchStream, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update twitchStream result count: " + count);
    }
    return count;
  }
  
  public int update(final TwitchStream twitchStream, SqlControl sqlControl) {
    return update(sqlSessionFactory.getSqlSession(), twitchStream, sqlControl);
  }
  
  public int update(final SqlSession sqlSession, final TwitchStream twitchStream) {
    return update(sqlSession, twitchStream, null);
  }
  
  public int update(final TwitchStream twitchStream) {
    return update(twitchStream, null);
  }
  
  public int delete(final SqlSession sqlSession, final TwitchStream twitchStream, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete twitchStream: " + twitchStream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "DELETE_TWITCH_STREAM";
    org.sqlproc.engine.SqlCrudEngine sqlDeleteEngineTwitchStream = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlDeleteEngineTwitchStream.delete(sqlSession, twitchStream, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete twitchStream result count: " + count);
    }
    return count;
  }
  
  public int delete(final TwitchStream twitchStream, SqlControl sqlControl) {
    return delete(sqlSessionFactory.getSqlSession(), twitchStream, sqlControl);
  }
  
  public int delete(final SqlSession sqlSession, final TwitchStream twitchStream) {
    return delete(sqlSession, twitchStream, null);
  }
  
  public int delete(final TwitchStream twitchStream) {
    return delete(twitchStream, null);
  }
  
  public List<TwitchStream> list(final SqlSession sqlSession, final TwitchStream twitchStream, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list twitchStream: " + twitchStream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_TWITCH_STREAM";
    org.sqlproc.engine.SqlQueryEngine sqlEngineTwitchStream = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(twitchStream, sqlControl);
    List<TwitchStream> twitchStreamList = sqlEngineTwitchStream.query(sqlSession, TwitchStream.class, twitchStream, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list twitchStream size: " + ((twitchStreamList != null) ? twitchStreamList.size() : "null"));
    }
    return twitchStreamList;
  }
  
  public List<TwitchStream> list(final TwitchStream twitchStream, SqlControl sqlControl) {
    return list(sqlSessionFactory.getSqlSession(), twitchStream, sqlControl);
  }
  
  public List<TwitchStream> list(final SqlSession sqlSession, final TwitchStream twitchStream) {
    return list(sqlSession, twitchStream, null);
  }
  
  public List<TwitchStream> list(final TwitchStream twitchStream) {
    return list(twitchStream, null);
  }
  
  public int query(final SqlSession sqlSession, final TwitchStream twitchStream, SqlControl sqlControl, final SqlRowProcessor<TwitchStream> sqlRowProcessor) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query twitchStream: " + twitchStream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_TWITCH_STREAM";
    org.sqlproc.engine.SqlQueryEngine sqlEngineTwitchStream = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(twitchStream, sqlControl);
    int rownums = sqlEngineTwitchStream.query(sqlSession, TwitchStream.class, twitchStream, sqlControl, sqlRowProcessor);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query twitchStream size: " + rownums);
    }
    return rownums;
  }
  
  public int query(final TwitchStream twitchStream, SqlControl sqlControl, final SqlRowProcessor<TwitchStream> sqlRowProcessor) {
    return query(sqlSessionFactory.getSqlSession(), twitchStream, sqlControl, sqlRowProcessor);
  }
  
  public int query(final SqlSession sqlSession, final TwitchStream twitchStream, final SqlRowProcessor<TwitchStream> sqlRowProcessor) {
    return query(sqlSession, twitchStream, null, sqlRowProcessor);
  }
  
  public int query(final TwitchStream twitchStream, final SqlRowProcessor<TwitchStream> sqlRowProcessor) {
    return query(twitchStream, null, sqlRowProcessor);
  }
  
  public int count(final SqlSession sqlSession, final TwitchStream twitchStream, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("count twitchStream: " + twitchStream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_TWITCH_STREAM";
    org.sqlproc.engine.SqlQueryEngine sqlEngineTwitchStream = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(twitchStream, sqlControl);
    int count = sqlEngineTwitchStream.queryCount(sqlSession, twitchStream, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("count: " + count);
    }
    return count;
  }
  
  public int count(final TwitchStream twitchStream, SqlControl sqlControl) {
    return count(sqlSessionFactory.getSqlSession(), twitchStream, sqlControl);
  }
  
  public int count(final SqlSession sqlSession, final TwitchStream twitchStream) {
    return count(sqlSession, twitchStream, null);
  }
  
  public int count(final TwitchStream twitchStream) {
    return count(twitchStream, null);
  }
}
