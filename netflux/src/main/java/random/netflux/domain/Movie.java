package random.netflux.domain;

import com.mongodb.lang.NonNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Movie {

    private String id;

    @NonNull
    private String title;
}
