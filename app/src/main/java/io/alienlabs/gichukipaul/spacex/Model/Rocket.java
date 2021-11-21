
package io.alienlabs.gichukipaul.spacex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rocket {

    @SerializedName("rocket_name")
    @Expose
    private String rocketName;

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

}
