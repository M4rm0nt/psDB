import java.io.File;
import java.util.ArrayList;

public class Stop {
    public static void main(String[] args) throws Exception {
        System.out.println("### Stopping PostgreSQL Database...");

        var commandLine = new ArrayList<String>();
        commandLine.add("docker");
        commandLine.add("compose");
        commandLine.add("down");

        System.out.printf("Running command: %s%n", String.join(" ", commandLine));

        var pb = new ProcessBuilder(commandLine);
        pb.directory(new File("."));
        pb.inheritIO();
        var process = pb.start();
        var exitCode = process.waitFor();

        System.out.println("Stopped");

        System.exit(exitCode);
    }
}
