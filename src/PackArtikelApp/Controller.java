package PackArtikelApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller extends Application {

    @FXML
    private TextField articleTextField;

    @FXML
    private TextField wordTextField;

    private NounFinder theNounFinder = new NounFinder();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainScreenFXML.fxml"));
        primaryStage.setTitle("ArtikelApp");
        primaryStage.setScene(new Scene(root, 350, 200));
        theNounFinder.loadHashMap();
        primaryStage.show();
    }

    @FXML
    private void setGoButton(ActionEvent e){
        if(!wordTextField.getText().equalsIgnoreCase("")) {
            articleTextField.setText(theNounFinder.getArticle(wordTextField.getText()));
            formatText();
        }
    };

    private void formatText(){
        String formattedInput = wordTextField.getText().substring(0, 1).toUpperCase() +
                wordTextField.getText().substring(1).toLowerCase();
        wordTextField.setText(formattedInput);
    }

    @FXML
    private void setClearButton(ActionEvent e){
        articleTextField.clear();
        wordTextField.clear();
    }

    @FXML
    private void writeCharacter(ActionEvent e) {
        MenuItem mi = (MenuItem) e.getSource();
        String character = mi.getText();

        switch (character) {
            case "ä":
                wordTextField.setText(wordTextField.getText() + "ä");
                break;
            case "ö":
                wordTextField.setText(wordTextField.getText() + "ö");
                break;
            case "ü":
                wordTextField.setText(wordTextField.getText() + "ü");
                break;
            case "ß":
                wordTextField.setText(wordTextField.getText() + "ß");
                break;
        }

    }
}


