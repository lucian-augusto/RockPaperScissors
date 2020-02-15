package com.lucian.android.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectRock(View view) {
        this.selectedOption("rock");
    }

    public void selectPaper(View view) {
        this.selectedOption("paper");
    }

    public void selectScissors(View view) {
        this.selectedOption("scissors");
    }

    public void selectedOption(String userChoice) {
        // Creating a variable that will be associated to the image that changes with the computer's
        // choice.
        ImageView resultImage = (ImageView) findViewById(R.id.computerChoiceImg);

        // Creating a variable that will be associated to the text that changes with the result.
        TextView resultText = (TextView) findViewById(R.id.textResult);

        // Creating an Array with the computer's options.
        String[] options = {"rock","paper","scissors"};

        // Generate a random number for the computer's choice.
        int number = new Random().nextInt(3);

        // Confirming computer's choice
        String computerChoice = options[number];

        // Changing the image in the computer's choice field.
        switch (computerChoice){
            case "rock":
                resultImage.setImageResource(R.drawable.pedra);
                break;

            case "paper":
                resultImage.setImageResource(R.drawable.papel);
                break;

            case "scissors":
                resultImage.setImageResource(R.drawable.tesoura);
                break;
        }


        // Logic to decide the winner
        if (computerChoice == userChoice){
            resultText.setText("It is a draw!");
        }
        else if (
                (computerChoice == "rock" && userChoice == "scissors") ||
                (computerChoice == "paper" && userChoice == "rock") ||
                (computerChoice == "scissors" && userChoice == "paper")) {
            resultText.setText("You lose!");
        }
        else{
            resultText.setText("You win!");
        }
    }
}
