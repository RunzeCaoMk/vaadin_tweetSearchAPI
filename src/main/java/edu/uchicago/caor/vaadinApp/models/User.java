
package edu.uchicago.caor.vaadinApp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class User {

    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("profile_image_url")
    @Expose
    private String profileImageUrl;
    @SerializedName("entities")
    @Expose
    private Entities__1 entities;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("pinned_tweet_id")
    @Expose
    private String pinnedTweetId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("public_metrics")
    @Expose
    private PublicMetrics__1 publicMetrics;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("protected")
    @Expose
    private Boolean _protected;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public Entities__1 getEntities() {
        return entities;
    }

    public void setEntities(Entities__1 entities) {
        this.entities = entities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPinnedTweetId() {
        return pinnedTweetId;
    }

    public void setPinnedTweetId(String pinnedTweetId) {
        this.pinnedTweetId = pinnedTweetId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PublicMetrics__1 getPublicMetrics() {
        return publicMetrics;
    }

    public void setPublicMetrics(PublicMetrics__1 publicMetrics) {
        this.publicMetrics = publicMetrics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getProtected() {
        return _protected;
    }

    public void setProtected(Boolean _protected) {
        this._protected = _protected;
    }

}
