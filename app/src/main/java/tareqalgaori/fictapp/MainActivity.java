package tareqalgaori.fictapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void lecturesMethod(View view) {
        Intent lecturesIntent = new Intent(MainActivity.this,Lectures.class);
        startActivity(lecturesIntent);
    }

    public void contactsMethod(View view) {
        Intent contactIntent = new Intent(MainActivity.this,Contacts.class);
        startActivity(contactIntent);
    }

    public void calenderMethod(View view) {
        Intent calenderIntent = new Intent(MainActivity.this,Calender.class);
        startActivity(calenderIntent);
    }

    public void timetableMethod(View view) {
        Intent timeIntent = new Intent(MainActivity.this,Timetable.class);
        startActivity(timeIntent);
    }

    public void aboutMethod(View view) {
        Intent aboutIntent = new Intent(MainActivity.this,About.class);
        startActivity(aboutIntent);
    }
}
