package dagbok;

import java.sql.*;
import java.util.Scanner;

public class Registrer extends DBConn {

    DBConn con;

    private void registrer(String navn, String query){
        try {
            Statement st = con.con.createStatement();
            st.executeUpdate(query);
            System.out.println(navn + " REGISRERT.");
            st.close();
        }
        catch(SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }
    }


    public void chooseRegister(DBConn dbConn){
        con = dbConn;
        Scanner scanner = new Scanner(System.in);

        System.out.println("HVA VIL DU REGISTRERE? \n"
                + "***************************\n"
                + "1: \t Registrering av treningsøkt. \n"
                + "2: \t Registrering av øvelse. \n"
                + "3: \t Registrering av apparat. \n"
                + "***************************");

        int valg = scanner.nextInt();
        String query;
        switch(valg){
            case(1):
                System.out.println("----REGISTRERING AV TRENINGSØKT---- \n"
                    + "Før inn:");
                System.out.println("TreningssenterID: ");
                int treningssenterID = scanner.nextInt();
                System.out.println("Starttidspunkt (YYYY-MM-DD HH:MM:SS): ");
                String startTidsPunkt = scanner.next();
                startTidsPunkt += scanner.nextLine();
                System.out.println("Lengde: ");
                int lengde = scanner.nextInt();
                System.out.println("Notat: ");
                String notat = scanner.next();
                notat += scanner.nextLine();
                System.out.println("Personlig form: ");
                int form = scanner.nextInt();
                System.out.println("Prestasjon: ");
                int prestasjon = scanner.nextInt();

                query = "INSERT INTO økt (Treningssenter_id, tid_start, tid_lengde, notat, personlig_form, prestasjon) VALUES(" + treningssenterID + ", '" + startTidsPunkt + "', " +
                        lengde + ", '" + notat + "', " + form + ", " + prestasjon +")";
                registrer("TRENINGSØKT", query);
                break;
            case(2):
                System.out.println("----REGISTRERING AV ØVELSE---- \n"
                        + "Før inn:");
                System.out.println("Navn på øvelse: ");
                String navn = scanner.next();
                navn+= scanner.nextLine();

                query = "INSERT INTO øvelse (navn) VALUES('" + navn + "')";
                registrer("ØVELSE", query);
                break;
            case(3):
                System.out.println("----REGISTRERING AV APPARATTYPE---- \n"
                        + "Før inn:");
                System.out.println("Navn på apparat: ");
                String apparatNavn = scanner.next();
                apparatNavn += scanner.nextLine();
                System.out.println("Beskrivelse av apparat: ");
                String beskrivelse = scanner.next();
                beskrivelse += scanner.nextLine();

                query = "INSERT INTO apparattype (navn, beskrivelse) VALUES('" + apparatNavn + "','" + beskrivelse + "')";
                registrer("APPARATTYPE", query);
                break;
        }
    }

}
