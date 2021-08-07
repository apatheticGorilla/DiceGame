package com.example.dicegame;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
	int[] imageIndex = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six};
	int[] rolls = new int[3];
	ImageView diceOne, diceTwo, diceThree;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		diceOne = findViewById(R.id.dice1);
		diceTwo = findViewById(R.id.dice2);
		diceThree = findViewById(R.id.dice3);
	}
	
	@SuppressWarnings("unused")
	public void onRoll(View view) {
		Random random = new Random();
		for (int i = 0; i < 3; i++) rolls[i] = random.nextInt(6);
		diceOne.setImageResource(imageIndex[rolls[0]]);
		diceTwo.setImageResource(imageIndex[rolls[1]]);
		diceThree.setImageResource(imageIndex[rolls[2]]);
		System.out.println(checkToastConditions());
		if (checkToastConditions() == 1)
			Toast.makeText(this, "Two Of A Kind!", Toast.LENGTH_SHORT).show();
		if (checkToastConditions() == 2)
			Toast.makeText(this, "Three Of A Kind!", Toast.LENGTH_SHORT).show();
	}
	
	//1 = two of a kind; 2 = three of a kind; 0 = no match
	int checkToastConditions() {
		
		StringBuilder string = new StringBuilder();
		for (int roll : rolls) string.append(roll);
		if (Integer.parseInt(string.toString()) % 111 == 0) return 2;
		if (rolls[0] == rolls[1]) return 1;
		if (rolls[1] == rolls[2]) return 1;
		if (rolls[0] == rolls[2]) return 1;
		return 0;
	}
}