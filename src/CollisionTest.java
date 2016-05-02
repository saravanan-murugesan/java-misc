
import java.time.Instant;
import java.util.*;

class IdGenerator {

    public String generate() {
        try {
            String index = String.valueOf(Instant.now().getEpochSecond()) + String.valueOf(new Random().nextInt(999));
            return index;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}

public class CollisionTest {

    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("test"));
//        int parallelCukes = 160;
//        int totalCollision = 0;
//        for (int i = 0; i < 1000; i++) {
//            totalCollision += testCollision(parallelCukes);
//        }
//        System.out.println("Average collision rate: " + (totalCollision * 100 / (1000 * parallelCukes)) + " %");

    }

    public static int testCollision(int threadCount) throws Exception {
        Thread[] threads = new Thread[threadCount];
        Set<String> generatedIds = Collections.synchronizedSet(new HashSet<>());
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    IdGenerator generator = new IdGenerator();
                    String id = generator.generate();
                    generatedIds.add(id);
                }
            };
        }

        for (Thread t : threads) {
            t.start();
            t.join();
        }

        System.out.println("Total ids generated in 1000ms: " + threadCount
                + " Collision: " + (threadCount - generatedIds.size()));
        return threadCount - generatedIds.size();
    }
}
