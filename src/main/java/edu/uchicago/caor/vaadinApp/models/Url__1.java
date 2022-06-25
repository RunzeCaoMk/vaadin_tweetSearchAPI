
package edu.uchicago.caor.vaadinApp.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Url__1 {

    @SerializedName("urls")
    @Expose
    private List<Url__2> urls = null;

    public List<Url__2> getUrls() {
        return urls;
    }

    public void setUrls(List<Url__2> urls) {
        this.urls = urls;
    }

}
