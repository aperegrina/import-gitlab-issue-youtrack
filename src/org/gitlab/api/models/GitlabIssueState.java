package org.gitlab.api.models;

/**
 * Created by andre on 5/13/16.
 */
public enum GitlabIssueState {
    STATECLOSED("closed"),
    STATEOPENED("opened");
    private final String type;

    GitlabIssueState (String type) {
        this.type = type;
    }


    public String getType() { return type; }
 }
