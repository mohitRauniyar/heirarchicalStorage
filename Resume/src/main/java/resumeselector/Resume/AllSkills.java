package resumeselector.Resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "allskills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllSkills {
    @Id
    private ObjectId id;
    private List<String> skill;
}
