package frontend;

import backend.Bakery;

public class Frontend {

    private Bakery backend;

    public Frontend(Bakery backend) {
        this.setBackend(backend);
    }

    public void run() {
        MainWindow mainWindow = new MainWindow(this.getBackend());
        mainWindow.run();
    }

    // Setters ----------------------------------------------------------------
    private void setBackend(Bakery backend) {
        this.backend = backend;
    }

    // Getters ----------------------------------------------------------------
    private Bakery getBackend() {
        return this.backend;
    }

}
