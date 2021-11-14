package random.mongostockquoteservice.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import random.mongostockquoteservice.domain.QuoteHistory;

public interface QuoteHistoryRepository extends ReactiveMongoRepository<QuoteHistory, String> {
}
