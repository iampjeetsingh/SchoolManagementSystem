
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paramjeet Singh
 */
public class P {
    public static String encrypt(String Password){
        Password = Password.replace("a","^").replace("b","~").replace("c","/").replace("d","a").replace("e","b")
                .replace("f","c").replace("g","d").replace("h","e").replace("i","f").replace("j","g").replace("k","h")
                .replace("l","i").replace("m","j").replace("n","k").replace("o","l").replace("p","m").replace("q","n")
                .replace("r","o").replace("s","p").replace("t","q").replace("u","r").replace("v","s").replace("w","t")
                .replace("x","u").replace("y","v").replace("z","w").replace("^","x").replace("~","y").replace("/","z")
                .replace("A","^").replace("B","~").replace("C","/").replace("D","A").replace("E","B").replace("F","C")
                .replace("G","D").replace("H","E").replace("I","F").replace("J","G").replace("K","H").replace("L","I")
                .replace("M","J").replace("N","K").replace("O","L").replace("P","M").replace("Q","N").replace("R","O")
                .replace("S","P").replace("T","Q").replace("U","R").replace("V","S").replace("W","T").replace("X","U")
                .replace("Y","V").replace("Z","W").replace("^","X").replace("~","Y").replace("/","Z").replace("1","^")
                .replace("2","~").replace("3","/").replace("4","1").replace("5","2").replace("6","3").replace("7","4")
                .replace("8","5").replace("9","6").replace("0","7").replace("^","8").replace("~","9").replace("/","0");
        return Password;
    }
    public static String decrypt(String Password){
        Password = Password.replace("z","^").replace("y","~").replace("x","/").replace("w","z").replace("v","y")
                .replace("u","x").replace("t","w").replace("s","v").replace("r","u").replace("q","t").replace("p","s")
                .replace("o","r").replace("n","q").replace("m","p").replace("l","o").replace("k","n").replace("j","m")
                .replace("i","l").replace("h","k").replace("g","j").replace("f","i").replace("e","h").replace("d","g")
                .replace("c","f").replace("b","e").replace("a","d").replace("^","c").replace("~","b").replace("/","a")
                .replace("Z","^").replace("Y","~").replace("X","/").replace("W","Z").replace("V","Y").replace("U","X")
                .replace("T","W").replace("S","V").replace("R","U").replace("Q","T").replace("P","S").replace("O","R")
                .replace("N","Q").replace("M","P").replace("L","O").replace("K","N").replace("J","M").replace("I","L")
                .replace("H","K").replace("G","J").replace("F","I").replace("E","H").replace("D","G").replace("C","F")
                .replace("B","E").replace("A","D").replace("^","C").replace("~","B").replace("/","A").replace("0","^")
                .replace("9","~").replace("8","/").replace("7","0").replace("6","9").replace("5","8").replace("4","7")
                .replace("3","6").replace("2","5").replace("1","4").replace("^","3").replace("~","2").replace("/","1");
        return Password;
    }
    public static int getClassCode(JComboBox clas, JComboBox section){
        String cls = "";
        int clsindex = clas.getSelectedIndex();
        int sectionindex = section.getSelectedIndex();
        if(clsindex==0){
            cls = cls+"1";
        }else if(clsindex==1){
            cls = cls+"2";
        }else if(clsindex==2){
            cls = cls+"3";
        }else if(clsindex==3){
            cls = cls+"4";
        }else if(clsindex==4){
            cls = cls+"5";
        }else if(clsindex==5){
            cls = cls+"6";
        }else if(clsindex==6){
            cls = cls+"7";
        }else if(clsindex==7){
            cls = cls+"8";
        }else if(clsindex==8){
            cls = cls+"9";
        }else if(clsindex==9){
            cls = cls+"10";
        }else if(clsindex==10){
            cls = cls+"11";
        }else if(clsindex==11){
            cls = cls+"12";
        }
        if(sectionindex==0){
            cls = cls+"1";
        }else if(sectionindex==1){
            cls = cls+"2";
        }else if(sectionindex==2){
            cls = cls+"3";
        }
        return Integer.parseInt(cls);
    }
    public static boolean uploadResultsData(String ExamRoll, String ExamCode, String Subject, String Marks, String MaxMarks, String Remark){
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/brjd", "root", "root");
            Statement stmt = con.createStatement();
            String cmd = "INSERT INTO results VALUES("+ExamRoll+","+ExamCode+",\""+Subject+"\","+Marks+","+MaxMarks+",\""+Remark+"\");";
            stmt.execute(cmd);
            stmt.close();
            con.close();
            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Add_User.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Add_User.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
