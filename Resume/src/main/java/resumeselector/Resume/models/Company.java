package resumeselector.Resume.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    private ObjectId id;
    private String companyName;
    private String username;
    private String password;
    private String location;
    private List<Jobs> openings;

    public Company(String companyName, String username, String password, String location, List<Jobs> openings) {
        this.companyName = companyName;
        this.username = username;
        this.password = password;
        this.location = location;
        this.openings = openings;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", openings=" + openings +
                '}';
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Jobs> getOpenings() {
        return openings;
    }

    public void setOpenings(List<Jobs> openings) {
        this.openings = openings;
    }

}