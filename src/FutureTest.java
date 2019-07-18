import com.google.common.util.concurrent.*;
import com.sun.istack.internal.Nullable;


import java.util.concurrent.Executors;

public class FutureTest {

    public static void main(String[] args) {
        final FutureTest futureTest = new FutureTest();
        futureTest.testFuture();
    }

    private void testFuture() {

        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));


        ListenableFuture<Explosion> explosion = service.submit(() -> {
            System.out.println("We are here!!!");
            return new Explosion();
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Futures.addCallback(explosion, new FutureCallback<Explosion>() {
            @Override
            public void onSuccess(@Nullable Explosion explosion) {
                System.out.println("Got the explosion ...");
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Failed with an exception ...");
            }
        });

    }


    private class Explosion {

        public void processExplosion() {
            System.out.println("Processing the explosion ...");
        }
    }
}
