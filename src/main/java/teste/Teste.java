package teste;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

//@ApplicationScoped
public class Teste {
    private String teste;

    @PostConstruct
    void init(){
        teste = "Teste 123 " + System.currentTimeMillis();
    }

    public String getTeste() {
        return teste;
    }
}
