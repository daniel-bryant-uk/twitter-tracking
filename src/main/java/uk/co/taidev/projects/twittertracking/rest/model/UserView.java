package uk.co.taidev.projects.twittertracking.rest.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UserView {

    private String id;
    private String firstName;
    private String surname;
    private String emailAddress;
    private String infoAuthorPage;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getInfoAuthorPage() {
        return infoAuthorPage;
    }

    public void setInfoAuthorPage(String infoAuthorPage) {
        this.infoAuthorPage = infoAuthorPage;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
