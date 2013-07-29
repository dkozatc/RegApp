package com.springapp.models;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.stereotype.Component;

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
    private String StartDateTime;
    private String EndDateTime;
    private int ResourceId;
    private String CommentsText;

    @JsonProperty("id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @JsonProperty("StartDateTime")
    public String getStartDateTime() {
        return StartDateTime;
    }
    public void setStartDateTime(String startDateTime) {
        StartDateTime = startDateTime;
    }
    @JsonProperty("EndDateTime")
    public String getEndDateTime() {
        return EndDateTime;
    }
    public void setEndDateTime(String endDateTime) {
        EndDateTime = endDateTime;
    }
    @JsonProperty("ResourceId")
    public int getResourceId() {
        return ResourceId;
    }
    public void setResourceId(int resourceId) {
        ResourceId = resourceId;
    }
    @JsonProperty("CommentsText")
    public String getCommentsText() {
        return CommentsText;
    }
    public void setCommentsText(String commentsText) {
        CommentsText = commentsText;
    }
}
