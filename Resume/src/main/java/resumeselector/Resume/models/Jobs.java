package resumeselector.Resume.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jobs {
    @Id
    private ObjectId id;
    private String jobId;
    private String companyName;

    public Jobs(String jobId, String companyName, String description, String position, double salary, int numberOfOpenPositions, int experienceRequiredInYears, String qualificationRequired, List<Map<String, Object>> primarySkills, List<Map<String, Object>> highPrioritySkills, List<Map<String, Object>> mediumPrioritySkills, List<Map<String, Object>> lowPrioritySkills, List<String> applicants, List<Scores> scoresList) {
        this.jobId = jobId;
        this.companyName = companyName;
        this.description = description;
        this.position = position;
        Salary = salary;
        this.numberOfOpenPositions = numberOfOpenPositions;
        this.experienceRequiredInYears = experienceRequiredInYears;
        this.qualificationRequired = qualificationRequired;
        this.primarySkills = primarySkills;
        this.highPrioritySkills = highPrioritySkills;
        this.mediumPrioritySkills = mediumPrioritySkills;
        this.lowPrioritySkills = lowPrioritySkills;
        this.applicants = applicants;
        this.scoresList = scoresList;
    }

    private String description;
    private String position;
    private double Salary;
    private int numberOfOpenPositions;
    private int experienceRequiredInYears;
    private String qualificationRequired;
    private List<Map<String, Object>> primarySkills;
    private List<Map<String, Object>> highPrioritySkills;
    private List<Map<String, Object>> mediumPrioritySkills;
    private List<Map<String, Object>> lowPrioritySkills;
    private List<String> applicants;
    private List<Scores> scoresList;


}
