package tareqalgaori.fictapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;


public class Contacts extends AppCompatActivity {


    protected ListView listView1;

    public static String[] names = {"Mhd Nour Albitar","Mahdi Babaei","Mainul Khan","Wael Fawakhiri","Noris Ismail","Hemant Singh"};
    public static String[] emails = {"nour.albitar@limkokwing.edu.my","mahdi.babaei@limkokwing.edu.my","mainul.khan@limkokwing.edu.my",
            "wael.fawkhiri@limkokwing.edy.my","noris@limkokwing.edu.my","hemant.singh@limkokwing.edu.my"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_layout);

        listView1 = (ListView) findViewById(R.id.listview1);
        listView1.setAdapter(new CustomAdapter(Contacts.this,emails,names));
    }


}
