package dagbok;

import java.sql.*;
import java.util.Scanner;

public class sisteØkter {

    DBConn con;

    public void chooseHowMany(DBConn dbcon){
        con = dbcon;
        Scanner scanner = new Scanner(System.in);

        System.out.println("HVOR MANGE ØKTER VIL DU SE?");
        int antall = scanner.nextInt();

        printWorkout(antall);

    }

    private void printWorkout(int antall){
        String query = "SELECT * FROM økt";
        try {
            Statement st = con.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                int treningssenterID = rs.getInt("Treningssenter_id");
                String startTidspunkt = rs.getString("tid_start");
                int lengde = rs.getInt("tid_lengde");
                String notat = rs.getString("notat");
                int form = rs.getInt("personlig_form");
                int prestasjon = rs.getInt("prestasjon");
                System.out.println(id + treningssenterID +  startTidspunkt + lengde + notat + form + prestasjon);
            }
        }
        catch(SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }
    }

}
