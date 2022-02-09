package backend;

public class Backend {

    private Project project;

    public Backend() {
        this.setProject(new Project());
    }

    // Setters-----------------------------------------------------------------
    private void setProject(Project project) {
        this.project = project;
    }

    // Getters ----------------------------------------------------------------
    public Project getProject() {
        System.out.println("project getted");
        return this.project;
    }

}
