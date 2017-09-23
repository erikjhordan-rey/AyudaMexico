package io.github.erikcaffrey.ayudamexico.announcement.model;

import com.google.gson.annotations.SerializedName;

public class Announcement {

    @SerializedName("LUGAR")
    private String place;

    @SerializedName("CONTACTO")
    private String contact;

    @SerializedName("AVISO")
    private String announcement;

    @SerializedName("MAPA")
    private String map;

    @SerializedName("ACTUALIZACION")
    private String updated;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
