
package io.alienlabs.gichukipaul.spacex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LaunchesPast {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("mission_name")
    @Expose
    private String missionName;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("rocket")
    @Expose
    private Rocket rocket;
    @SerializedName("launch_date_utc")
    @Expose
    private String launchDateUtc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

}
