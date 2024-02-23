package org.tomass.twitch.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import org.sqlproc.engine.annotation.Pojo;
import org.tomass.twitch.model.Stream;

@Pojo
@SuppressWarnings("all")
public class StreamData implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public static final String ORDER_BY_ID = "ID";
  
  public static final String ORDER_BY_STREAM = "STREAM";
  
  public StreamData() {
  }
  
  public StreamData(final Stream stream, final String title, final Integer viewerCount, final LocalDateTime ts) {
    super();
    setStream(stream);
    setTitle(title);
    setViewerCount(viewerCount);
    setTs(ts);
  }
  
  private String id;
  
  public String getId() {
    return this.id;
  }
  
  public void setId(final String id) {
    this.id = id;
  }
  
  public StreamData withId(final String id) {
    this.id = id;
    return this;
  }
  
  private Stream stream;
  
  public Stream getStream() {
    return this.stream;
  }
  
  public void setStream(final Stream stream) {
    this.stream = stream;
  }
  
  public StreamData withStream(final Stream stream) {
    this.stream = stream;
    return this;
  }
  
  private Integer gameId;
  
  public Integer getGameId() {
    return this.gameId;
  }
  
  public void setGameId(final Integer gameId) {
    this.gameId = gameId;
  }
  
  public StreamData withGameId(final Integer gameId) {
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
  
  public StreamData withGameName(final String gameName) {
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
  
  public StreamData withTitle(final String title) {
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
  
  public StreamData withViewerCount(final Integer viewerCount) {
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
  
  public StreamData withTs(final LocalDateTime ts) {
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
    StreamData other = (StreamData) obj;
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
    return "StreamData [id=" + id + ", gameId=" + gameId + ", gameName=" + gameName + ", title=" + title + ", viewerCount=" + viewerCount + ", ts=" + ts + "]";
  }
  
  public String toStringFull() {
    return "StreamData [id=" + id + ", stream=" + stream + ", gameId=" + gameId + ", gameName=" + gameName + ", title=" + title + ", viewerCount=" + viewerCount + ", ts=" + ts + "]";
  }
  
  public enum Attribute {
    gameId,
    
    gameName;
  }
  
  private Set<String> nullValues_ =  new java.util.HashSet<String>();
  
  public void setNull_(final StreamData.Attribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (Attribute attribute : attributes)
    	nullValues_.add(attribute.name());
  }
  
  public StreamData withNull_(final StreamData.Attribute... attributes) {
    setNull_(attributes);
    return this;
  }
  
  public void clearNull_(final StreamData.Attribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (Attribute attribute : attributes)
    	nullValues_.remove(attribute.name());
  }
  
  public StreamData _clearNull_(final StreamData.Attribute... attributes) {
    clearNull_(attributes);
    return this;
  }
  
  public void setNull_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	nullValues_.add(attribute);
  }
  
  public StreamData withNull_(final String... attributes) {
    setNull_(attributes);
    return this;
  }
  
  public void clearNull_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	nullValues_.remove(attribute);
  }
  
  public StreamData _clearNull_(final String... attributes) {
    clearNull_(attributes);
    return this;
  }
  
  public Boolean isNull_(final StreamData.Attribute attribute) {
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
    stream;
  }
  
  private Set<String> initAssociations_ =  new java.util.HashSet<String>();
  
  public Set<String> getInitAssociations_() {
    return this.initAssociations_;
  }
  
  public void setInitAssociations_(final Set<String> initAssociations_) {
    this.initAssociations_ = initAssociations_;
  }
  
  public void setInit_(final StreamData.Association... associations) {
    if (associations == null)
    	throw new IllegalArgumentException();
    for (Association association : associations)
    	initAssociations_.add(association.name());
  }
  
  public StreamData withInit_(final StreamData.Association... associations) {
    setInit_(associations);
    return this;
  }
  
  public void clearInit_(final StreamData.Association... associations) {
    if (associations == null)
    	throw new IllegalArgumentException();
    for (Association association : associations)
    	initAssociations_.remove(association.name());
  }
  
  public StreamData _clearInit_(final StreamData.Association... associations) {
    clearInit_(associations);
    return this;
  }
  
  public void setInit_(final String... associations) {
    if (associations == null)
    	throw new IllegalArgumentException();
    for (String association : associations)
    	initAssociations_.add(association);
  }
  
  public StreamData withInit_(final String... associations) {
    setInit_(associations);
    return this;
  }
  
  public void clearInit_(final String... associations) {
    if (associations == null)
    	throw new IllegalArgumentException();
    for (String association : associations)
    	initAssociations_.remove(association);
  }
  
  public StreamData _clearInit_(final String... associations) {
    clearInit_(associations);
    return this;
  }
  
  public Boolean toInit_(final StreamData.Association association) {
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
    
    stream,
    
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
  
  public void setOp_(final String operator, final StreamData.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.put(attribute.name(), operator);
  }
  
  public StreamData withOp_(final String operator, final StreamData.OpAttribute... attributes) {
    setOp_(operator, attributes);
    return this;
  }
  
  public void clearOp_(final StreamData.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.remove(attribute.name());
  }
  
  public StreamData _clearOp_(final StreamData.OpAttribute... attributes) {
    clearOp_(attributes);
    return this;
  }
  
  public void setOp_(final String operator, final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.put(attribute, operator);
  }
  
  public StreamData withOp_(final String operator, final String... attributes) {
    setOp_(operator, attributes);
    return this;
  }
  
  public void clearOp_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.remove(attribute);
  }
  
  public StreamData _clearOp_(final String... attributes) {
    clearOp_(attributes);
    return this;
  }
  
  public void setNullOp_(final StreamData.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.put(attribute.name(), "is null");
  }
  
  public StreamData withNullOp_(final StreamData.OpAttribute... attributes) {
    setNullOp_(attributes);
    return this;
  }
  
  public void setNullOp_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.put(attribute, "is null");
  }
  
  public StreamData withNullOp_(final String... attributes) {
    setNullOp_(attributes);
    return this;
  }
  
  public void clearAllOps_() {
    operators_ = new java.util.HashMap<String, String>();
  }
}
