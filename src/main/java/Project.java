import java.io.IOException;

public class Project {
    public static void main(String[] args) {
        try {
            new Game(40, 20).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
