import config.properties;

import static config.properties.*;


public class App {

    public static void main(String[] args) {
        if (args.length >= 4) {
            dbHost = args[0];
            dbPort = args[1];
            dbUser = args[2];
            dbPassword = args[3];
        }
        System.out.println("From the main class\n" +
                dbHost + " " + dbPort + " " + dbUser + " " + dbPassword);
    }

}
