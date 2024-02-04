package org.tomass.twitch.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import org.sqlproc.engine.annotation.Pojo;

@Pojo
@SuppressWarnings("all")
public class ChatLog implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public static final String ORDER_BY_EVENT_ID = "EVENT_ID";
  
  public static final String ORDER_BY_CHANNEL_ID = "CHANNEL_ID";
  
  public static final String ORDER_BY_USER_ID = "USER_ID";
  
  public static final String ORDER_BY_STREAM_ID = "STREAM_ID";
  
  public ChatLog() {
  }
  
  public ChatLog(final String channel, final String user, final Long channelId, final Long userId, final String message, final LocalDateTime ts, final LocalDateTime fireAt) {
    super();
    setChannel(channel);
    setUser(user);
    setChannelId(channelId);
    setUserId(userId);
    setMessage(message);
    setTs(ts);
    setFireAt(fireAt);
  }
  
  private String eventId;
  
  public String getEventId() {
    return this.eventId;
  }
  
  public void setEventId(final String eventId) {
    this.eventId = eventId;
  }
  
  public ChatLog withEventId(final String eventId) {
    this.eventId = eventId;
    return this;
  }
  
  private String channel;
  
  public String getChannel() {
    return this.channel;
  }
  
  public void setChannel(final String channel) {
    this.channel = channel;
  }
  
  public ChatLog withChannel(final String channel) {
    this.channel = channel;
    return this;
  }
  
  private String user;
  
  public String getUser() {
    return this.user;
  }
  
  public void setUser(final String user) {
    this.user = user;
  }
  
  public ChatLog withUser(final String user) {
    this.user = user;
    return this;
  }
  
  private Long channelId;
  
  public Long getChannelId() {
    return this.channelId;
  }
  
  public void setChannelId(final Long channelId) {
    this.channelId = channelId;
  }
  
  public ChatLog withChannelId(final Long channelId) {
    this.channelId = channelId;
    return this;
  }
  
  private Long userId;
  
  public Long getUserId() {
    return this.userId;
  }
  
  public void setUserId(final Long userId) {
    this.userId = userId;
  }
  
  public ChatLog withUserId(final Long userId) {
    this.userId = userId;
    return this;
  }
  
  private String message;
  
  public String getMessage() {
    return this.message;
  }
  
  public void setMessage(final String message) {
    this.message = message;
  }
  
  public ChatLog withMessage(final String message) {
    this.message = message;
    return this;
  }
  
  private Long streamId;
  
  public Long getStreamId() {
    return this.streamId;
  }
  
  public void setStreamId(final Long streamId) {
    this.streamId = streamId;
  }
  
  public ChatLog withStreamId(final Long streamId) {
    this.streamId = streamId;
    return this;
  }
  
  private LocalDateTime ts;
  
  public LocalDateTime getTs() {
    return this.ts;
  }
  
  public void setTs(final LocalDateTime ts) {
    this.ts = ts;
  }
  
  public ChatLog withTs(final LocalDateTime ts) {
    this.ts = ts;
    return this;
  }
  
  private LocalDateTime fireAt;
  
  public LocalDateTime getFireAt() {
    return this.fireAt;
  }
  
  public void setFireAt(final LocalDateTime fireAt) {
    this.fireAt = fireAt;
  }
  
  public ChatLog withFireAt(final LocalDateTime fireAt) {
    this.fireAt = fireAt;
    return this;
  }
  
  private String color;
  
  public String getColor() {
    return this.color;
  }
  
  public void setColor(final String color) {
    this.color = color;
  }
  
  public ChatLog withColor(final String color) {
    this.color = color;
    return this;
  }
  
  private Integer subsMonths;
  
  public Integer getSubsMonths() {
    return this.subsMonths;
  }
  
  public void setSubsMonths(final Integer subsMonths) {
    this.subsMonths = subsMonths;
  }
  
  public ChatLog withSubsMonths(final Integer subsMonths) {
    this.subsMonths = subsMonths;
    return this;
  }
  
  private Integer subsTier;
  
  public Integer getSubsTier() {
    return this.subsTier;
  }
  
  public void setSubsTier(final Integer subsTier) {
    this.subsTier = subsTier;
  }
  
  public ChatLog withSubsTier(final Integer subsTier) {
    this.subsTier = subsTier;
    return this;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (obj == null)
    	return false;
    if (getClass() != obj.getClass())
    	return false;
    ChatLog other = (ChatLog) obj;
    if (eventId == null || !eventId.equals(other.eventId))
    	return false;
    return true;
  }
  
  @Override
  public int hashCode() {
    return java.util.Objects.hash(eventId);
  }
  
  @Override
  public String toString() {
    return "ChatLog [eventId=" + eventId + ", channel=" + channel + ", user=" + user + ", channelId=" + channelId + ", userId=" + userId + ", message=" + message + ", streamId=" + streamId + ", ts=" + ts + ", fireAt=" + fireAt + ", color=" + color + ", subsMonths=" + subsMonths + ", subsTier=" + subsTier + "]";
  }
  
  public String toStringFull() {
    return "ChatLog [eventId=" + eventId + ", channel=" + channel + ", user=" + user + ", channelId=" + channelId + ", userId=" + userId + ", message=" + message + ", streamId=" + streamId + ", ts=" + ts + ", fireAt=" + fireAt + ", color=" + color + ", subsMonths=" + subsMonths + ", subsTier=" + subsTier + "]";
  }
  
  public enum Attribute {
    streamId,
    
    color,
    
    subsMonths,
    
    subsTier;
  }
  
  private Set<String> nullValues_ =  new java.util.HashSet<String>();
  
  public void setNull_(final ChatLog.Attribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (Attribute attribute : attributes)
    	nullValues_.add(attribute.name());
  }
  
  public ChatLog withNull_(final ChatLog.Attribute... attributes) {
    setNull_(attributes);
    return this;
  }
  
  public void clearNull_(final ChatLog.Attribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (Attribute attribute : attributes)
    	nullValues_.remove(attribute.name());
  }
  
  public ChatLog _clearNull_(final ChatLog.Attribute... attributes) {
    clearNull_(attributes);
    return this;
  }
  
  public void setNull_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	nullValues_.add(attribute);
  }
  
  public ChatLog withNull_(final String... attributes) {
    setNull_(attributes);
    return this;
  }
  
  public void clearNull_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	nullValues_.remove(attribute);
  }
  
  public ChatLog _clearNull_(final String... attributes) {
    clearNull_(attributes);
    return this;
  }
  
  public Boolean isNull_(final ChatLog.Attribute attribute) {
    if (attribute == null)
    	throw new IllegalArgumentException();
    return nullValues_.contains(attribute.name());
  }
  
  public Boolean isNull_(final String attrName) {
    if (attrName == null)
    	throw new IllegalArgumentException();
    return nullValues_.contains(attrName);
  }
  
  public Boolean isDef_(final String attrName, final Boolean isAttrNotNull) {
    if (attrName == null)
    	throw new IllegalArgumentException();
    if (nullValues_.contains(attrName))
    	return true;
    if (isAttrNotNull != null)
    	return isAttrNotNull;
    return false;
  }
  
  public void clearAllNull_() {
    nullValues_ = new java.util.HashSet<String>();
  }
  
  public enum OpAttribute {
    eventId,
    
    channel,
    
    user,
    
    channelId,
    
    userId,
    
    message,
    
    streamId,
    
    ts,
    
    fireAt,
    
    color,
    
    subsMonths,
    
    subsTier;
  }
  
  private Map<String, String> operators_ =  new java.util.HashMap<String, String>();
  
  public Map<String, String> getOperators_() {
    return operators_;
  }
  
  public String getOp_(final String attrName) {
    if (attrName == null)
    	throw new IllegalArgumentException();
    return operators_.get(attrName);
  }
  
  public void setOp_(final String operator, final ChatLog.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.put(attribute.name(), operator);
  }
  
  public ChatLog withOp_(final String operator, final ChatLog.OpAttribute... attributes) {
    setOp_(operator, attributes);
    return this;
  }
  
  public void clearOp_(final ChatLog.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.remove(attribute.name());
  }
  
  public ChatLog _clearOp_(final ChatLog.OpAttribute... attributes) {
    clearOp_(attributes);
    return this;
  }
  
  public void setOp_(final String operator, final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.put(attribute, operator);
  }
  
  public ChatLog withOp_(final String operator, final String... attributes) {
    setOp_(operator, attributes);
    return this;
  }
  
  public void clearOp_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.remove(attribute);
  }
  
  public ChatLog _clearOp_(final String... attributes) {
    clearOp_(attributes);
    return this;
  }
  
  public void setNullOp_(final ChatLog.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.put(attribute.name(), "is null");
  }
  
  public ChatLog withNullOp_(final ChatLog.OpAttribute... attributes) {
    setNullOp_(attributes);
    return this;
  }
  
  public void setNullOp_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.put(attribute, "is null");
  }
  
  public ChatLog withNullOp_(final String... attributes) {
    setNullOp_(attributes);
    return this;
  }
  
  public void clearAllOps_() {
    operators_ = new java.util.HashMap<String, String>();
  }
}
