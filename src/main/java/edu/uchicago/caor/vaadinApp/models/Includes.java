
package edu.uchicago.caor.vaadinApp.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Includes {

    @SerializedName("users")
    @Expose
    private List<User> users = null;
    @SerializedName("tweets")
    @Expose
    private List<Tweet> tweets = null;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

}
