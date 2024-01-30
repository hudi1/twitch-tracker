package org.tomass.twitch.twitchtracker.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.sqlproc.engine.annotation.Pojo;
import org.tomass.twitch.twitchtracker.model.TwitchStreamData;

@Pojo
@SuppressWarnings("all")
public class TwitchStream implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public static final String ORDER_BY_ID = "ID";
  
  public TwitchStream() {
  }
  
  public TwitchStream(final Long userId, final LocalDateTime startedAt, final Boolean mature, final String thumbnailUrl) {
    super();
    setUserId(userId);
    setStartedAt(startedAt);
    setMature(mature);
    setThumbnailUrl(thumbnailUrl);
  }
  
  private Long id;
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  public TwitchStream withId(final Long id) {
    this.id = id;
    return this;
  }
  
  private Long userId;
  
  public Long getUserId() {
    return this.userId;
  }
  
  public void setUserId(final Long userId) {
    this.userId = userId;
  }
  
  public TwitchStream withUserId(final Long userId) {
    this.userId = userId;
    return this;
  }
  
  private LocalDateTime startedAt;
  
  public LocalDateTime getStartedAt() {
    return this.startedAt;
  }
  
  public void setStartedAt(final LocalDateTime startedAt) {
    this.startedAt = startedAt;
  }
  
  public TwitchStream withStartedAt(final LocalDateTime startedAt) {
    this.startedAt = startedAt;
    return this;
  }
  
  private Boolean mature;
  
  public Boolean getMature() {
    return this.mature;
  }
  
  public void setMature(final Boolean mature) {
    this.mature = mature;
  }
  
  public TwitchStream withMature(final Boolean mature) {
    this.mature = mature;
    return this;
  }
  
  private String thumbnailUrl;
  
  public String getThumbnailUrl() {
    return this.thumbnailUrl;
  }
  
  public void setThumbnailUrl(final String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }
  
  public TwitchStream withThumbnailUrl(final String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
    return this;
  }
  
  private List<TwitchStreamData> twitchStreamDatas = new java.util.ArrayList<TwitchStreamData>();
  
  public List<TwitchStreamData> getTwitchStreamDatas() {
    return this.twitchStreamDatas;
  }
  
  public void setTwitchStreamDatas(final List<TwitchStreamData> twitchStreamDatas) {
    this.twitchStreamDatas = twitchStreamDatas;
  }
  
  public TwitchStream withTwitchStreamDatas(final List<TwitchStreamData> twitchStreamDatas) {
    this.twitchStreamDatas = twitchStreamDatas;
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
    TwitchStream other = (TwitchStream) obj;
    if (id == null || !id.equals(other.id))
    	return false;
    return true;
  }
  
  @Override
  public int hashCode() {
    return java.util.Objects.hash(id);
  }
  
  @Override
  public String toString() {
    return "TwitchStream [id=" + id + ", userId=" + userId + ", startedAt=" + startedAt + ", mature=" + mature + ", thumbnailUrl=" + thumbnailUrl + "]";
  }
  
  public String toStringFull() {
    return "TwitchStream [id=" + id + ", userId=" + userId + ", startedAt=" + startedAt + ", mature=" + mature + ", thumbnailUrl=" + thumbnailUrl + ", twitchStreamDatas=" + twitchStreamDatas + "]";
  }
  
  public enum Association {
    twitchStreamDatas;
  }
  
  private Set<String> initAssociations_ =  new java.util.HashSet<String>();
  
  public Set<String> getInitAssociations_() {
    return this.initAssociations_;
  }
  
  public void setInitAssociations_(final Set<String> initAssociations_) {
    this.initAssociations_ = initAssociations_;
  }
  
  public void setInit_(final TwitchStream.Association... associations) {
    if (associations == null)
    	throw new IllegalArgumentException();
    for (Association association : associations)
    	initAssociations_.add(association.name());
  }
  
  public TwitchStream withInit_(final TwitchStream.Association... associations) {
    setInit_(associations);
    return this;
  }
  
  public void clearInit_(final TwitchStream.Association... associations) {
    if (associations == null)
    	throw new IllegalArgumentException();
    for (Association association : associations)
    	initAssociations_.remove(association.name());
  }
  
  public TwitchStream _clearInit_(final TwitchStream.Association... associations) {
    clearInit_(associations);
    return this;
  }
  
  public void setInit_(final String... associations) {
    if (associations == null)
    	throw new IllegalArgumentException();
    for (String association : associations)
    	initAssociations_.add(association);
  }
  
  public TwitchStream withInit_(final String... associations) {
    setInit_(associations);
    return this;
  }
  
  public void clearInit_(final String... associations) {
    if (associations == null)
    	throw new IllegalArgumentException();
    for (String association : associations)
    	initAssociations_.remove(association);
  }
  
  public TwitchStream _clearInit_(final String... associations) {
    clearInit_(associations);
    return this;
  }
  
  public Boolean toInit_(final TwitchStream.Association association) {
    if (association == null)
    	throw new IllegalArgumentException();
    return initAssociations_.contains(association.name());
  }
  
  public Boolean toInit_(final String association) {
    if (association == null)
    	throw new IllegalArgumentException();
    return initAssociations_.contains(association);
  }
  
  public void clearAllInit_() {
    initAssociations_ = new java.util.HashSet<String>();
  }
  
  public enum OpAttribute {
    id,
    
    userId,
    
    startedAt,
    
    mature,
    
    thumbnailUrl,
    
    twitchStreamDatas;
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
  
  public void setOp_(final String operator, final TwitchStream.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.put(attribute.name(), operator);
  }
  
  public TwitchStream withOp_(final String operator, final TwitchStream.OpAttribute... attributes) {
    setOp_(operator, attributes);
    return this;
  }
  
  public void clearOp_(final TwitchStream.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.remove(attribute.name());
  }
  
  public TwitchStream _clearOp_(final TwitchStream.OpAttribute... attributes) {
    clearOp_(attributes);
    return this;
  }
  
  public void setOp_(final String operator, final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.put(attribute, operator);
  }
  
  public TwitchStream withOp_(final String operator, final String... attributes) {
    setOp_(operator, attributes);
    return this;
  }
  
  public void clearOp_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.remove(attribute);
  }
  
  public TwitchStream _clearOp_(final String... attributes) {
    clearOp_(attributes);
    return this;
  }
  
  public void setNullOp_(final TwitchStream.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.put(attribute.name(), "is null");
  }
  
  public TwitchStream withNullOp_(final TwitchStream.OpAttribute... attributes) {
    setNullOp_(attributes);
    return this;
  }
  
  public void setNullOp_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.put(attribute, "is null");
  }
  
  public TwitchStream withNullOp_(final String... attributes) {
    setNullOp_(attributes);
    return this;
  }
  
  public void clearAllOps_() {
    operators_ = new java.util.HashMap<String, String>();
  }
}
