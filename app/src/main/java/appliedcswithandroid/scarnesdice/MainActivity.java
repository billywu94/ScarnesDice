package appliedcswithandroid.scarnesdice;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static int userOverallScore = 0;
    public static int userTurnScore = 0;
    public static int computerOverallScore = 0;
    public static int computerTurnScore = 0;

    //source: http://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
    private static int randomNum(int min, int max){
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    //shows user the number rolled depending on the random number generated
    private void diceFace (int numRolled){
        switch (numRolled){
            case 1:
                //source: http://stackoverflow.com/questions/11737607/how-to-set-the-image-from-drawable-dynamically-in-android
                ImageView image = (ImageView) findViewById(R.id.imageView);
                Drawable dice1 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.dice1); //gets image from drawable folder
                image.setImageDrawable(dice1);
                break;
            case 2:
                ImageView image2 = (ImageView) findViewById(R.id.imageView);
                Drawable dice2 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.dice2); //gets image from drawable folder
                image2.setImageDrawable(dice2);
                break;
            case 3:
                ImageView image3 = (ImageView) findViewById(R.id.imageView);
                Drawable dice3 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.dice3); //gets image from drawable folder
                image3.setImageDrawable(dice3);
                break;
            case 4:
                ImageView image4 = (ImageView) findViewById(R.id.imageView);
                Drawable dice4 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.dice4); //gets image from drawable folder
                image4.setImageDrawable(dice4);
                break;
            case 5:
                ImageView image5 = (ImageView) findViewById(R.id.imageView);
                Drawable dice5 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.dice5); //gets image from drawable folder
                image5.setImageDrawable(dice5);
                break;
            case 6:
                ImageView image6 = (ImageView) findViewById(R.id.imageView);
                Drawable dice6 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.dice6); //gets image from drawable folder
                image6.setImageDrawable(dice6);
                break;

        }
    }
    //Display score
    private void displayScore(){
        TextView score = (TextView) findViewById(R.id.textView);
        score.setText("Your score: " + userOverallScore +" Computer Score: " + computerOverallScore+ " Your Turn Score: " + userTurnScore);
    }

    //show computer's current round score
    private void displayComputerRoundScore(int numberRolled){
        TextView computerRoundScore = (TextView) findViewById(R.id.computerTurn);
        computerRoundScore.setText("Computer rolled a: " + numberRolled);
    }


    private void computerTurn(){
        Button rollButton = (Button) findViewById(R.id.button2);
        rollButton.setClickable(false); //source: http://stackoverflow.com/questions/16168716/android-enable-disable-a-button-in-runtime
        rollButton.setEnabled(false);
        Button holdButton = (Button) findViewById(R.id.button3);
        holdButton.setClickable(false);
        holdButton.setEnabled(false);


        while (computerTurnScore < 20){
            int roll = randomNum(1,6);
            switch (roll){
                case 1:
                    //source: http://stackoverflow.com/questions/11737607/how-to-set-the-image-from-drawable-dynamically-in-android
                    diceFace(roll);
                    computerTurnScore = 0;
                    displayComputerRoundScore(roll);
                    Log.i("roll#: ", "comp rolled a 1");
                    break;
                case 2:
                    diceFace(roll);
                    computerTurnScore += roll;
                    displayComputerRoundScore(roll);
                    Log.i("roll#: ", "comp rolled a 2");
                    break;
                case 3:
                    diceFace(roll);
                    computerTurnScore += roll;
                    displayComputerRoundScore(roll);
                    Log.i("roll#: ", "comp rolled a 3");
                    break;
                case 4:
                    diceFace(roll);
                    computerTurnScore += roll;
                    displayComputerRoundScore(roll);
                    Log.i("roll#: ", "comp rolled a 4");
                    break;
                case 5:
                    diceFace(roll);
                    computerTurnScore += roll;
                    displayComputerRoundScore(roll);
                    Log.i("roll#: ", "comp rolled a 5");
                    break;
                case 6:
                    diceFace(roll);
                    computerTurnScore += roll;
                    displayComputerRoundScore(roll);
                    Log.i("roll#: ", "comp rolled a 6");
                    break;
            }
            if(computerTurnScore == 0){ //end turn
                rollButton.setClickable(true);
                rollButton.setEnabled(true);
                holdButton.setClickable(true);
                holdButton.setEnabled(true);
                displayScore();
                break;
            }else if(computerTurnScore >= 20){ //hold
                computerOverallScore += computerTurnScore;
                computerTurnScore = 0;
                rollButton.setClickable(true);
                rollButton.setEnabled(true);
                holdButton.setClickable(true);
                holdButton.setEnabled(true);
                displayScore();
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayScore();
        Button button = (Button) findViewById(R.id.button2);
        button.setText(R.string.roll);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int roll = randomNum(1,6);
                switch (roll){
                    case 1:
                        //source: http://stackoverflow.com/questions/11737607/how-to-set-the-image-from-drawable-dynamically-in-android
                        diceFace(roll);
                        userTurnScore = 0;
                        displayScore();
                        Log.i("roll#: ", "user rolled a 1");
                        break;
                    case 2:
                        diceFace(roll);
                        userTurnScore += roll;
                        displayScore();
                        Log.i("roll#: ", "user rolled a 2");
                        break;
                    case 3:
                        diceFace(roll);
                        userTurnScore += roll;
                        displayScore();
                        Log.i("roll#: ", "user rolled a 3");
                        break;
                    case 4:
                        diceFace(roll);
                        userTurnScore += roll;
                        displayScore();
                        Log.i("roll#: ", "user rolled a 4");
                        break;
                    case 5:
                        diceFace(roll);
                        userTurnScore += roll;
                        displayScore();
                        Log.i("roll#: ", "user rolled a 5");
                        break;
                    case 6:
                        diceFace(roll);
                        userTurnScore += roll;
                        displayScore();
                        Log.i("roll#: ", "user rolled a 6");
                        break;
                    default:
                        userTurnScore = 0;
                        break;
                }
                if(userTurnScore == 0){ //end user turn
                    computerTurn();
                }
            }
        });

        Button holdButton = (Button) findViewById(R.id.button3);
        holdButton.setText(R.string.hold);
        holdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userOverallScore += userTurnScore;
                userTurnScore = 0;
                displayScore();
                computerTurn();
            }
        });

        Button resetButton = (Button) findViewById(R.id.button4);
        resetButton.setText(R.string.reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userOverallScore = 0;
                userTurnScore = 0;
                computerOverallScore = 0;
                computerTurnScore = 0;
                displayScore();
            }
        });

    }


}
