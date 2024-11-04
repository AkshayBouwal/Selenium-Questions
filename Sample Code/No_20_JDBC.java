package Questions;

import java.sql.*;

public class No_20_JDBC {


    public static void main(String[] args) {

        Connection con = null;

        String connectionURL = "jdbc:mysql://127.0.0.1:3306/database1";

        try {

            con = DriverManager.getConnection(connectionURL, " Enter User Name ", "Enter Password");

        } catch (SQLException e) {
            System.out.println("Issue in SQL Connection");
        }

        Statement s = null;

        try {
            s = con.createStatement();

            ResultSet output = s.executeQuery("select * from Personal_Table where Base_ID = 14092024");

            while (output.next()) {

                System.out.println(output.getString("First_Name"));
                System.out.println(output.getString("Last_Name"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
