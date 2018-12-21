
package com.example.javier.teamworkapp.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Integrations {

    @SerializedName("xero")
    @Expose
    private Xero xero;
    @SerializedName("sharepoint")
    @Expose
    private Sharepoint sharepoint;
    @SerializedName("microsoftConnectors")
    @Expose
    private MicrosoftConnectors microsoftConnectors;
    @SerializedName("onedrivebusiness")
    @Expose
    private Onedrivebusiness onedrivebusiness;

    public Xero getXero() {
        return xero;
    }

    public void setXero(Xero xero) {
        this.xero = xero;
    }

    public Sharepoint getSharepoint() {
        return sharepoint;
    }

    public void setSharepoint(Sharepoint sharepoint) {
        this.sharepoint = sharepoint;
    }

    public MicrosoftConnectors getMicrosoftConnectors() {
        return microsoftConnectors;
    }

    public void setMicrosoftConnectors(MicrosoftConnectors microsoftConnectors) {
        this.microsoftConnectors = microsoftConnectors;
    }

    public Onedrivebusiness getOnedrivebusiness() {
        return onedrivebusiness;
    }

    public void setOnedrivebusiness(Onedrivebusiness onedrivebusiness) {
        this.onedrivebusiness = onedrivebusiness;
    }

}
