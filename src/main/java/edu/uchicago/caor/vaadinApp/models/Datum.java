
package edu.uchicago.caor.vaadinApp.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Datum {

    @SerializedName("conversation_id")
    @Expose
    private String conversationId;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("possibly_sensitive")
    @Expose
    private Boolean possiblySensitive;
    @SerializedName("public_metrics")
    @Expose
    private PublicMetrics publicMetrics;
    @SerializedName("entities")
    @Expose
    private Entities entities;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("in_reply_to_user_id")
    @Expose
    private String inReplyToUserId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("author_id")
    @Expose
    private String authorId;
    @SerializedName("referenced_tweets")
    @Expose
    private List<ReferencedTweet> referencedTweets = null;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("source")
    @Expose
    private String source;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getPossiblySensitive() {
        return possiblySensitive;
    }

    public void setPossiblySensitive(Boolean possiblySensitive) {
        this.possiblySensitive = possiblySensitive;
    }

    public PublicMetrics getPublicMetrics() {
        return publicMetrics;
    }

    public void setPublicMetrics(PublicMetrics publicMetrics) {
        this.publicMetrics = publicMetrics;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(String inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public List<ReferencedTweet> getReferencedTweets() {
        return referencedTweets;
    }

    public void setReferencedTweets(List<ReferencedTweet> referencedTweets) {
        this.referencedTweets = referencedTweets;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
