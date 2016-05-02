import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by saravm on 4/25/16.
 */
public class ThreadTest {
    public static void main(String[] args) {
//        String []yids = new String[] {
//                "id_1461357087662",
//                "id_1461357101301",
//                "id_1461357111543",
//                "id_1461357126347",
//                "id_1461357134844",
//                "id_1461357143161",
//                "id_1461357152562",
//                "id_1461357165817",
//                "id_1461357173208",
//                "id_1461357184405"};


        final String key = "key";
        final String value = "value";
        Set<String> keys = new HashSet<>();
        keys.add(key);

        AtomicInteger errorCount = new AtomicInteger(0);
        AtomicInteger totalCount = new AtomicInteger(0);

        final int numThreads = 10;

        Thread[] threads = new Thread[numThreads];

        for (int i=0; i<numThreads; i++) {

            Map<String, String> dataMapWrite = new HashMap<>();
            final String[] yids = new String[]{"id_1461357087662", "id_1461357101301", "id_1461357111543", "id_1461357126347", "id_1461357134844", "id_1461357143161", "id_1461357152562", "id_1461357165817", "id_1461357173208", "id_1461357184405"};

            final String yid = yids[i];

            threads[i] = new Thread() {
                @Override
                public void run() {
                        try {
                            Thread.sleep(1000);
                            System.out.println(yid);
                        } catch ( InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

            };
            threads[i].start();
        }



        for(int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total set/get requests made = " + totalCount.toString());
        System.out.println("Total sync errors " + errorCount.toString());

    }
}
