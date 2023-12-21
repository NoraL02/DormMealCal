import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
/**
 * TheJavaFX class DormMealCal calculate the total charges of dorm cost and meal plan cost.
 *
 * Ngoc Lai
 * 
 */
public class DormMealCalculator extends Application 
{
    private ComboBox<String> dormComboBox;
    private ComboBox<String> mealComboBox;
    private Label resultLabel;
    
    private String[] dormNames = {"Allen Hall", "Pike Hall", "Farthing Hall", "University Suites"};
    private int[] dormCosts= {1800, 2200, 2800, 3000};
    
    private String[] mealPlans = {"7 meals per week","14 meals per week", "Unlimited meals"};
    private int[] mealCosts = {600,1100,1800};
    
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        // Create ComboBox for dormitories.
        dormComboBox = new ComboBox<>();
        dormComboBox.getItems().addAll(dormNames);
        
        // Create a Label for dormitories.
        Label nameLabel = new Label("Select a dormitory");
        
        // Create ComboBox for meal plans.
        mealComboBox = new ComboBox<>();
        mealComboBox.getItems().addAll(mealPlans);
        
        //Create Label for meal plans.
        Label planLabel = new Label("Select a meal plan");
        
        // Create Button to calculate total charges
        Button calButton = new Button("Calculate");
        calButton.setOnAction(new CalButtonHandler());

        // Create an empty Label to display total charges
        resultLabel = new Label();

        // Put the ComboBoxes and the Button in an HBox
        HBox hbox = new HBox(10, nameLabel, dormComboBox, planLabel, mealComboBox, calButton);

        // Put the HBox, totalLabel in a VBox
        VBox vbox = new VBox(10, hbox, resultLabel);

        // Set the VBox's alignment to center
        vbox.setAlignment(Pos.CENTER);

        // Set the VBox's padding to 10 pixels
        vbox.setPadding(new Insets(10));

        // Create a Scene
        Scene scene = new Scene(vbox);

        // Add the Scene to the Stage
        primaryStage.setScene(scene);

        // Set the stage title
        primaryStage.setTitle("Dorm and Meal Plan Calculator");

        // Show the window
        primaryStage.show();
    }

    /*
     * Event handler class for calButton
     */
    class CalButtonHandler implements EventHandler<ActionEvent> 
    {
        @Override
        public void handle(ActionEvent event) 
        {
            // choose dorm and meal plan.
            String selectedDorm = dormComboBox.getValue();
            String selectedMealPlan = mealComboBox.getValue();
            
            // Get cost for selected dorm and meal plan.
             int dormCost = dormCosts[dormComboBox.getSelectionModel().getSelectedIndex()];
            int mealPlanCost = mealCosts[mealComboBox.getSelectionModel().getSelectedIndex()];
            
            // Calculate total cost.
            int totalCharges = dormCost + mealPlanCost;
            
            //Display result.
            resultLabel.setText("Total Charges: $" + totalCharges + " per semester");
        }
    }
}
