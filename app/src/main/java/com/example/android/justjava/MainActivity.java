package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final Double unitPrice = 5.00;
    public static final Integer initial_quantity = 0;
    public static final Double initial_price = 0.00;


    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetNumbers();
    }

    /**
     * @param view This method controls when the + button is pressed.
     *             When + button is pressed the increaseQuantity is true and
     *             the quantity is increased by 1.
     */
    public void incrementQuantity(View view) {
        quantity += 1;

        display(quantity);
        //displayPrice(quantity * unitPrice);
    }

    /**
     * @param view This method controls when the - button is pressed.
     *             When the - button is pressed the increaseQuantity is
     *             false and the value is decreased by 1.
     */
    public void decrementQuantity(View view) {
        if (quantity > 0) {
            quantity -= 1;
        }
        display(quantity);
        //displayPrice(quantity * unitPrice);
    }

    /**
     * This method is called when the order button is clicked
     *
     * @param view just show that the order was concluded.
     */
    public void submitOrder(View view) {
        displayPrice(quantity * unitPrice);
        orderStatus();

        //String priceMessage = "Free";
        //displayMessage(priceMessage);

    }

    /**
     * This method is called when the reset button is clicked
     *
     * @param view button
     */
    public void resetOrder(View view) {
        resetNumbers();
    }

    /**
     * This method displays the given quantity value on the screen
     *
     * @param number is the number of coffee to be ordered
     */
    public void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.format(Locale.US, "%d", number));
    }

    /**
     * This method display the price on the screen
     *
     * @param totalPrice is the total price oc the order, once the multiplication of the number of
     *                   ordered coffees by the unit price is already done
     */
    public void displayPrice(Double totalPrice) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance(Locale.US).format(totalPrice));
    }

    /**
     * This method reset the values of number of coffees and price in the screen.
     * The values are set to the initial values (0).
     */
    public void resetNumbers() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        TextView orderStatus = (TextView) findViewById(R.id.order_status);

        priceTextView.setText(NumberFormat.getCurrencyInstance(Locale.US).format(initial_price));
        quantityTextView.setText(String.format(Locale.US, "%d", initial_quantity));
        orderStatus.setText("");
    }


    public void orderStatus() {
        TextView status = (TextView) findViewById(R.id.order_status);
        status.setText("Order Done!");
    }




}
