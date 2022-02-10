package frontend;

import backend.Backend;

public class Frontend {

    private Backend backend;

    public Frontend(Backend backend) {
        this.setBackend(backend);
    }

    public void run() {
        MainWindow mainWindow = new MainWindow(this.getBackend());
        mainWindow.run();
    }

    // Setters-----------------------------------------------------------------
    private void setBackend(Backend backend) {
        this.backend = backend;
    }

    // Getters ----------------------------------------------------------------
    private Backend getBackend() {
        return this.backend;
    }

}
