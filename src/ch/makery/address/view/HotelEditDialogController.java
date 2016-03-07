package ch.makery.address.view;

import ch.makery.address.model.Hotel;
import ch.makery.address.util.MongoService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.bson.Document;
import org.controlsfx.dialog.Dialogs;

/**
 * Dialog to edit details of a hotel.
 * 
 * @author Marco Jakob
 */
public class HotelEditDialogController {

    @FXML
    private TextField hotelNameField;
    @FXML
    private TextField locationField;


    private Stage dialogStage;
    Hotel hotel;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the hotel to be edited in the dialog.
     *
     * @param hotel
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
        hotelNameField.setText(hotel.getHotelName());
        locationField.setText(hotel.getLocation());

    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            Document tempHotel = hotel;
            hotel.setHotelName(hotelNameField.getText());
            hotel.setLocation(locationField.getText());
            hotel.replace(hotelNameField.getText(), locationField.getText());
            Document newHotel = new Document();
            newHotel.put("hotel", hotel.getHotelName());
            newHotel.put("location",hotel.getLocation());
             MongoService.collection.replaceOne(tempHotel,newHotel);
            setHotel(hotel);



            //MongoService.insertDocument(hotel);
            //MongoService.collection.insertOne(new Document(hotel).append("Hotel",hotel.getHotelName()).append("location",hotel.getLocation()));


            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (hotelNameField.getText() == null || hotelNameField.getText().length() == 0) {
            errorMessage += "No valid hotel name!\n";
        }
        if (locationField.getText() == null || locationField.getText().length() == 0) {
            errorMessage += "No valid location!\n";
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
        	Dialogs.create()
		        .title("Invalid Fields")
		        .masthead("Please correct invalid fields")
		        .message(errorMessage)
		        .showError();
            return false;
        }
    }
}