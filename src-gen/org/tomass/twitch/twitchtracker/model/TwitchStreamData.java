package org.tomass.twitch.twitchtracker.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import org.sqlproc.engine.annotation.Pojo;
import org.tomass.twitch.twitchtracker.model.TwitchStream;

@Pojo
@SuppressWarnings("all")
public class TwitchStreamData implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public static final String ORDER_BY_ID = "ID";
  
  public static final String ORDER_BY_TWITCH_STREAM = "TWITCH_STREAM";
  
  public TwitchStreamData() {
  }
  
  public TwitchStreamData(final TwitchStream twitchStream, final String title, final Integer viewerCount, final LocalDateTime ts) {
    super();
    setTwitchStream(twitchStream);
    setTitle(title);
    setViewerCount(viewerCount);
    setTs(ts);
  }
  
  private Long id;
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  public TwitchStreamData withId(final Long id) {
    this.id = id;
    return this;
  }
  
  private TwitchStream twitchStream;
  
  public TwitchStream getTwitchStream() {
    return this.twitchStream;
  }
  
  public void setTwitchStream(final TwitchStream twitchStream) {
    this.twitchStream = twitchStream;
  }
  
  public TwitchStreamData withTwitchStream(final TwitchStream twitchStream) {
    this.twitchStream = twitchStream;
    return this;
  }
  
  private Integer gameId;
  
  public Integer getGameId() {
    return this.gameId;
  }
  
  public void setGameId(final Integer gameId) {
    this.gameId = gameId;
  }
  
  public TwitchStreamData withGameId(final Integer gameId) {
    this.gameId = gameId;
    return this;
  }
  
  private String gameName;
  
  public String getGameName() {
    return this.gameName;
  }
  
  public void setGameName(final String gameName) {
    this.gameName = gameName;
  }
  
  public TwitchStreamData withGameName(final String gameName) {
    this.gameName = gameName;
    return this;
  }
  
  private String title;
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(final String title) {
    this.title = title;
  }
  
  public TwitchStreamData withTitle(final String title) {
    this.title = title;
    return this;
  }
  
  private Integer viewerCount;
  
  public Integer getViewerCount() {
    return this.viewerCount;
  }
  
  public void setViewerCount(final Integer viewerCount) {
    this.viewerCount = viewerCount;
  }
  
  public TwitchStreamData withViewerCount(final Integer viewerCount) {
    this.viewerCount = viewerCount;
    return this;
  }
  
  private LocalDateTime ts;
  
  public LocalDateTime getTs() {
    return this.ts;
  }
  
  public void setTs(final LocalDateTime ts) {
    this.ts = ts;
  }
  
  public TwitchStreamData withTs(final LocalDateTime ts) {
    this.ts = ts;
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
    TwitchStreamData other = (TwitchStreamData) obj;
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
    return "TwitchStreamData [id=" + id + ", gameId=" + gameId + ", gameName=" + gameName + ", title=" + title + ", viewerCount=" + viewerCount + ", ts=" + ts + "]";
  }
  
  public String toStringFull() {
    return "TwitchStreamData [id=" + id + ", twitchStream=" + twitchStream + ", gameId=" + gameId + ", gameName=" + gameName + ", title=" + title + ", viewerCount=" + viewerCount + ", ts=" + ts + "]";
  }
  
  public enum Attribute {
    gameId,
    
    gameName;
  }
  
  private Set<String> nullValues_ =  new java.util.HashSet<String>();
  
  public void setNull_(final TwitchStreamData.Attribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (Attribute attribute : attributes)
    	nullValues_.add(attribute.name());
  }
  
  public TwitchStreamData withNull_(final TwitchStreamData.Attribute... attributes) {
    setNull_(attributes);
    return this;
  }
  
  public void clearNull_(final TwitchStreamData.Attribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (Attribute attribute : attributes)
    	nullValues_.remove(attribute.name());
  }
  
  public TwitchStreamData _clearNull_(final TwitchStreamData.Attribute... attributes) {
    clearNull_(attributes);
    return this;
  }
  
  public void setNull_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	nullValues_.add(attribute);
  }
  
  public TwitchStreamData withNull_(final String... attributes) {
    setNull_(attributes);
    return this;
  }
  
  public void clearNull_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	nullValues_.remove(attribute);
  }
  
  public TwitchStreamData _clearNull_(final String... attributes) {
    clearNull_(attributes);
    return this;
  }
  
  public Boolean isNull_(final TwitchStreamData.Attribute attribute) {
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
  
  public enum Association {
    twitchStream;
  }
  
  private Set<String> initAssociations_ =  new java.util.HashSet<String>();
  
  public Set<String> getInitAssociations_() {
    return this.initAssociations_;
  }
  
  public void setInitAssociations_(final Set<String> initAssociations_) {
    this.initAssociations_ = initAssociations_;
  }
  
  public void setInit_(final TwitchStreamData.Association... associations) {
    if (associations == null)
    	throw new IllegalArgumentException();
    for (Association association : associations)
    	initAssociations_.add(association.name());
  }
  
  public TwitchStreamData withInit_(final TwitchStreamData.Association... associations) {
    setInit_(associations);
    return this;
  }
  
  public void clearInit_(final TwitchStreamData.Association... associations) {
    if (associations == null)
    	throw new IllegalArgumentException();
    for (Association association : associations)
    	initAssociations_.remove(association.name());
  }
  
  public TwitchStreamData _clearInit_(final TwitchStreamData.Association... associations) {
    clearInit_(associations);
    return this;
  }
  
  public void setInit_(final String... associations) {
    if (associations == null)
    	throw new IllegalArgumentException();
    for (String association : associations)
    	initAssociations_.add(association);
  }
  
  public TwitchStreamData withInit_(final String... associations) {
    setInit_(associations);
    return this;
  }
  
  public void clearInit_(final String... associations) {
    if (associations == null)
    	throw new IllegalArgumentException();
    for (String association : associations)
    	initAssociations_.remove(association);
  }
  
  public TwitchStreamData _clearInit_(final String... associations) {
    clearInit_(associations);
    return this;
  }
  
  public Boolean toInit_(final TwitchStreamData.Association association) {
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
    
    twitchStream,
    
    gameId,
    
    gameName,
    
    title,
    
    viewerCount,
    
    ts;
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
  
  public void setOp_(final String operator, final TwitchStreamData.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.put(attribute.name(), operator);
  }
  
  public TwitchStreamData withOp_(final String operator, final TwitchStreamData.OpAttribute... attributes) {
    setOp_(operator, attributes);
    return this;
  }
  
  public void clearOp_(final TwitchStreamData.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.remove(attribute.name());
  }
  
  public TwitchStreamData _clearOp_(final TwitchStreamData.OpAttribute... attributes) {
    clearOp_(attributes);
    return this;
  }
  
  public void setOp_(final String operator, final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.put(attribute, operator);
  }
  
  public TwitchStreamData withOp_(final String operator, final String... attributes) {
    setOp_(operator, attributes);
    return this;
  }
  
  public void clearOp_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.remove(attribute);
  }
  
  public TwitchStreamData _clearOp_(final String... attributes) {
    clearOp_(attributes);
    return this;
  }
  
  public void setNullOp_(final TwitchStreamData.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.put(attribute.name(), "is null");
  }
  
  public TwitchStreamData withNullOp_(final TwitchStreamData.OpAttribute... attributes) {
    setNullOp_(attributes);
    return this;
  }
  
  public void setNullOp_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.put(attribute, "is null");
  }
  
  public TwitchStreamData withNullOp_(final String... attributes) {
    setNullOp_(attributes);
    return this;
  }
  
  public void clearAllOps_() {
    operators_ = new java.util.HashMap<String, String>();
  }
}
