package resumeselector.Resume.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Queue;

@Document(collection = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOpenings {
    @Id
    private ObjectId id;
    private String jobId;
    private String companyName;
    private String description;
    private String position;
    private double Salary;
    private int numberOfOpenPositions;
    private int experienceRequiredInYears;
    private String qualificationRequired;
    private List<String> primarySkills;
    private List<String> highPrioritySkills;
    private List<String> mediumPrioritySkills;
    private List<String> lowPrioritySkills;
    private List<String> applicants;
}
