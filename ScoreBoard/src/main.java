import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class main extends Application {
    private int oyuncuBirSkor = 0;
    private int oyuncuIkiSkor = 0;

    @Override
    public void start(Stage primaryStage) {
        // Oyuncu Adları
        Label oyuncuBirAd = new Label("Oyuncu 1");
        oyuncuBirAd.setFont(Font.font("Arial", 24));
        oyuncuBirAd.setTextFill(Color.WHITE);

        Label oyuncuIkiAd = new Label("Oyuncu 2");
        oyuncuIkiAd.setFont(Font.font("Arial", 24));
        oyuncuIkiAd.setTextFill(Color.WHITE);

        // Skor Etiketleri
        Label oyuncuBirSkorLabel = new Label(String.valueOf(oyuncuBirSkor));
        oyuncuBirSkorLabel.setFont(Font.font("Arial", 48));
        oyuncuBirSkorLabel.setTextFill(Color.WHITE);

        Label oyuncuIkiSkorLabel = new Label(String.valueOf(oyuncuIkiSkor));
        oyuncuIkiSkorLabel.setFont(Font.font("Arial", 48));
        oyuncuIkiSkorLabel.setTextFill(Color.WHITE);

        // Skor Artırma ve Azaltma Düğmeleri
        Button oyuncuBirArtir = new Button("+");
        oyuncuBirArtir.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 20px;");
        oyuncuBirArtir.setOnAction(e -> {
            oyuncuBirSkor++;
            oyuncuBirSkorLabel.setText(String.valueOf(oyuncuBirSkor));
        });

        Button oyuncuBirAzalt = new Button("-");
        oyuncuBirAzalt.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-size: 20px;");
        oyuncuBirAzalt.setOnAction(e -> {
            if (oyuncuBirSkor > 0) {
                oyuncuBirSkor--;
                oyuncuBirSkorLabel.setText(String.valueOf(oyuncuBirSkor));
            }
        });

        Button oyuncuIkiArtir = new Button("+");
        oyuncuIkiArtir.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 20px;");
        oyuncuIkiArtir.setOnAction(e -> {
            oyuncuIkiSkor++;
            oyuncuIkiSkorLabel.setText(String.valueOf(oyuncuIkiSkor));
        });

        Button oyuncuIkiAzalt = new Button("-");
        oyuncuIkiAzalt.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-size: 20px;");
        oyuncuIkiAzalt.setOnAction(e -> {
            if (oyuncuIkiSkor > 0) {
                oyuncuIkiSkor--;
                oyuncuIkiSkorLabel.setText(String.valueOf(oyuncuIkiSkor));
            }
        });

        // Reset Butonu
        Button sifirla = new Button("Sıfırla");
        sifirla.setStyle("-fx-background-color: gray; -fx-text-fill: white; -fx-font-size: 20px;");
        sifirla.setOnAction(e -> {
            oyuncuBirSkor = 0;
            oyuncuIkiSkor = 0;
            oyuncuBirSkorLabel.setText(String.valueOf(oyuncuBirSkor));
            oyuncuIkiSkorLabel.setText(String.valueOf(oyuncuIkiSkor));
        });

        // Oyuncu Adları ve Skorları için Layout (Yatayda)
        HBox oyuncuAdlarLayout = new HBox(200, oyuncuBirAd, oyuncuIkiAd); // Arayı büyütüyoruz
        oyuncuAdlarLayout.setStyle("-fx-alignment: center; -fx-padding: 20;");
        
        HBox oyuncuSkorLayout = new HBox(300, oyuncuBirSkorLabel, oyuncuIkiSkorLabel); // Arayı büyütüyoruz
        oyuncuSkorLayout.setStyle("-fx-alignment: center; -fx-padding: 20;");
        
        // Butonlar için Layout (Yatayda ve aynı satırda)
        HBox butonlarLayout = new HBox(100, oyuncuBirArtir, oyuncuBirAzalt, oyuncuIkiArtir, oyuncuIkiAzalt); // Butonları aynı satıra hizalıyoruz
        butonlarLayout.setStyle("-fx-alignment: center; -fx-padding: 20;");
        
        // Ortada Reset Butonu
        HBox resetLayout = new HBox(sifirla);
        resetLayout.setStyle("-fx-alignment: center; -fx-padding: 20;");

        // Tüm Elemanları Yerleştir
        VBox layout = new VBox(40, 
                oyuncuAdlarLayout, 
                oyuncuSkorLayout, 
                butonlarLayout, 
                resetLayout);
        layout.setStyle("-fx-background-color: #333333; -fx-padding: 20; -fx-alignment: center;");

        // Scene ve Stage Ayarları
        Scene scene = new Scene(layout, 1000, 800);
        scene.setFill(Color.BLACK);
        primaryStage.setTitle("Skorboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
