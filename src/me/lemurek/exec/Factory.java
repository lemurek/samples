package me.lemurek.exec;

import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Factory {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        Collection<LazyAss> coders = IntStream
                .iterate(1, i -> i + 1)
                .limit(3)
                .mapToObj(LazyAss::new)
                .peek(newHire -> executorService.scheduleAtFixedRate(newHire, 1, 1, TimeUnit.SECONDS))
                .collect(Collectors.toList());

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Overlord(coders), 1, 1, TimeUnit.SECONDS);

    }

}
