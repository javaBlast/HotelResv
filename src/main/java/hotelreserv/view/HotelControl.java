package hotelreserv.view;

import hotelreserv.MainApp;
import hotelreserv.model.Hotel;
import hotelreserv.util.MongoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.bson.Document;
import org.controlsfx.dialog.Dialogs;

/**
 * Created by Blast on 07.03.2016.
 */
public class HotelControl {
    @FXML
    private TableView<Hotel> hotelTable;
    @FXML
    private TableColumn<Hotel, String> hotelNameColumn;

    @FXML
    private Label hotelNameLabel;
    @FXML
    private Label locationLabel;

    private MainApp mainApp;

    public HotelControl() {
    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        hotelNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().hotelNameProperty());


        // Clear person details.
        showHotelDetails(null);

        // Listen for selection changes and show the person details when changed.
        hotelTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showHotelDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        hotelTable.setItems(mainApp.getHotelData());
    }

    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param hotel the person or null
     */
    private void showHotelDetails(Hotel hotel) {
        if (hotel != null) {
            // Fill the labels with info from the person object.
            hotelNameLabel.setText(hotel.getHotelName());
            locationLabel.setText(hotel.getLocation());
        } else {
            // Hotel is null, remove all the text.
            hotelNameLabel.setText("");
            locationLabel.setText("");
        }
    }


    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteHotel(ActionEvent event) {
        int selectedIndex = hotelTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            hotelTable.getItems().remove(selectedIndex);
            MongoService.collection.deleteOne(hotelTable.getSelectionModel().getSelectedItem());
        } else {
            // Nothing selected.
            Dialogs.create()
                    .title("No Selection")
                    .masthead("No Person Selected")
                    .message("Please select a person in the table.")
                    .showWarning();
        }
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewHotel() {
        Hotel hotel = new Hotel();
        boolean okClicked = mainApp.showHotelEditDialog(hotel);
        if (okClicked) {
            MongoService.collection.insertOne(new Document(hotel).append("hotel", hotel.getHotelName()).append("location", hotel.getLocation()));
            mainApp.getHotelData().add(hotel);

        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditHotel() {
        Hotel selectedHotels = hotelTable.getSelectionModel().getSelectedItem();
        if (selectedHotels != null) {
            boolean okClicked = mainApp.showHotelEditDialog(selectedHotels);
            if (okClicked) {
                showHotelDetails(selectedHotels);
            } else {
                // Nothing selected.
                Dialogs.create()
                        .title("No Selection")
                        .masthead("No Person Selected")
                        .message("Please select a person in the table.")
                        .showWarning();
            }
        }
    }
}
