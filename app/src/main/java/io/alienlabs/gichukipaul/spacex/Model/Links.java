
package io.alienlabs.gichukipaul.spacex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Links {

    @SerializedName("flickr_images")
    @Expose
    private List<String> flickrImages = null;
    @SerializedName("mission_patch_small")
    @Expose
    private String missionPatchSmall;

    public List<String> getFlickrImages() {
        return flickrImages;
    }

    public void setFlickrImages(List<String> flickrImages) {
        this.flickrImages = flickrImages;
    }

    public String getMissionPatchSmall() {
        return missionPatchSmall;
    }

    public void setMissionPatchSmall(String missionPatchSmall) {
        this.missionPatchSmall = missionPatchSmall;
    }

}
