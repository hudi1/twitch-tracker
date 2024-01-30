package org.tomass.twitch.twitchtracker.dao;

import java.util.List;
import org.slf4j.Logger;
import org.sqlproc.engine.SqlControl;
import org.sqlproc.engine.SqlEngineFactory;
import org.sqlproc.engine.SqlRowProcessor;
import org.sqlproc.engine.SqlSession;
import org.sqlproc.engine.SqlSessionFactory;
import org.tomass.twitch.twitchtracker.model.TwitchStreamData;

@SuppressWarnings("all")
public class TwitchStreamDataDao {
  protected final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
  
  public TwitchStreamDataDao() {
  }
  
  public TwitchStreamDataDao(final SqlEngineFactory sqlEngineFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
  }
  
  public TwitchStreamDataDao(final SqlEngineFactory sqlEngineFactory, final SqlSessionFactory sqlSessionFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  protected SqlEngineFactory sqlEngineFactory;
  
  protected SqlSessionFactory sqlSessionFactory;
  
  public TwitchStreamData insert(final SqlSession sqlSession, final TwitchStreamData twitchStreamData, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert twitchStreamData: " + twitchStreamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "INSERT_TWITCH_STREAM_DATA";
    org.sqlproc.engine.SqlCrudEngine sqlInsertTwitchStreamData = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlInsertTwitchStreamData.insert(sqlSession, twitchStreamData, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert twitchStreamData result: " + count + " " + twitchStreamData);
    }
    return (count > 0) ? twitchStreamData : null;
  }
  
  public TwitchStreamData insert(final TwitchStreamData twitchStreamData, SqlControl sqlControl) {
    return insert(sqlSessionFactory.getSqlSession(), twitchStreamData, sqlControl);
  }
  
  public TwitchStreamData insert(final SqlSession sqlSession, final TwitchStreamData twitchStreamData) {
    return insert(sqlSession, twitchStreamData, null);
  }
  
  public TwitchStreamData insert(final TwitchStreamData twitchStreamData) {
    return insert(twitchStreamData, null);
  }
  
  public TwitchStreamData get(final SqlSession sqlSession, final TwitchStreamData twitchStreamData, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get: " + twitchStreamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "GET_TWITCH_STREAM_DATA";
    org.sqlproc.engine.SqlCrudEngine sqlGetEngineTwitchStreamData = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    //sqlControl = getMoreResultClasses(twitchStreamData, sqlControl);
    TwitchStreamData twitchStreamDataGot = sqlGetEngineTwitchStreamData.get(sqlSession, TwitchStreamData.class, twitchStreamData, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get twitchStreamData result: " + twitchStreamDataGot);
    }
    return twitchStreamDataGot;
  }
  
  public TwitchStreamData get(final TwitchStreamData twitchStreamData, SqlControl sqlControl) {
    return get(sqlSessionFactory.getSqlSession(), twitchStreamData, sqlControl);
  }
  
  public TwitchStreamData get(final SqlSession sqlSession, final TwitchStreamData twitchStreamData) {
    return get(sqlSession, twitchStreamData, null);
  }
  
  public TwitchStreamData get(final TwitchStreamData twitchStreamData) {
    return get(twitchStreamData, null);
  }
  
  public int update(final SqlSession sqlSession, final TwitchStreamData twitchStreamData, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update twitchStreamData: " + twitchStreamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "UPDATE_TWITCH_STREAM_DATA";
    org.sqlproc.engine.SqlCrudEngine sqlUpdateEngineTwitchStreamData = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlUpdateEngineTwitchStreamData.update(sqlSession, twitchStreamData, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update twitchStreamData result count: " + count);
    }
    return count;
  }
  
  public int update(final TwitchStreamData twitchStreamData, SqlControl sqlControl) {
    return update(sqlSessionFactory.getSqlSession(), twitchStreamData, sqlControl);
  }
  
  public int update(final SqlSession sqlSession, final TwitchStreamData twitchStreamData) {
    return update(sqlSession, twitchStreamData, null);
  }
  
  public int update(final TwitchStreamData twitchStreamData) {
    return update(twitchStreamData, null);
  }
  
  public int delete(final SqlSession sqlSession, final TwitchStreamData twitchStreamData, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete twitchStreamData: " + twitchStreamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "DELETE_TWITCH_STREAM_DATA";
    org.sqlproc.engine.SqlCrudEngine sqlDeleteEngineTwitchStreamData = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlDeleteEngineTwitchStreamData.delete(sqlSession, twitchStreamData, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete twitchStreamData result count: " + count);
    }
    return count;
  }
  
  public int delete(final TwitchStreamData twitchStreamData, SqlControl sqlControl) {
    return delete(sqlSessionFactory.getSqlSession(), twitchStreamData, sqlControl);
  }
  
  public int delete(final SqlSession sqlSession, final TwitchStreamData twitchStreamData) {
    return delete(sqlSession, twitchStreamData, null);
  }
  
  public int delete(final TwitchStreamData twitchStreamData) {
    return delete(twitchStreamData, null);
  }
  
  public List<TwitchStreamData> list(final SqlSession sqlSession, final TwitchStreamData twitchStreamData, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list twitchStreamData: " + twitchStreamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_TWITCH_STREAM_DATA";
    org.sqlproc.engine.SqlQueryEngine sqlEngineTwitchStreamData = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(twitchStreamData, sqlControl);
    List<TwitchStreamData> twitchStreamDataList = sqlEngineTwitchStreamData.query(sqlSession, TwitchStreamData.class, twitchStreamData, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list twitchStreamData size: " + ((twitchStreamDataList != null) ? twitchStreamDataList.size() : "null"));
    }
    return twitchStreamDataList;
  }
  
  public List<TwitchStreamData> list(final TwitchStreamData twitchStreamData, SqlControl sqlControl) {
    return list(sqlSessionFactory.getSqlSession(), twitchStreamData, sqlControl);
  }
  
  public List<TwitchStreamData> list(final SqlSession sqlSession, final TwitchStreamData twitchStreamData) {
    return list(sqlSession, twitchStreamData, null);
  }
  
  public List<TwitchStreamData> list(final TwitchStreamData twitchStreamData) {
    return list(twitchStreamData, null);
  }
  
  public int query(final SqlSession sqlSession, final TwitchStreamData twitchStreamData, SqlControl sqlControl, final SqlRowProcessor<TwitchStreamData> sqlRowProcessor) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query twitchStreamData: " + twitchStreamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_TWITCH_STREAM_DATA";
    org.sqlproc.engine.SqlQueryEngine sqlEngineTwitchStreamData = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(twitchStreamData, sqlControl);
    int rownums = sqlEngineTwitchStreamData.query(sqlSession, TwitchStreamData.class, twitchStreamData, sqlControl, sqlRowProcessor);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query twitchStreamData size: " + rownums);
    }
    return rownums;
  }
  
  public int query(final TwitchStreamData twitchStreamData, SqlControl sqlControl, final SqlRowProcessor<TwitchStreamData> sqlRowProcessor) {
    return query(sqlSessionFactory.getSqlSession(), twitchStreamData, sqlControl, sqlRowProcessor);
  }
  
  public int query(final SqlSession sqlSession, final TwitchStreamData twitchStreamData, final SqlRowProcessor<TwitchStreamData> sqlRowProcessor) {
    return query(sqlSession, twitchStreamData, null, sqlRowProcessor);
  }
  
  public int query(final TwitchStreamData twitchStreamData, final SqlRowProcessor<TwitchStreamData> sqlRowProcessor) {
    return query(twitchStreamData, null, sqlRowProcessor);
  }
  
  public int count(final SqlSession sqlSession, final TwitchStreamData twitchStreamData, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("count twitchStreamData: " + twitchStreamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_TWITCH_STREAM_DATA";
    org.sqlproc.engine.SqlQueryEngine sqlEngineTwitchStreamData = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(twitchStreamData, sqlControl);
    int count = sqlEngineTwitchStreamData.queryCount(sqlSession, twitchStreamData, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("count: " + count);
    }
    return count;
  }
  
  public int count(final TwitchStreamData twitchStreamData, SqlControl sqlControl) {
    return count(sqlSessionFactory.getSqlSession(), twitchStreamData, sqlControl);
  }
  
  public int count(final SqlSession sqlSession, final TwitchStreamData twitchStreamData) {
    return count(sqlSession, twitchStreamData, null);
  }
  
  public int count(final TwitchStreamData twitchStreamData) {
    return count(twitchStreamData, null);
  }
}
