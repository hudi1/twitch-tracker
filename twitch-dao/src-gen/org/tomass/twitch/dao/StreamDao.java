package org.tomass.twitch.dao;

import java.util.List;
import org.slf4j.Logger;
import org.sqlproc.engine.SqlControl;
import org.sqlproc.engine.SqlEngineFactory;
import org.sqlproc.engine.SqlRowProcessor;
import org.sqlproc.engine.SqlSession;
import org.sqlproc.engine.SqlSessionFactory;
import org.tomass.twitch.model.Stream;

@SuppressWarnings("all")
public class StreamDao {
  protected final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
  
  public StreamDao() {
  }
  
  public StreamDao(final SqlEngineFactory sqlEngineFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
  }
  
  public StreamDao(final SqlEngineFactory sqlEngineFactory, final SqlSessionFactory sqlSessionFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  protected SqlEngineFactory sqlEngineFactory;
  
  protected SqlSessionFactory sqlSessionFactory;
  
  public Stream insert(final SqlSession sqlSession, final Stream stream, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert stream: " + stream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "INSERT_STREAM";
    org.sqlproc.engine.SqlCrudEngine sqlInsertStream = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlInsertStream.insert(sqlSession, stream, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert stream result: " + count + " " + stream);
    }
    return (count > 0) ? stream : null;
  }
  
  public Stream insert(final Stream stream, SqlControl sqlControl) {
    return insert(sqlSessionFactory.getSqlSession(), stream, sqlControl);
  }
  
  public Stream insert(final SqlSession sqlSession, final Stream stream) {
    return insert(sqlSession, stream, null);
  }
  
  public Stream insert(final Stream stream) {
    return insert(stream, null);
  }
  
  public Stream get(final SqlSession sqlSession, final Stream stream, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get: " + stream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "GET_STREAM";
    org.sqlproc.engine.SqlCrudEngine sqlGetEngineStream = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    //sqlControl = getMoreResultClasses(stream, sqlControl);
    Stream streamGot = sqlGetEngineStream.get(sqlSession, Stream.class, stream, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get stream result: " + streamGot);
    }
    return streamGot;
  }
  
  public Stream get(final Stream stream, SqlControl sqlControl) {
    return get(sqlSessionFactory.getSqlSession(), stream, sqlControl);
  }
  
  public Stream get(final SqlSession sqlSession, final Stream stream) {
    return get(sqlSession, stream, null);
  }
  
  public Stream get(final Stream stream) {
    return get(stream, null);
  }
  
  public int update(final SqlSession sqlSession, final Stream stream, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update stream: " + stream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "UPDATE_STREAM";
    org.sqlproc.engine.SqlCrudEngine sqlUpdateEngineStream = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlUpdateEngineStream.update(sqlSession, stream, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update stream result count: " + count);
    }
    return count;
  }
  
  public int update(final Stream stream, SqlControl sqlControl) {
    return update(sqlSessionFactory.getSqlSession(), stream, sqlControl);
  }
  
  public int update(final SqlSession sqlSession, final Stream stream) {
    return update(sqlSession, stream, null);
  }
  
  public int update(final Stream stream) {
    return update(stream, null);
  }
  
  public int delete(final SqlSession sqlSession, final Stream stream, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete stream: " + stream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "DELETE_STREAM";
    org.sqlproc.engine.SqlCrudEngine sqlDeleteEngineStream = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlDeleteEngineStream.delete(sqlSession, stream, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete stream result count: " + count);
    }
    return count;
  }
  
  public int delete(final Stream stream, SqlControl sqlControl) {
    return delete(sqlSessionFactory.getSqlSession(), stream, sqlControl);
  }
  
  public int delete(final SqlSession sqlSession, final Stream stream) {
    return delete(sqlSession, stream, null);
  }
  
  public int delete(final Stream stream) {
    return delete(stream, null);
  }
  
  public List<Stream> list(final SqlSession sqlSession, final Stream stream, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list stream: " + stream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_STREAM";
    org.sqlproc.engine.SqlQueryEngine sqlEngineStream = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(stream, sqlControl);
    List<Stream> streamList = sqlEngineStream.query(sqlSession, Stream.class, stream, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list stream size: " + ((streamList != null) ? streamList.size() : "null"));
    }
    return streamList;
  }
  
  public List<Stream> list(final Stream stream, SqlControl sqlControl) {
    return list(sqlSessionFactory.getSqlSession(), stream, sqlControl);
  }
  
  public List<Stream> list(final SqlSession sqlSession, final Stream stream) {
    return list(sqlSession, stream, null);
  }
  
  public List<Stream> list(final Stream stream) {
    return list(stream, null);
  }
  
  public int query(final SqlSession sqlSession, final Stream stream, SqlControl sqlControl, final SqlRowProcessor<Stream> sqlRowProcessor) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query stream: " + stream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_STREAM";
    org.sqlproc.engine.SqlQueryEngine sqlEngineStream = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(stream, sqlControl);
    int rownums = sqlEngineStream.query(sqlSession, Stream.class, stream, sqlControl, sqlRowProcessor);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query stream size: " + rownums);
    }
    return rownums;
  }
  
  public int query(final Stream stream, SqlControl sqlControl, final SqlRowProcessor<Stream> sqlRowProcessor) {
    return query(sqlSessionFactory.getSqlSession(), stream, sqlControl, sqlRowProcessor);
  }
  
  public int query(final SqlSession sqlSession, final Stream stream, final SqlRowProcessor<Stream> sqlRowProcessor) {
    return query(sqlSession, stream, null, sqlRowProcessor);
  }
  
  public int query(final Stream stream, final SqlRowProcessor<Stream> sqlRowProcessor) {
    return query(stream, null, sqlRowProcessor);
  }
  
  public int count(final SqlSession sqlSession, final Stream stream, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("count stream: " + stream + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_STREAM";
    org.sqlproc.engine.SqlQueryEngine sqlEngineStream = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(stream, sqlControl);
    int count = sqlEngineStream.queryCount(sqlSession, stream, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("count: " + count);
    }
    return count;
  }
  
  public int count(final Stream stream, SqlControl sqlControl) {
    return count(sqlSessionFactory.getSqlSession(), stream, sqlControl);
  }
  
  public int count(final SqlSession sqlSession, final Stream stream) {
    return count(sqlSession, stream, null);
  }
  
  public int count(final Stream stream) {
    return count(stream, null);
  }
}
