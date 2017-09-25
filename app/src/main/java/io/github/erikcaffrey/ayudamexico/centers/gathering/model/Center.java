package io.github.erikcaffrey.ayudamexico.centers.gathering.model;

import com.google.gson.annotations.SerializedName;

public class Center {

    @SerializedName("LUGAR")
    private String place;

    @SerializedName("PIDE")
    private String asking;

    @SerializedName("DIRECCION")
    private String address;

    @SerializedName("ZONA")
    private String zone;

    @SerializedName("MAPA")
    private String map;

    @SerializedName("MAS_INFO")
    private String moreInfo;

    @SerializedName("ACTUALIZACION")
    private String updated;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAsking() {
        return asking;
    }

    public void setAsking(String asking) {
        this.asking = asking;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getMap() {
        if (map.contains("http")) {
            if (map.startsWith("http"))
                return map;
            else
                return map.substring(map.indexOf("http"));
        } else {
            return "";
        }
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
