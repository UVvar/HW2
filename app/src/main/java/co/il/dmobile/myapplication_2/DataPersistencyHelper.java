package co.il.dmobile.myapplication_2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataPersistencyHelper {

    public static Context Context;

    public static void StoreData(List<Cars> cars)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        SharedPreferences.Editor editor = sp.edit();
        String json = new Gson().toJson(cars);
        editor.putString("cars", json);
        editor.commit();
    }

    public static List<Cars> LoadData()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        String json = sp.getString("cars",null);
        if (json != null)
        {
            Type type = new TypeToken<List<Cars>>(){}.getType();
            return new Gson().fromJson(json,type);
        }
        else
        {
            List<Cars> cars = new ArrayList<Cars>();
            cars.add(new Cars(R.drawable.bmw, "BMW", "i4 eDrive40", "2021", "120,000$"));
            cars.add(new Cars(R.drawable.dacia, "Dacia","Spring Electric", "2021", "80,000$"));
            cars.add(new Cars(R.drawable.hyundaiioniq, "Hyundai","Ioniq 5 long Range","2022", "98,000$"));
            cars.add(new Cars(R.drawable.kia,"Kia","EV6 GT","2022", "110,000$"));
            cars.add(new Cars(R.drawable.mercedes,"Mercedes","EQS 450","2022", "220,000$"));
            cars.add(new Cars(R.drawable.nissan,"Nissan","Leaf","2021", "50,000$"));
            cars.add(new Cars(R.drawable.skoda,"Skoda","Enyaq iV 80", "2022","105,000$"));
            cars.add(new Cars(R.drawable.tesla,"Tesla","Model 3", "2021", "34,000$"));
            return cars;
        }
    }

}
