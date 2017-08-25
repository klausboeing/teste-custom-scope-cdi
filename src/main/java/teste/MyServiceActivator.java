package teste;

import org.jboss.msc.service.*;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import java.util.Set;

/**
 * @author Bob McWhirter
 */
public class MyServiceActivator implements ServiceActivator {


    public void activate(ServiceActivatorContext context) throws ServiceRegistryException {

        System.err.println("activating services");
        ServiceTarget target = context.getServiceTarget();


        target
                .addService(ServiceName.of("my", "service", "1"), new MyService())
                .install();
    }
}