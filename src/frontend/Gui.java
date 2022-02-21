package frontend;

import backend.Bakery;

public class Gui {

    private Bakery bakery;

    public Gui(Bakery bakery) {
        this.setBakery(bakery);
    }

    public void run() {
        MainWindow mainWindow = new MainWindow(this.getBakery());
        mainWindow.run();
    }

    // Setters ----------------------------------------------------------------
    private void setBakery(Bakery bakery) {
        this.bakery = bakery;
    }

    // Getters ----------------------------------------------------------------
    private Bakery getBakery() {
        return this.bakery;
    }

}
