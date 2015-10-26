package tareqalgaori.fictapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


public class Lectures extends AppCompatActivity {


    ListView listView2;
    public static String[] names = {"Mhd Nour Albitar","Mahdi Babaei","Mainul Khan","Wael Fawakhiri","Noris Ismail","Hemant Singh"};
    public static String[] modules = {"Java Android","Information System","C++","C++ 2","Databases","Multimedia"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lectures_layout);
        listView2 = (ListView)findViewById(R.id.listview2);
        listView2.setAdapter(new NormalAdapter(this,modules,names));
    }
}
