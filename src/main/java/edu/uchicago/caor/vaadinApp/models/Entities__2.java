
package edu.uchicago.caor.vaadinApp.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Entities__2 {

    @SerializedName("mentions")
    @Expose
    private List<Mention> mentions = null;
    @SerializedName("urls")
    @Expose
    private List<Url__3> urls = null;
    @SerializedName("hashtags")
    @Expose
    private List<Hashtag__1> hashtags = null;

    public List<Mention> getMentions() {
        return mentions;
    }

    public void setMentions(List<Mention> mentions) {
        this.mentions = mentions;
    }

    public List<Url__3> getUrls() {
        return urls;
    }

    public void setUrls(List<Url__3> urls) {
        this.urls = urls;
    }

    public List<Hashtag__1> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag__1> hashtags) {
        this.hashtags = hashtags;
    }

}
