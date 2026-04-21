package com.effortcure.controller;

import com.effortcure.util.ViewUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextFlow;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.image.ImageView;
import javafx.scene.control.Separator;


public class  BubbleSessionsController{
    
    @FXML
    private AnchorPane root;

    @FXML
     private ImageView bubble1;
    @FXML
     private ImageView bubble2;
    @FXML
     private ImageView bubble3;
    @FXML
     private ImageView bubble4;

    @FXML
     private Pane searchpane;
    @FXML
     private Separator separator;
    @FXML
     private ImageView searchicon;
    @FXML
     private Label daylabel;
    @FXML
     private TextField searchField;

    @FXML
     private Pane sessionspane;
    @FXML
     private Label startlabel;
    @FXML
     private ScrollPane scrolpane;
    @FXML
     private Pane allsessionpane;

    @FXML
     private Pane sessionpane1;
    @FXML
     private ImageView usericon1;

     @FXML
      private Circle circleProfile1;

    @FXML
     private Label namelabel;
    @FXML
     private TextFlow pausedTextflow1;
    @FXML
     private Text pausedatText;
    @FXML
     private Text dateofpausedText1;
    @FXML
     private Label pauselabel1;
    @FXML
     private TextFlow cteateTextflow1;
    @FXML 
    private Text createdatText1;
    @FXML
     private Text dateofCreated1;
    @FXML
     private Label dwplabel1;

    @FXML
     private Pane sessionpane2;
    @FXML
     private Label namelabel3;
    @FXML
     private ImageView usericon3;

     @FXML
      private Circle circleProfile3;

    @FXML
     private Label dwplabel3;
    @FXML
     private Label pauselabel3;
    @FXML
     private TextFlow createTextflow3;
    @FXML
     private Text createsatText3;
    @FXML
     private Text createdDateText3;
    @FXML
     private TextFlow pausedateTextfow3;
    @FXML
     private Text pausedattext3;
    @FXML
     private Text pausedDateText3;

    @FXML
     private Pane sessionpane3;

    @FXML
     private ImageView usericon2;

     @FXML
      private Circle circleProfile2;

    @FXML
     private Label namelabel2;
    @FXML
     private Label donelabel2;
    @FXML 
    private Label dwplabel2;
    @FXML
     private TextFlow createTextflow2;
    @FXML
     private Text createdatText;
    @FXML
     private Text createDateText2;
    @FXML
     private TextFlow doneTextflow2;
    @FXML
     private Text doneatText2;
    @FXML
     private Text doneDate2;

    @FXML
     private Button startsessionBtn;
    @FXML 
    private ImageView addIcon;
    @FXML
    
    private DatePicker datePicker;
    @FXML
    private void initialize() {

     ViewUtil.initiateResponsiveView(this);}

    }

