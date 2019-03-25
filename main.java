package dagbok;
import java.sql.*;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws Exception{

        DBConn DBCon  = new DBConn();
        DBCon.connect();
        Scanner scanner = new Scanner(System.in);

        System.out.println("----TRENINGSDAGBOK----");

        boolean finished = false;
        while(!finished){
            System.out.println("\nVELG HVA DU VIL GJØRE: \n"
                    + "***************************\n"
                    + "1: \t Registrering av treningsøkt, øvelse eller apparat. \n"
                    + "2: \t Hent ut informasjon om de n siste treningsøktene. \n"
                    + "3: \t Se resultatloggen fra enkeltøvelser i et gitt tidsintervall \n"
                    + "4: \t Opprette nye øvelsegruppe og finne øvelser som er i samme gruppe \n"
                    + "5: \t Hent ut gjennomsnittsformen over et gitt tidsintervall \n"
                    + "0: \t Avslutt Treningsdagboken din\n"
                    + "***************************" );

            int valg = scanner.nextInt();

            switch(valg){
                case(0):
                    System.out.println("Treningsdagbok avsluttet");
                    finished = true;
                    break;
                case(1):
                    Registrer reg = new Registrer();
                    reg.chooseRegister(DBCon);
                case(2):
                    sisteØkter sØ = new sisteØkter();
                    sØ.chooseHowMany(DBCon);
                }

            }


        /*String query = "select * from treningssenter";
        Statement st = DBCon.con.createStatement();
        ResultSet rs = st.executeQuery(query);

        rs.next();
        String name = rs.getString("lokasjon");
        System.out.println(name);*/

        //st.close();
        DBCon.con.close();
    }

}
