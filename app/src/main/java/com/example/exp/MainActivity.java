package com.example.exp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int numberOfCoffee = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view) {
        String message = "Total: "+ getString(R.string.Rs)+ numberOfCoffee * 10;
        message += "\nThank You!";
        displayPrice(message);
    }

    private void displayPrice(String msg) {
        TextView priceTextView = findViewById(R.id.price);
        priceTextView.setText(msg);

    }

    public void display(int number){
        TextView quantityTextView = findViewById(R.id.number);
        /*setText() method of TextView accepts CharSequence, not integers.
        So, you must convert your number to String before.*/

        // quantityTextView.setText(String.valueOf(number));
        //quantityTextView.setText(Integer.toString(number));
        //quantityTextView.setText(""+number); it will show some issues.

        quantityTextView.setText(String.valueOf(number));

       }
       /*now this time we have commented all the code because later we were just using the
       number to display so we used int parameter and now we want to create sting , so
       we have updated that method  */



    /*  public void displayPrice(int number){
       TextView priceTextView = findViewById(R.id.price);
        // for adding dollar sign we need to add few things
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
         }
     */


    public void decrement(View view) {
        if (numberOfCoffee > 0) {
            numberOfCoffee = numberOfCoffee - 1;
            display(numberOfCoffee);
        }
    }

    public void increment(View view) {
        if(numberOfCoffee>=10){
            Toast.makeText(getApplicationContext(),"You can not order more then 10 cups at once",Toast.LENGTH_SHORT).show();
        }
        else {
            numberOfCoffee = numberOfCoffee + 1;
            display(numberOfCoffee);
        }

    }
}