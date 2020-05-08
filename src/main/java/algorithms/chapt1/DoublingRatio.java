package algorithms.chapt1;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class DoublingRatio {
    public double timeTrial(int N, Consumer<int[]> consumer){
        int MAX = 1000000;
        int[] a = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] =  ThreadLocalRandom.current().nextInt(-MAX, MAX);
        }
        StopWatch sw = new StopWatch();
        sw.start();
        consumer.accept(a);
        sw.stop();
        return sw.getTime(TimeUnit.MILLISECONDS);
    }

    public void run(Consumer<int[]> consumer) {
        double prev = timeTrial(125, consumer);

        for(int N = 250; true; N += N) {
            double time = timeTrial(N, consumer);
            System.out.print(String.format("%6d %7.1f ", N, time));
            System.out.println(String.format("%5.1f", time / prev));
            prev = time;
        }
    }
}
