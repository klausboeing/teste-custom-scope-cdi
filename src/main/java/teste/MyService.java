package teste;

import org.jboss.msc.service.Service;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;

import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.inject.spi.CDI;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.lang.IllegalStateException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MyService implements Service<Void> {

    private ScheduledFuture<?> future;

    public void start(final StartContext startContext) throws StartException {
        try {

            ManagedScheduledExecutorService managedScheduledExecutorService = InitialContext.doLookup("java:jboss/ee/concurrency/scheduler/default");


            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println(System.currentTimeMillis());

                    Teste teste = CDI.current().select(Teste.class).get();

                    System.out.println(teste.getTeste());

                }
            };

            future = managedScheduledExecutorService.scheduleWithFixedDelay(task, 1, 6, TimeUnit.SECONDS);
        } catch (Throwable t) {
            throw new StartException(t);
        }
    }

    public void stop(StopContext stopContext) {
    }

    public Void getValue() throws IllegalStateException, IllegalArgumentException {
        return null;
    }
}