package random.mongostockquoteservice.service;

import random.mongostockquoteservice.domain.QuoteHistory;
import random.mongostockquoteservice.model.Quote;
import reactor.core.publisher.Mono;

public interface QuoteHistoryService {
    Mono<QuoteHistory> saveQuoteToMongo(Quote quote);
}
