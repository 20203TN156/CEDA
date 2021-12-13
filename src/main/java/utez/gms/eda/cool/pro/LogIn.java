package utez.gms.eda.cool.pro;

import utez.gms.eda.cool.Final;
import utez.gms.eda.cool.bean.BeanUser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static utez.gms.eda.cool.Conexion.getConnection;

public class LogIn {

    User suer = new User();

    public boolean validate(BeanUser beanUser) throws SQLException {

        boolean status;

        PreparedStatement preparedStatement = getConnection().prepareStatement(
                "select * from user where user = ? and password = ? ");
        preparedStatement.setString(1, beanUser.getUser());
        preparedStatement.setString(2, beanUser.getPassword());
        ResultSet rs = preparedStatement.executeQuery();
        status = rs.next();
        return status;
    }

    public void printLogIng() throws SQLException {
        String user, password;
        LogIn logIn = new LogIn();
        Scanner print = new Scanner(System.in);
        for (int i = 0; i <= 2; i++) {

            System.out.println("****Iniciar Sesión****");
            System.out.print("Usuario: ");
            user = print.next();
            System.out.print("Contraseña: ");
            password = print.next();
            BeanUser beanUser = new BeanUser(user, password);

            if (logIn.validate(beanUser) == true) {
                System.out.println("Hola, " + beanUser.getUser());
                Final finalXD = new Final();
                finalXD.finalPrint();
                i = 4;
            } else {
                System.out.println("Usuario o contraseña incorrecto");
                System.out.println("Llevas " + (i+1) + " intentos");
            }
        }
    }
}
