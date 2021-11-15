package random.mongostockquoteservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import random.mongostockquoteservice.domain.QuoteHistory;
import random.mongostockquoteservice.model.Quote;
import random.mongostockquoteservice.repositories.QuoteHistoryRepository;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QuoteHistoryServiceImpl implements QuoteHistoryService {

    private final QuoteHistoryRepository repository;

    @Override
    public Mono<QuoteHistory> saveQuoteToMongo(Quote quote) {
        return repository.save(QuoteHistory.builder()
                .ticker(quote.getTicker())
                .price(quote.getPrice())
                .instant(quote.getInstant())
                .build());
    }
}
