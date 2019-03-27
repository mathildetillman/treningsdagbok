import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreningsLogg extends DBConn{

    Statement statement=null;
    ArrayList<String> values=new ArrayList<>(6);

    private static String padRight(String s) {
        return String.format("%-30s", s);
    }

    private String createHeader(){
        String output="";
        values.add("Tidspunkt");values.add("Lengde");values.add("Personelig form");values.add("Prestasjon");
        for (String value : values){
            output+=padRight(value);
        }
        return output;
    }

        public void getTreningsLogg(Connection conn,String ovelsenavn, String start,String end,Boolean ascending){
            String sortby=ascending?"ASC":"DESC";
            String query="SELECT tidspunkt, navn,  ";
            try{
                statement=conn.createStatement();
                ResultSet rs=statement.executeQuery(query);
                System.out.println(createHeader());
                while (rs.next()){
                    Timestamp Tidspunkt=rs.getTimestamp("tidspunkt");
                    int Lengde=rs.getString("tid_lengde");
                    int form=rs.getInt("form");
                    int prestasjon=rs.getInt("prestasjon");
    
                    String output=(Tidspunkt.toString()+ padRight(Integer.toString(Lengde)+Integer.toString(form)+ toString(prestasjon)
                    System.out.println(output));
                    }
            
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
    

    