package resumeselector.Resume.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Document(collection = "candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    @Id
    private ObjectId id;
    private String username;
    private String candidateName;
    private String password;
    private List<String> skills;
    private List<String> appliedJobs;
    private int experience; // Corrected typo here




    public Candidate(String username, String candidateName, String password, List<String> skills, List<String> appliedJobs, int experience) {
        this.username = username;
        this.candidateName = candidateName;
        this.password = password;
        this.skills = skills;
        this.appliedJobs = appliedJobs;
        this.experience = experience;
    }

    // Getter and Setter for experience
    public int getExperience() { // Corrected getter
        return experience;
    }

    public void setExperience(int experience) { // Corrected setter
        this.experience = experience;
    }

    // Other getters and setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(List<String> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }
}
