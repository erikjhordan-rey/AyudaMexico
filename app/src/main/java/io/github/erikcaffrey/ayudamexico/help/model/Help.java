package io.github.erikcaffrey.ayudamexico.help.model;

import com.google.gson.annotations.SerializedName;

public class Help {

    @SerializedName("NIVEL_DE_URGENCIA") private String levelOfUrgency;
    @SerializedName("AYUDA_REQUERIDA") private String helpRequired;
    @SerializedName("QUE_NO_SE_REQUIERE") private String notRequired;
    @SerializedName("DIRECCION") private String address;
    @SerializedName("ZONE") private String zone;
    @SerializedName("Link_de_GMaps") private String linkMaps;
    @SerializedName("DETALLE") private String detail;
    @SerializedName("FECHA_DE_ACTUALIZACION") private String updateDate;
    @SerializedName("HORA") private String time;
    @SerializedName("STATUS") private String status;

    public String getLevelOfUrgency() {
        return levelOfUrgency;
    }

    public String getHelpRequired() {
        return helpRequired;
    }

    public String getNotRequired() {
        return notRequired;
    }

    public String getAddress() {
        return address;
    }

    public String getZone() {
        return zone;
    }

    public String getLinkMaps() {
        return linkMaps;
    }

    public String getDetail() {
        return detail;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }
}
