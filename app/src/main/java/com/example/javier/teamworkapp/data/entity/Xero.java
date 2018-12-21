
package com.example.javier.teamworkapp.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Xero {

    @SerializedName("countrycode")
    @Expose
    private String countrycode;
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;
    @SerializedName("connected")
    @Expose
    private String connected;
    @SerializedName("organisation")
    @Expose
    private String organisation;
    @SerializedName("basecurrency")
    @Expose
    private String basecurrency;

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getConnected() {
        return connected;
    }

    public void setConnected(String connected) {
        this.connected = connected;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getBasecurrency() {
        return basecurrency;
    }

    public void setBasecurrency(String basecurrency) {
        this.basecurrency = basecurrency;
    }

}
