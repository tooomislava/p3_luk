package zilic.luk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.ItemClickListener {

    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new Adapter(this);
        adapter.setItemClickListener(this);
        RecyclerView lista = findViewById(R.id.lista);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adapter);

        new REST().execute("https://oziz.ffos.hr/nastava20202021/tzilic_20/PLACE/mi/SE");

    }

    @Override
    public void onItemClick(Luk luk) {
        Log.d("Stigao", "---");
        Toast.makeText(this, "Slojevi luka: "+String.valueOf(luk.getSlojevi())+" Moje suze u litrama: "+String.valueOf(luk.getMlSuza()/1000),Toast.LENGTH_LONG).show();
    }


    private class REST extends AsyncTask<String,Void, List<Luk>>{

        @Override
        protected List<Luk> doInBackground(String... strings) {
            String stringUrl = strings[0];
            Log.wtf(">>>>> ",stringUrl);
            List<Luk> vrati=null;
            try {
                URL myUrl = new URL(stringUrl);
                HttpURLConnection connection =(HttpURLConnection)
                        myUrl.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(15000);
                connection.setConnectTimeout(15000);
                connection.connect();
                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                Type listType = new TypeToken<ArrayList<Luk>>(){}.getType();
                Gson gson = new GsonBuilder().setDateFormat("mm:ss").create();
                vrati = gson.fromJson(reader, listType);
                reader.close();
                streamReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return vrati;
        }

        @Override
        protected void onPostExecute(List<Luk> luks) {
            adapter.setLuka(luks);
            adapter.notifyDataSetChanged();
        }
    }
}