package io.github.erikcaffrey.ayudamexico.hostels.model;

import com.google.gson.annotations.SerializedName;

public class Hostel {

    @SerializedName("LUGAR") private String place;
    @SerializedName("NECESITAN") private String needsTo;
    @SerializedName("RECIBEN") private String receive;
    @SerializedName("DIRECCION") private String address;
    @SerializedName("ZONA") private String zone;
    @SerializedName("MAPA") private String map;
    @SerializedName("MAS_INFO") private String moreInfo;
    @SerializedName("ACTUALIZACION") private String update;

    public String getPlace() {
        return place;
    }

    public String getNeedsTo() {
        return needsTo;
    }

    public String getAddress() {
        return address;
    }

    public String getZone() {
        return zone;
    }

    public String getMap() {
        return map;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public String getUpdate() {
        return update;
    }

    public String getReceive() {return receive;}
}
