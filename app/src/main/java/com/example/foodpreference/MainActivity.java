package com.example.foodpreference;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private CheckBox checkPizza, checkBurger, checkPasta;
    private RadioGroup radioGroupDrink;
    private RadioButton radioCoke, radioJuice, radioWater;
    private Button btnSubmit;
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPizza = findViewById(R.id.checkPizza);
        checkBurger = findViewById(R.id.checkBurger);
        checkPasta = findViewById(R.id.checkPasta);
        radioGroupDrink = findViewById(R.id.radioGroupDrink);
        radioCoke = findViewById(R.id.radioCoke);
        radioJuice = findViewById(R.id.radioJuice);
        radioWater = findViewById(R.id.radioWater);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.txtResult);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySelections();
            }
        });
    }

    private void displaySelections() {
        StringBuilder result = new StringBuilder("Food Preferences: ");
        if (checkPizza.isChecked())
            result.append("Pizza ");
        if (checkBurger.isChecked())
            result.append("Burger ");
        if (checkPasta.isChecked())
            result.append("Pasta ");

        result.append("\nPreferred Drink: ");
        int selectedDrinkId = radioGroupDrink.getCheckedRadioButtonId();
        if (selectedDrinkId == radioCoke.getId())
            result.append("Coke");
        else if (selectedDrinkId == radioJuice.getId())
            result.append("Juice");
        else if (selectedDrinkId == radioWater.getId())
            result.append("Water");
        txtResult.setText(result.toString());
    }
}