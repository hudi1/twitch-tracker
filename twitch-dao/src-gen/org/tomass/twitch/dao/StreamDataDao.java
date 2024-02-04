package org.tomass.twitch.dao;

import java.util.List;
import org.slf4j.Logger;
import org.sqlproc.engine.SqlControl;
import org.sqlproc.engine.SqlEngineFactory;
import org.sqlproc.engine.SqlRowProcessor;
import org.sqlproc.engine.SqlSession;
import org.sqlproc.engine.SqlSessionFactory;
import org.tomass.twitch.model.StreamData;

@SuppressWarnings("all")
public class StreamDataDao {
  protected final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
  
  public StreamDataDao() {
  }
  
  public StreamDataDao(final SqlEngineFactory sqlEngineFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
  }
  
  public StreamDataDao(final SqlEngineFactory sqlEngineFactory, final SqlSessionFactory sqlSessionFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  protected SqlEngineFactory sqlEngineFactory;
  
  protected SqlSessionFactory sqlSessionFactory;
  
  public StreamData insert(final SqlSession sqlSession, final StreamData streamData, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert streamData: " + streamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "INSERT_STREAM_DATA";
    org.sqlproc.engine.SqlCrudEngine sqlInsertStreamData = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlInsertStreamData.insert(sqlSession, streamData, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert streamData result: " + count + " " + streamData);
    }
    return (count > 0) ? streamData : null;
  }
  
  public StreamData insert(final StreamData streamData, SqlControl sqlControl) {
    return insert(sqlSessionFactory.getSqlSession(), streamData, sqlControl);
  }
  
  public StreamData insert(final SqlSession sqlSession, final StreamData streamData) {
    return insert(sqlSession, streamData, null);
  }
  
  public StreamData insert(final StreamData streamData) {
    return insert(streamData, null);
  }
  
  public StreamData get(final SqlSession sqlSession, final StreamData streamData, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get: " + streamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "GET_STREAM_DATA";
    org.sqlproc.engine.SqlCrudEngine sqlGetEngineStreamData = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    //sqlControl = getMoreResultClasses(streamData, sqlControl);
    StreamData streamDataGot = sqlGetEngineStreamData.get(sqlSession, StreamData.class, streamData, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get streamData result: " + streamDataGot);
    }
    return streamDataGot;
  }
  
  public StreamData get(final StreamData streamData, SqlControl sqlControl) {
    return get(sqlSessionFactory.getSqlSession(), streamData, sqlControl);
  }
  
  public StreamData get(final SqlSession sqlSession, final StreamData streamData) {
    return get(sqlSession, streamData, null);
  }
  
  public StreamData get(final StreamData streamData) {
    return get(streamData, null);
  }
  
  public int update(final SqlSession sqlSession, final StreamData streamData, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update streamData: " + streamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "UPDATE_STREAM_DATA";
    org.sqlproc.engine.SqlCrudEngine sqlUpdateEngineStreamData = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlUpdateEngineStreamData.update(sqlSession, streamData, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update streamData result count: " + count);
    }
    return count;
  }
  
  public int update(final StreamData streamData, SqlControl sqlControl) {
    return update(sqlSessionFactory.getSqlSession(), streamData, sqlControl);
  }
  
  public int update(final SqlSession sqlSession, final StreamData streamData) {
    return update(sqlSession, streamData, null);
  }
  
  public int update(final StreamData streamData) {
    return update(streamData, null);
  }
  
  public int delete(final SqlSession sqlSession, final StreamData streamData, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete streamData: " + streamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "DELETE_STREAM_DATA";
    org.sqlproc.engine.SqlCrudEngine sqlDeleteEngineStreamData = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlDeleteEngineStreamData.delete(sqlSession, streamData, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete streamData result count: " + count);
    }
    return count;
  }
  
  public int delete(final StreamData streamData, SqlControl sqlControl) {
    return delete(sqlSessionFactory.getSqlSession(), streamData, sqlControl);
  }
  
  public int delete(final SqlSession sqlSession, final StreamData streamData) {
    return delete(sqlSession, streamData, null);
  }
  
  public int delete(final StreamData streamData) {
    return delete(streamData, null);
  }
  
  public List<StreamData> list(final SqlSession sqlSession, final StreamData streamData, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list streamData: " + streamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_STREAM_DATA";
    org.sqlproc.engine.SqlQueryEngine sqlEngineStreamData = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(streamData, sqlControl);
    List<StreamData> streamDataList = sqlEngineStreamData.query(sqlSession, StreamData.class, streamData, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list streamData size: " + ((streamDataList != null) ? streamDataList.size() : "null"));
    }
    return streamDataList;
  }
  
  public List<StreamData> list(final StreamData streamData, SqlControl sqlControl) {
    return list(sqlSessionFactory.getSqlSession(), streamData, sqlControl);
  }
  
  public List<StreamData> list(final SqlSession sqlSession, final StreamData streamData) {
    return list(sqlSession, streamData, null);
  }
  
  public List<StreamData> list(final StreamData streamData) {
    return list(streamData, null);
  }
  
  public int query(final SqlSession sqlSession, final StreamData streamData, SqlControl sqlControl, final SqlRowProcessor<StreamData> sqlRowProcessor) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query streamData: " + streamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_STREAM_DATA";
    org.sqlproc.engine.SqlQueryEngine sqlEngineStreamData = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(streamData, sqlControl);
    int rownums = sqlEngineStreamData.query(sqlSession, StreamData.class, streamData, sqlControl, sqlRowProcessor);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query streamData size: " + rownums);
    }
    return rownums;
  }
  
  public int query(final StreamData streamData, SqlControl sqlControl, final SqlRowProcessor<StreamData> sqlRowProcessor) {
    return query(sqlSessionFactory.getSqlSession(), streamData, sqlControl, sqlRowProcessor);
  }
  
  public int query(final SqlSession sqlSession, final StreamData streamData, final SqlRowProcessor<StreamData> sqlRowProcessor) {
    return query(sqlSession, streamData, null, sqlRowProcessor);
  }
  
  public int query(final StreamData streamData, final SqlRowProcessor<StreamData> sqlRowProcessor) {
    return query(streamData, null, sqlRowProcessor);
  }
  
  public int count(final SqlSession sqlSession, final StreamData streamData, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("count streamData: " + streamData + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_STREAM_DATA";
    org.sqlproc.engine.SqlQueryEngine sqlEngineStreamData = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(streamData, sqlControl);
    int count = sqlEngineStreamData.queryCount(sqlSession, streamData, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("count: " + count);
    }
    return count;
  }
  
  public int count(final StreamData streamData, SqlControl sqlControl) {
    return count(sqlSessionFactory.getSqlSession(), streamData, sqlControl);
  }
  
  public int count(final SqlSession sqlSession, final StreamData streamData) {
    return count(sqlSession, streamData, null);
  }
  
  public int count(final StreamData streamData) {
    return count(streamData, null);
  }
}
