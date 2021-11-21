
package io.alienlabs.gichukipaul.spacex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("launchesPast")
    @Expose
    private List<LaunchesPast> launchesPast = null;

    public List<LaunchesPast> getLaunchesPast() {
        return launchesPast;
    }

    public void setLaunchesPast(List<LaunchesPast> launchesPast) {
        this.launchesPast = launchesPast;
    }

}
