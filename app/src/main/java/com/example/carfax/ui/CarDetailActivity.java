package com.example.carfax.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.carfax.R;
import com.example.carfax.models.Cars;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class CarDetailActivity extends AppCompatActivity {

    private static final String TAG = "CarDetailActivity";
    private Cars.Example.Listing car;
    private Cars.Example.Listing.Dealer dealerInfo;
    private Cars.Example.Listing.Images.FirstPhoto imageInfo;
    private ImageView image;
    private Button callDealer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        callDealer = findViewById(R.id.detail_call_dealer_button);
        image = findViewById(R.id.detail_carImage);
        Intent intent = getIntent();

        if (intent != null) {
            car = intent.getParcelableExtra("carDetails");
            dealerInfo = intent.getParcelableExtra("dealerInfo");
            imageInfo = intent.getParcelableExtra("image");

        }

        if (car != null) {
            Log.d(TAG, "onCreate: " + car.getModel() + dealerInfo.getCity() + imageInfo.getLarge());
        }


        String imageUrl = imageInfo.getSmall();
        Glide.with(this).load(imageUrl).into(image);

        getCar(car, dealerInfo);

        String dealerNumber = dealerInfo.getPhone();
        callDealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + dealerNumber));
                startActivity(intent);
            }
        });

    }

    private void getCar(Cars.Example.Listing carDetails, Cars.Example.Listing.Dealer dealer) {
        TextView yearMakeModel = findViewById(R.id.detail_year_make_model);
        TextView priceMiles = findViewById(R.id.detail_price_miles);
        TextView vehicleInfo = findViewById(R.id.vehicleInfo);
        TextView location = findViewById(R.id.location);
        TextView exteriorColor = findViewById(R.id.exterior_color);
        TextView interiorColor = findViewById(R.id.interior_color);
        TextView driveType = findViewById(R.id.driveType);
        TextView transmission = findViewById(R.id.transmission);
        TextView bodyStyle = findViewById(R.id.bodyStyle);
        TextView engine = findViewById(R.id.engine);
        TextView fuel = findViewById(R.id.fuel);

        String locale = dealer.getCity() + " " + dealer.getState();
        String yrMkMdl = carDetails.getYear() + " " + carDetails.getMake() + " " + carDetails.getModel();
        int miles = carDetails.getMileage();
        double currentPrice = carDetails.getCurrentPrice();
        String mileage = miles / 1000 + "k mi";
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String price = formatter.format(currentPrice);
        String priceMileage = "$ " + price + "  |  " + mileage;

        yearMakeModel.setText(yrMkMdl);
        priceMiles.setText(priceMileage);
        vehicleInfo.setText(R.string.vehicleInfo);
        location.setText(locale);
        exteriorColor.setText(carDetails.getExteriorColor());
        interiorColor.setText(carDetails.getInteriorColor());
        driveType.setText(carDetails.getDrivetype());
        transmission.setText(carDetails.getTransmission());
        bodyStyle.setText(carDetails.getBodytype());
        engine.setText(carDetails.getEngine());
        fuel.setText(carDetails.getFuel());
    }



    private void closeOnError() {
        finish();
        Toast.makeText(this, "Data not available", Toast.LENGTH_SHORT).show();
    }
}