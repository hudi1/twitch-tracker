package org.tomass.twitch.dao;

import java.util.List;
import org.slf4j.Logger;
import org.sqlproc.engine.SqlControl;
import org.sqlproc.engine.SqlEngineFactory;
import org.sqlproc.engine.SqlRowProcessor;
import org.sqlproc.engine.SqlSession;
import org.sqlproc.engine.SqlSessionFactory;
import org.tomass.twitch.model.ChatLog;

@SuppressWarnings("all")
public class ChatLogDao {
  protected final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
  
  public ChatLogDao() {
  }
  
  public ChatLogDao(final SqlEngineFactory sqlEngineFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
  }
  
  public ChatLogDao(final SqlEngineFactory sqlEngineFactory, final SqlSessionFactory sqlSessionFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  protected SqlEngineFactory sqlEngineFactory;
  
  protected SqlSessionFactory sqlSessionFactory;
  
  public ChatLog insert(final SqlSession sqlSession, final ChatLog chatLog, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert chatLog: " + chatLog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "INSERT_CHAT_LOG";
    org.sqlproc.engine.SqlCrudEngine sqlInsertChatLog = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlInsertChatLog.insert(sqlSession, chatLog, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert chatLog result: " + count + " " + chatLog);
    }
    return (count > 0) ? chatLog : null;
  }
  
  public ChatLog insert(final ChatLog chatLog, SqlControl sqlControl) {
    return insert(sqlSessionFactory.getSqlSession(), chatLog, sqlControl);
  }
  
  public ChatLog insert(final SqlSession sqlSession, final ChatLog chatLog) {
    return insert(sqlSession, chatLog, null);
  }
  
  public ChatLog insert(final ChatLog chatLog) {
    return insert(chatLog, null);
  }
  
  public ChatLog get(final SqlSession sqlSession, final ChatLog chatLog, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get: " + chatLog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "GET_CHAT_LOG";
    org.sqlproc.engine.SqlCrudEngine sqlGetEngineChatLog = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    //sqlControl = getMoreResultClasses(chatLog, sqlControl);
    ChatLog chatLogGot = sqlGetEngineChatLog.get(sqlSession, ChatLog.class, chatLog, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get chatLog result: " + chatLogGot);
    }
    return chatLogGot;
  }
  
  public ChatLog get(final ChatLog chatLog, SqlControl sqlControl) {
    return get(sqlSessionFactory.getSqlSession(), chatLog, sqlControl);
  }
  
  public ChatLog get(final SqlSession sqlSession, final ChatLog chatLog) {
    return get(sqlSession, chatLog, null);
  }
  
  public ChatLog get(final ChatLog chatLog) {
    return get(chatLog, null);
  }
  
  public int update(final SqlSession sqlSession, final ChatLog chatLog, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update chatLog: " + chatLog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "UPDATE_CHAT_LOG";
    org.sqlproc.engine.SqlCrudEngine sqlUpdateEngineChatLog = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlUpdateEngineChatLog.update(sqlSession, chatLog, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update chatLog result count: " + count);
    }
    return count;
  }
  
  public int update(final ChatLog chatLog, SqlControl sqlControl) {
    return update(sqlSessionFactory.getSqlSession(), chatLog, sqlControl);
  }
  
  public int update(final SqlSession sqlSession, final ChatLog chatLog) {
    return update(sqlSession, chatLog, null);
  }
  
  public int update(final ChatLog chatLog) {
    return update(chatLog, null);
  }
  
  public int delete(final SqlSession sqlSession, final ChatLog chatLog, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete chatLog: " + chatLog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "DELETE_CHAT_LOG";
    org.sqlproc.engine.SqlCrudEngine sqlDeleteEngineChatLog = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlDeleteEngineChatLog.delete(sqlSession, chatLog, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete chatLog result count: " + count);
    }
    return count;
  }
  
  public int delete(final ChatLog chatLog, SqlControl sqlControl) {
    return delete(sqlSessionFactory.getSqlSession(), chatLog, sqlControl);
  }
  
  public int delete(final SqlSession sqlSession, final ChatLog chatLog) {
    return delete(sqlSession, chatLog, null);
  }
  
  public int delete(final ChatLog chatLog) {
    return delete(chatLog, null);
  }
  
  public List<ChatLog> list(final SqlSession sqlSession, final ChatLog chatLog, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list chatLog: " + chatLog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_CHAT_LOG";
    org.sqlproc.engine.SqlQueryEngine sqlEngineChatLog = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(chatLog, sqlControl);
    List<ChatLog> chatLogList = sqlEngineChatLog.query(sqlSession, ChatLog.class, chatLog, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list chatLog size: " + ((chatLogList != null) ? chatLogList.size() : "null"));
    }
    return chatLogList;
  }
  
  public List<ChatLog> list(final ChatLog chatLog, SqlControl sqlControl) {
    return list(sqlSessionFactory.getSqlSession(), chatLog, sqlControl);
  }
  
  public List<ChatLog> list(final SqlSession sqlSession, final ChatLog chatLog) {
    return list(sqlSession, chatLog, null);
  }
  
  public List<ChatLog> list(final ChatLog chatLog) {
    return list(chatLog, null);
  }
  
  public int query(final SqlSession sqlSession, final ChatLog chatLog, SqlControl sqlControl, final SqlRowProcessor<ChatLog> sqlRowProcessor) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query chatLog: " + chatLog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_CHAT_LOG";
    org.sqlproc.engine.SqlQueryEngine sqlEngineChatLog = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(chatLog, sqlControl);
    int rownums = sqlEngineChatLog.query(sqlSession, ChatLog.class, chatLog, sqlControl, sqlRowProcessor);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query chatLog size: " + rownums);
    }
    return rownums;
  }
  
  public int query(final ChatLog chatLog, SqlControl sqlControl, final SqlRowProcessor<ChatLog> sqlRowProcessor) {
    return query(sqlSessionFactory.getSqlSession(), chatLog, sqlControl, sqlRowProcessor);
  }
  
  public int query(final SqlSession sqlSession, final ChatLog chatLog, final SqlRowProcessor<ChatLog> sqlRowProcessor) {
    return query(sqlSession, chatLog, null, sqlRowProcessor);
  }
  
  public int query(final ChatLog chatLog, final SqlRowProcessor<ChatLog> sqlRowProcessor) {
    return query(chatLog, null, sqlRowProcessor);
  }
  
  public int count(final SqlSession sqlSession, final ChatLog chatLog, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("count chatLog: " + chatLog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_CHAT_LOG";
    org.sqlproc.engine.SqlQueryEngine sqlEngineChatLog = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(chatLog, sqlControl);
    int count = sqlEngineChatLog.queryCount(sqlSession, chatLog, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("count: " + count);
    }
    return count;
  }
  
  public int count(final ChatLog chatLog, SqlControl sqlControl) {
    return count(sqlSessionFactory.getSqlSession(), chatLog, sqlControl);
  }
  
  public int count(final SqlSession sqlSession, final ChatLog chatLog) {
    return count(sqlSession, chatLog, null);
  }
  
  public int count(final ChatLog chatLog) {
    return count(chatLog, null);
  }
}
