package utez.gms.eda.cool.pro;

import utez.gms.eda.cool.bean.BeanUser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static utez.gms.eda.cool.Conexion.getConnection;

public class LogIn {

    public boolean validate(BeanUser beanUser) throws SQLException {

        boolean status = false;

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

        System.out.println("****Iniciar Sesión****");
        System.out.print("Usuario: ");
        user = print.next();
        System.out.print("Contraseña: ");
        password = print.next();
        BeanUser beanUser = new BeanUser(user, password);

        if(logIn.validate(beanUser) == true){
            System.out.println("Bienvenido, " + beanUser.getUser());
        } else{
            System.out.println("Huevos");
        }
    }
}
