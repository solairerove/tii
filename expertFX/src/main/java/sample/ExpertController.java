package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;

public class ExpertController {
    public Label question;

    private Data data;

    @FXML
    public void initialize() throws FileNotFoundException {
        data = Expert.init();
        question.setText("Has it got " + data.getCharacteristics().get(data.getMinIndex()) + "?");
    }

    public void calculate(ActionEvent actionEvent) throws FileNotFoundException {
        Button button = (Button) actionEvent.getSource();
        if(data.getCharacteristics().size() > 1 && data.getSubjects().size() > 1) {
            String result = data.calculate(button.getText());
            question.setText(result);
        }
    }

    public void clear(ActionEvent actionEvent) throws FileNotFoundException {
        initialize();
    }

    @FXML
    void nextPane(ActionEvent event) {
        ViewNavigator.loadView(ViewNavigator.INPUT);
    }
}
