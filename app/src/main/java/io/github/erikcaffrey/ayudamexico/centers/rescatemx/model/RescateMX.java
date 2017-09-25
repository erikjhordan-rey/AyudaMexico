
package io.github.erikcaffrey.ayudamexico.centers.rescatemx.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RescateMX implements Serializable
{

    @SerializedName("nhits")
    @Expose
    private long nhits;
    @SerializedName("parameters")
    @Expose
    private Parameters parameters;
    @SerializedName("records")
    @Expose
    private List<Record> records = null;
    @SerializedName("facet_groups")
    @Expose
    private List<FacetGroup> facetGroups = null;
    private final static long serialVersionUID = 9127746528788896341L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RescateMX() {
    }

    /**
     * 
     * @param nhits
     * @param parameters
     * @param records
     * @param facetGroups
     */
    public RescateMX(long nhits, Parameters parameters, List<Record> records, List<FacetGroup> facetGroups) {
        super();
        this.nhits = nhits;
        this.parameters = parameters;
        this.records = records;
        this.facetGroups = facetGroups;
    }

    public long getNhits() {
        return nhits;
    }

    public void setNhits(long nhits) {
        this.nhits = nhits;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public List<FacetGroup> getFacetGroups() {
        return facetGroups;
    }

    public void setFacetGroups(List<FacetGroup> facetGroups) {
        this.facetGroups = facetGroups;
    }

}
