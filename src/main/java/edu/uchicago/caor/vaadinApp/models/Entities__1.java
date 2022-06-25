
package edu.uchicago.caor.vaadinApp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Entities__1 {

    @SerializedName("url")
    @Expose
    private Url__1 url;
    @SerializedName("description")
    @Expose
    private Description description;

    public Url__1 getUrl() {
        return url;
    }

    public void setUrl(Url__1 url) {
        this.url = url;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

}
