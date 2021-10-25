package random.netflux.domain;

import com.mongodb.lang.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Movie {

    private String id;

    @NonNull
    private String title;

    public Movie(String title) {
        this.title = title;
    }
}
