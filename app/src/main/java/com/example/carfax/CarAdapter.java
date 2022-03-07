package com.example.carfax;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.carfax.models.Cars;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private Context context;
    private List<Cars.Example.Listing> mCarList;
    public OnCarListener onCarListener;

    public CarAdapter(Context context, List<Cars.Example.Listing> carList, OnCarListener onCarListener) {
        this.context = context;
        this.mCarList = carList;
        this.onCarListener = onCarListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.car_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView, onCarListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cars.Example.Listing carListResults = mCarList.get(position);

        // image will be under Listing

        TextView yearMakeModel = holder.yearMakeModel;
        TextView priceMiles = holder.priceMiles;
        TextView cityState = holder.cityState;
        Button callDealer = holder.callDealer;

        String yearMakeModelString = carListResults.getYear() + " " + carListResults.getMake() + " " + carListResults.getModel();

        Integer miles = carListResults.getMileage();
        Integer price = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            price = Math.toIntExact(Math.round(carListResults.getCurrentPrice()));
        }

        String mileage = miles/1000 + "k mi";
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String newPrice = formatter.format(price);
        String priceMileage = "$  " + newPrice + "  |  " + mileage;
        String cityStateString = carListResults.getDealer().getCity() + ", " + carListResults.getDealer().getState();
        String dealerNumber = carListResults.getDealer().getPhone();

        yearMakeModel.setText(yearMakeModelString);
        priceMiles.setText(priceMileage);
        cityState.setText(cityStateString);

        String imageUrl = carListResults.getImages().getFirstPhoto().getSmall();

        Glide.with(context).load(imageUrl).into(holder.image);

        // call dealer button listener and intent
        callDealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + dealerNumber));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mCarList == null) {
            return 0;
        }
        return mCarList.size();
    }

    public void setCars(List<Cars.Example.Listing> carListings) {
        this.mCarList = carListings;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnCarListener onCarListener;
        public ImageView image;
        TextView yearMakeModel;
        TextView priceMiles;
        TextView cityState;
        Button callDealer;

        public ViewHolder(@NonNull View itemView, OnCarListener listener) {
            super(itemView);
            this.onCarListener = listener;
            image = itemView.findViewById(R.id.rv_carImage);
            // do not forget to actually set the listener!
            itemView.setOnClickListener(this);
            yearMakeModel = itemView.findViewById(R.id.year_make_model);
            priceMiles = itemView.findViewById(R.id.price_miles);
            cityState = itemView.findViewById(R.id.city_state);
            callDealer = itemView.findViewById(R.id.rv_call_dealer_button);
        }

        @Override
        public void onClick(View view) {
            onCarListener.onCarClick(mCarList.get(getBindingAdapterPosition()));
        }
    }

    public interface OnCarListener {
        void onCarClick(Cars.Example.Listing car);
    }
}
