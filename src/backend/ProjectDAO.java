package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ProjectDAO {

    public static void saveProject(String path, Project project) {
        try {
            FileOutputStream fileStream = new FileOutputStream(new File(path));
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

            objectStream.writeObject(project);

            fileStream.close();
            objectStream.close();

            System.out.println("salvou");

        } catch (Exception err) {
            System.err.println("Erro!:" + err);
        }
    }

    public static Project loadProject(String path) {
        try {
            FileInputStream fileStream = new FileInputStream(new File(path));
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);

            Project project = (Project) objectStream.readObject();

            fileStream.close();
            objectStream.close();

            System.out.println("Carregou");

            return project;

        } catch (Exception err) {
            System.err.println("Erro!:" + err);
            return new Project();
        }
    }

}
