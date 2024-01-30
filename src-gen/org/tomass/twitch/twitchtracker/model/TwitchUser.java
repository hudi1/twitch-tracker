package org.tomass.twitch.twitchtracker.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import org.sqlproc.engine.annotation.Pojo;

@Pojo
@SuppressWarnings("all")
public class TwitchUser implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public static final String ORDER_BY_ID = "ID";
  
  public TwitchUser() {
  }
  
  public TwitchUser(final String login, final String displayName, final LocalDateTime createdAt) {
    super();
    setLogin(login);
    setDisplayName(displayName);
    setCreatedAt(createdAt);
  }
  
  private Long id;
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  public TwitchUser withId(final Long id) {
    this.id = id;
    return this;
  }
  
  private String login;
  
  public String getLogin() {
    return this.login;
  }
  
  public void setLogin(final String login) {
    this.login = login;
  }
  
  public TwitchUser withLogin(final String login) {
    this.login = login;
    return this;
  }
  
  private String displayName;
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public void setDisplayName(final String displayName) {
    this.displayName = displayName;
  }
  
  public TwitchUser withDisplayName(final String displayName) {
    this.displayName = displayName;
    return this;
  }
  
  private String type;
  
  public String getType() {
    return this.type;
  }
  
  public void setType(final String type) {
    this.type = type;
  }
  
  public TwitchUser withType(final String type) {
    this.type = type;
    return this;
  }
  
  private String broadcasterType;
  
  public String getBroadcasterType() {
    return this.broadcasterType;
  }
  
  public void setBroadcasterType(final String broadcasterType) {
    this.broadcasterType = broadcasterType;
  }
  
  public TwitchUser withBroadcasterType(final String broadcasterType) {
    this.broadcasterType = broadcasterType;
    return this;
  }
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(final String description) {
    this.description = description;
  }
  
  public TwitchUser withDescription(final String description) {
    this.description = description;
    return this;
  }
  
  private String profileImageUrl;
  
  public String getProfileImageUrl() {
    return this.profileImageUrl;
  }
  
  public void setProfileImageUrl(final String profileImageUrl) {
    this.profileImageUrl = profileImageUrl;
  }
  
  public TwitchUser withProfileImageUrl(final String profileImageUrl) {
    this.profileImageUrl = profileImageUrl;
    return this;
  }
  
  private String offlineImageUrl;
  
  public String getOfflineImageUrl() {
    return this.offlineImageUrl;
  }
  
  public void setOfflineImageUrl(final String offlineImageUrl) {
    this.offlineImageUrl = offlineImageUrl;
  }
  
  public TwitchUser withOfflineImageUrl(final String offlineImageUrl) {
    this.offlineImageUrl = offlineImageUrl;
    return this;
  }
  
  private LocalDateTime createdAt;
  
  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }
  
  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
  
  public TwitchUser withCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
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
    TwitchUser other = (TwitchUser) obj;
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
    return "TwitchUser [id=" + id + ", login=" + login + ", displayName=" + displayName + ", type=" + type + ", broadcasterType=" + broadcasterType + ", description=" + description + ", profileImageUrl=" + profileImageUrl + ", offlineImageUrl=" + offlineImageUrl + ", createdAt=" + createdAt + "]";
  }
  
  public String toStringFull() {
    return "TwitchUser [id=" + id + ", login=" + login + ", displayName=" + displayName + ", type=" + type + ", broadcasterType=" + broadcasterType + ", description=" + description + ", profileImageUrl=" + profileImageUrl + ", offlineImageUrl=" + offlineImageUrl + ", createdAt=" + createdAt + "]";
  }
  
  public enum Attribute {
    type,
    
    broadcasterType,
    
    description,
    
    profileImageUrl,
    
    offlineImageUrl;
  }
  
  private Set<String> nullValues_ =  new java.util.HashSet<String>();
  
  public void setNull_(final TwitchUser.Attribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (Attribute attribute : attributes)
    	nullValues_.add(attribute.name());
  }
  
  public TwitchUser withNull_(final TwitchUser.Attribute... attributes) {
    setNull_(attributes);
    return this;
  }
  
  public void clearNull_(final TwitchUser.Attribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (Attribute attribute : attributes)
    	nullValues_.remove(attribute.name());
  }
  
  public TwitchUser _clearNull_(final TwitchUser.Attribute... attributes) {
    clearNull_(attributes);
    return this;
  }
  
  public void setNull_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	nullValues_.add(attribute);
  }
  
  public TwitchUser withNull_(final String... attributes) {
    setNull_(attributes);
    return this;
  }
  
  public void clearNull_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	nullValues_.remove(attribute);
  }
  
  public TwitchUser _clearNull_(final String... attributes) {
    clearNull_(attributes);
    return this;
  }
  
  public Boolean isNull_(final TwitchUser.Attribute attribute) {
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
    id,
    
    login,
    
    displayName,
    
    type,
    
    broadcasterType,
    
    description,
    
    profileImageUrl,
    
    offlineImageUrl,
    
    createdAt;
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
  
  public void setOp_(final String operator, final TwitchUser.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.put(attribute.name(), operator);
  }
  
  public TwitchUser withOp_(final String operator, final TwitchUser.OpAttribute... attributes) {
    setOp_(operator, attributes);
    return this;
  }
  
  public void clearOp_(final TwitchUser.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.remove(attribute.name());
  }
  
  public TwitchUser _clearOp_(final TwitchUser.OpAttribute... attributes) {
    clearOp_(attributes);
    return this;
  }
  
  public void setOp_(final String operator, final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.put(attribute, operator);
  }
  
  public TwitchUser withOp_(final String operator, final String... attributes) {
    setOp_(operator, attributes);
    return this;
  }
  
  public void clearOp_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.remove(attribute);
  }
  
  public TwitchUser _clearOp_(final String... attributes) {
    clearOp_(attributes);
    return this;
  }
  
  public void setNullOp_(final TwitchUser.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.put(attribute.name(), "is null");
  }
  
  public TwitchUser withNullOp_(final TwitchUser.OpAttribute... attributes) {
    setNullOp_(attributes);
    return this;
  }
  
  public void setNullOp_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.put(attribute, "is null");
  }
  
  public TwitchUser withNullOp_(final String... attributes) {
    setNullOp_(attributes);
    return this;
  }
  
  public void clearAllOps_() {
    operators_ = new java.util.HashMap<String, String>();
  }
}
