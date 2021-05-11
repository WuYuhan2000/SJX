package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

@SuppressWarnings({"ALL", "AlibabaUndefineMagicConstant"})
public class Main extends Application {
    Button b1=new Button("判断形状");
    Button b2=new Button("重新输入");
    TextField t1=new TextField();
    TextField t2=new TextField();
    TextField t3=new TextField();
    TextField t4=new TextField();
    String a,b,c;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(11,12,13,14));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.add(new Label("请输入三个1到200的整数"),0,0);
        pane.add(new Label("A"),0,1);
        pane.add(t1,1,1);
        pane.add(new Label("B"),0,2);
        pane.add(t2,1,2);
        pane.add(new Label("c"),0,3);
        pane.add(t3,1,3);
        pane.add(new Label("形状"),0,4);
        pane.add(t4,1,4);
        pane.add(b1,0,5);
        pane.add(b2,1,5);
        primaryStage.setTitle("三角形的形状判断");
        primaryStage.setScene(new Scene(pane, 320, 366));
        primaryStage.show();
        b1.setOnAction(e->Get());
        b2.setOnAction(e->Clean());
    }
    public void Get(){
        a=t1.getText().toString();
        b=t2.getText().toString();
        c=t3.getText().toString();
        System.out.println(a+","+b+","+c);
        double A,B,C;
        try {
                A = Double.valueOf(a);
                B = Double.valueOf(b);
                C = Double.valueOf(c);
                if (A >= 1 && A <= 200 && B >= 1 && B <= 200 && C >= 1 && C <= 200 && A % 1 == 0 && B % 1 == 0 && C % 1 == 0) {
                    if (A + B > C && A + C > B && B + C > A) {
                        if (A == B || A == C || B == C) {
                            if (A == B && B == C) {
                                t4.setText("等边三角形");
                            } else {
                                t4.setText("等腰三角形");
                            }
                        } else {
                            t4.setText("一般三角形");
                        }
                    } else {
                        t4.setText("不构成三角形");
                    }
                } else if (A % 1 != 0 || B % 1 != 0 || C % 1 != 0) {
                    Stage primaryStage=new Stage();
                    b1.setOnAction(e->Jump(primaryStage));
                }
                else{
                    Stage primaryStage=new Stage();
                    b1.setOnAction(e->Jump1(primaryStage));
                }
        }catch (Exception ex){
            ex.printStackTrace();
            Stage primaryStage=new Stage();
            b1.setOnAction(e->Jump(primaryStage));
            
        };
    }
    public void Jump(Stage primaryStage){
        GridPane pane = new GridPane();
        Button b3=new Button("确定");
        pane.setPadding(new Insets(11,12,13,14));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.add(new Label("参数输入非法!"),0,0);
        pane.add(b3,0,1);
        primaryStage.setScene(new Scene(pane, 120, 70));
        primaryStage.show();
        b3.setOnAction(e->primaryStage.close());
    }
    public void Jump1(Stage primaryStage){
        GridPane pane = new GridPane();
        Button b3=new Button("确定");
        pane.setPadding(new Insets(11,12,13,14));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.add(new Label("参数输入超限!"),0,0);
        pane.add(b3,0,1);
        primaryStage.setScene(new Scene(pane, 120, 70));
        primaryStage.show();
        b3.setOnAction(e->primaryStage.close());
    }
    public void Clean(){
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
    }
    public static void main(String[] args) {
        launch(args);
    }
}