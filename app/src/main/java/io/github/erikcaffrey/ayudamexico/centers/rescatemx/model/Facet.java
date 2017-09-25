
package io.github.erikcaffrey.ayudamexico.centers.rescatemx.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Facet implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("count")
    @Expose
    private long count;
    @SerializedName("state")
    @Expose
    private String state;
    private final static long serialVersionUID = -9222526221195547178L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Facet() {
    }

    /**
     * 
     * @param count
     * @param name
     * @param state
     * @param path
     */
    public Facet(String name, String path, long count, String state) {
        super();
        this.name = name;
        this.path = path;
        this.count = count;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
