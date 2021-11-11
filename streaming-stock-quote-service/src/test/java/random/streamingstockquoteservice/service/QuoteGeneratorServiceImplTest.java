package random.streamingstockquoteservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import random.streamingstockquoteservice.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

class QuoteGeneratorServiceImplTest {

    private QuoteGeneratorService service;

    @BeforeEach
    void setUp() {
        service = new QuoteGeneratorServiceImpl();
    }

    @Test
    void fetchQuoteStream() throws InterruptedException {
        Flux<Quote> quotesFlux = service.fetchQuoteStream(Duration.ofMillis(100L));

        Consumer<Quote> quoteConsumer = System.out::println;
        Consumer<Throwable> throwableConsumer = e -> System.out.println(e.getMessage());
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable done = countDownLatch::countDown;
        // Runnable done = () -> countDownLatch.countDown();

        quotesFlux.take(30)
                .subscribe(quoteConsumer, throwableConsumer, done);

        countDownLatch.await();
    }
}
