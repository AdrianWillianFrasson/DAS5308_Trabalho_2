// UFSC - DAS5308 - Trabalho Java
// Adrian Willian Frasson (20100659)

import backend.Backend;
import frontend.Frontend;

public class App {

    public static void main(String[] args) throws Exception {
        Backend backend = new Backend();
        Frontend frontend = new Frontend(backend);

        frontend.run();
    }

}
