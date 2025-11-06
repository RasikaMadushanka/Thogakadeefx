package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

   public TextField txtUserName;
   public TextField txtUserPassword;

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        Stage stage=new Stage();
        String UserName=txtUserName.getText();
        String password=txtUserPassword.getText();

        System.out.println("Username :" + UserName);
        System.out.println("Password :" + password);
        if (UserName.equals("Rasika")&& password.equals("2005")){
            System.out.println("Login Sucessful");
            try {


                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Dashboard_Form.fxml"))));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("Login Failed");


            txtUserName.clear();
            txtUserPassword.clear();

        }
    }

}
