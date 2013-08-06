package com.springapp.models;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/29/13
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class Appointment {
    private int id;
    private Date StartDateTime;
    private Date EndDateTime;
    private int EncounterId;
    private int ResourcesId;
    private String CommentsText;

    @JsonProperty("id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @JsonProperty("StartDateTime")
    public Date getStartDateTime() {
        return StartDateTime;
    }
    public void setStartDateTime(Date startDateTime) {
        StartDateTime = startDateTime;
    }
    @JsonProperty("EndDateTime")
    public Date getEndDateTime() {
        return EndDateTime;
    }
    public void setEndDateTime(Date endDateTime) {
        EndDateTime = endDateTime;
    }
    @JsonProperty("EncounterId")
    public int getEncounterId() {
        return EncounterId;
    }
    public void setEncounterId(int encounterId) {
        EncounterId = encounterId;
    }
    @JsonProperty("ResourcesId")
    public int getResourcesId(){
        return ResourcesId;
    }
    public void setResourcesId(int resourcesId) {
        ResourcesId = resourcesId;
    }
    @JsonProperty("CommentsText")
    public String getCommentsText() {
        return CommentsText;
    }
    public void setCommentsText(String commentsText) {
        CommentsText = commentsText;
    }
}
