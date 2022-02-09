import backend.Backend;
import frontend.Frontend;

public class App {

    public static void main(String[] args) throws Exception {
        Backend backend = new Backend();
        Frontend frontend = new Frontend(backend);

        frontend.run();
    }

}
