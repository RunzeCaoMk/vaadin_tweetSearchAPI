
package edu.uchicago.caor.vaadinApp.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Attachments {

    @SerializedName("media_keys")
    @Expose
    private List<String> mediaKeys = null;

    public List<String> getMediaKeys() {
        return mediaKeys;
    }

    public void setMediaKeys(List<String> mediaKeys) {
        this.mediaKeys = mediaKeys;
    }

}
