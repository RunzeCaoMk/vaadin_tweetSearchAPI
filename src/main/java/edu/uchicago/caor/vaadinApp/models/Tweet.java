
package edu.uchicago.caor.vaadinApp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Tweet {

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
    private PublicMetrics__2 publicMetrics;
    @SerializedName("entities")
    @Expose
    private Entities__2 entities;
    @SerializedName("attachments")
    @Expose
    private Attachments attachments;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("author_id")
    @Expose
    private String authorId;
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

    public PublicMetrics__2 getPublicMetrics() {
        return publicMetrics;
    }

    public void setPublicMetrics(PublicMetrics__2 publicMetrics) {
        this.publicMetrics = publicMetrics;
    }

    public Entities__2 getEntities() {
        return entities;
    }

    public void setEntities(Entities__2 entities) {
        this.entities = entities;
    }

    public Attachments getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachments attachments) {
        this.attachments = attachments;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
