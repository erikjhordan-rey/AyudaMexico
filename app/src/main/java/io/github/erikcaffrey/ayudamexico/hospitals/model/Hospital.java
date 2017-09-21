
package io.github.erikcaffrey.ayudamexico.hospitals.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Hospital implements Serializable
{

    @SerializedName("Hospital")
    @Expose
    private String hospital;
    @SerializedName("NECESITAN")
    @Expose
    private String nECESITAN;
    @SerializedName("RECIBEN")
    @Expose
    private String rECIBEN;
    @SerializedName("DIRECCION")
    @Expose
    private String dIRECCION;
    @SerializedName("ZONA")
    @Expose
    private String zONA;
    @SerializedName("MAPA")
    @Expose
    private String mAPA;
    @SerializedName("MAS_INFO")
    @Expose
    private String mASINFO;
    @SerializedName("ACTUALIZACION")
    @Expose
    private String aCTUALIZACION;
    private final static long serialVersionUID = 6948390846460347857L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Hospital() {
    }

    /**
     *
     * @param mASINFO
     * @param rECIBEN
     * @param mAPA
     * @param zONA
     * @param dIRECCION
     * @param nECESITAN
     * @param hospital
     * @param aCTUALIZACION
     */
    public Hospital(String hospital, String nECESITAN, String rECIBEN, String dIRECCION, String zONA, String mAPA, String mASINFO, String aCTUALIZACION) {
        super();
        this.hospital = hospital;
        this.nECESITAN = nECESITAN;
        this.rECIBEN = rECIBEN;
        this.dIRECCION = dIRECCION;
        this.zONA = zONA;
        this.mAPA = mAPA;
        this.mASINFO = mASINFO;
        this.aCTUALIZACION = aCTUALIZACION;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getNECESITAN() {
        return nECESITAN;
    }

    public void setNECESITAN(String nECESITAN) {
        this.nECESITAN = nECESITAN;
    }

    public String getRECIBEN() {
        return rECIBEN;
    }

    public void setRECIBEN(String rECIBEN) {
        this.rECIBEN = rECIBEN;
    }

    public String getDIRECCION() {
        return dIRECCION;
    }

    public void setDIRECCION(String dIRECCION) {
        this.dIRECCION = dIRECCION;
    }

    public String getZONA() {
        return zONA;
    }

    public void setZONA(String zONA) {
        this.zONA = zONA;
    }

    public String getMAPA() {
        return mAPA;
    }

    public void setMAPA(String mAPA) {
        this.mAPA = mAPA;
    }

    public String getMASINFO() {
        return mASINFO;
    }

    public void setMASINFO(String mASINFO) {
        this.mASINFO = mASINFO;
    }

    public String getACTUALIZACION() {
        return aCTUALIZACION;
    }

    public void setACTUALIZACION(String aCTUALIZACION) {
        this.aCTUALIZACION = aCTUALIZACION;
    }

}
