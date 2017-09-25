
package io.github.erikcaffrey.ayudamexico.centers.rescatemx.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Record implements Serializable
{

    @SerializedName("datasetid")
    @Expose
    private String datasetid;
    @SerializedName("recordid")
    @Expose
    private String recordid;
    @SerializedName("fields")
    @Expose
    private Fields fields;
    @SerializedName("record_timestamp")
    @Expose
    private String recordTimestamp;
    @SerializedName("geometry")
    @Expose
    private Geometry geometry;
    private final static long serialVersionUID = 2279651098372146007L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Record() {
    }

    /**
     * 
     * @param datasetid
     * @param recordTimestamp
     * @param recordid
     * @param geometry
     * @param fields
     */
    public Record(String datasetid, String recordid, Fields fields, String recordTimestamp, Geometry geometry) {
        super();
        this.datasetid = datasetid;
        this.recordid = recordid;
        this.fields = fields;
        this.recordTimestamp = recordTimestamp;
        this.geometry = geometry;
    }

    public String getDatasetid() {
        return datasetid;
    }

    public void setDatasetid(String datasetid) {
        this.datasetid = datasetid;
    }

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public String getRecordTimestamp() {
        return recordTimestamp;
    }

    public void setRecordTimestamp(String recordTimestamp) {
        this.recordTimestamp = recordTimestamp;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

}
