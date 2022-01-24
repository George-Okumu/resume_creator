package models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Resume {
    private String title;
    private String companyName;
    private String location;
    private String description;

    //Arraylist to store  instance of resumes
    private static ArrayList<Resume> resumeCreated = new ArrayList<Resume>();

    public Resume(String title, String companyName, String location, String description) {
        this.title = title;
        this.companyName = companyName;
        this.location = location;
        this.description = description;
        resumeCreated.add(this);
    }

    public String getTitle() {
        return title;
    }

    public static ArrayList<Resume> getResumeCreated() {
        return resumeCreated;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
