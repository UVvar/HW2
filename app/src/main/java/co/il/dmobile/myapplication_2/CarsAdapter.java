package co.il.dmobile.myapplication_2;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsViewHolder> {

    private List<Cars> Cars;
    public CarsAdapter(List<Cars> cars) { this.Cars = cars;}


    public void AddCar(Cars cars) {
        Cars.add(cars);
        notifyDataSetChanged();
        DataPersistencyHelper.StoreData(Cars);
    }

    public void DeleteCar(int position) {
        Cars.remove(position);
        notifyDataSetChanged();
        DataPersistencyHelper.StoreData(Cars);
    }

    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_catalogue, parent, false);
        CarsViewHolder vh = new CarsViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {
        Cars cars = Cars.get(position);
        holder.Car_photo.setImageResource(cars.getImage());
        holder.Brand.setText(cars.getBrand());
        holder.Model.setText(cars.getModel());
        holder.Year.setText(cars.getYear());
        {
            holder.Card.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), MainActivity2.class);
                    i.putExtra("cars", cars);
                    ActivityOptionsCompat options =
                            ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(),
                                    holder.Car_photo,
                                    "car_photoTransition");
                    v.getContext().startActivity(i, options.toBundle());
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return Cars.size();
    }
}