package dev.kartikbvarma.features.jdk9.concurrency;

import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlowExample {

    public static void main(String[] args) {

        // A stream of data to be published
        List<Integer> numbers = IntStream.range(1, 21)
                .boxed()
                .collect(Collectors.toList());

        // A new publisher for an async delivery to subscribers
        try (SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>()) {
            // set the subscriber
            publisher.subscribe(new NumberSubscriber());

            //submit data from stream to the publisher
            numbers.forEach(number -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                publisher.submit(number);
            });
        }
    }

    /**
     * A class representing a subscriber that will use the {@link Subscription}.
     */
    public static class NumberSubscriber implements Subscriber<Integer> {

        private Subscription subscription;

        @Override
        public void onSubscribe(Subscription subscription) {
            this.subscription = subscription;
            subscription.request(1);
        }

        @Override
        public void onNext(Integer item) {
            System.out.println(item);
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.println("Done 🥳");
        }
    }
}
