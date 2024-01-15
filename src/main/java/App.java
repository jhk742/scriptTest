import config.properties;

import java.sql.*;

import static config.properties.*;




public class App {

    private static String AWSRDS_endpoint = "test-1.cfuygiu08mdn.ap-northeast-2.rds.amazonaws.com";
    private static String AWSRDS_username = "root";
    private static String AWSRDS_password = "Kjhyeong0219!";
    public static void main(String[] args) {
        if (args.length >= 4) {
            dbHost = args[0];
            dbPort = args[1];
            dbUser = args[2];
            dbPassword = args[3];
        }
        System.out.println("From the main class\n" +
                dbHost + " " + dbPort + " " + dbUser + " " + dbPassword);


        String jdbcUrl = "jdbc:mysql://" + AWSRDS_endpoint + "/test_schema";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, AWSRDS_username, AWSRDS_password);
            PreparedStatement ps = connection.prepareStatement("select * from employee");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getString("emp_id") + "\nEmployee Name: " + rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

}
