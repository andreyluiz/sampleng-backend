package ungp.sampleng.backend.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ungp.sampleng.backend.repository.ProprietarioRepository;
import ungp.sampleng.backend.repository.VeiculoRepository;

public class Application {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        if( applicationContext == null ) {
            applicationContext =
                    new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        }

        return applicationContext;
    }

    public static <T> T getRepository(Class<T> repoClass) {
        return getApplicationContext().getBean(repoClass);
    }

    public static VeiculoRepository getVeiculoRepository() {
        return getRepository(VeiculoRepository.class);
    }

    public static ProprietarioRepository getProprietarioRepository() {
        return getRepository(ProprietarioRepository.class);
    }
}
