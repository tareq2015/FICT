package tareqalgaori.fictapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Calender extends AppCompatActivity  implements CalendarView.OnCellTouchListener{
    public static final String MIME_TYPE = "vnd.android.cursor.dir/vnd.exina.android.calendar.date";
    CalendarView mView = null;
    TextView mHit;
    Handler mHandler = new Handler();


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender_layout);
        mView = (CalendarView)findViewById(R.id.calendar);
        mView.setOnCellTouchListener(this);

        //if(getIntent().getAction().equals(Intent.ACTION_PICK))
           // findViewById(R.id.hint).setVisibility(View.INVISIBLE);
    }

    public void onTouch(Cell cell) {
        Intent intent = getIntent();
        /*
        String action = intent.getAction();
        if(action.equals(action.equals(Intent.ACTION_GET_CONTENT))) {
            int year  = mView.getYear();
            int month = mView.getMonth();
            int day   = cell.getDayOfMonth();

            // FIX issue 6: make some correction on month and year
            if(cell instanceof CalendarView.GrayCell) {
                // oops, not pick current month...
                if (day < 15) {
                    // pick one beginning day? then a next month day
                    if(month==11)
                    {
                        month = 0;
                        year++;
                    } else {
                        month++;
                    }

                } else {
                    // otherwise, previous month
                    if(month==0) {
                        month = 11;
                        year--;
                    } else {
                        month--;
                    }
                }
            }

            Intent ret = new Intent();
            ret.putExtra("year", year);
            ret.putExtra("month", month);
            ret.putExtra("day", day);
            this.setResult(RESULT_OK, ret);
            finish();
            return;
        }*/
        int day = cell.getDayOfMonth();
        if(mView.firstDay(day))
            mView.previousMonth();
        else if(mView.lastDay(day))
            mView.nextMonth();
        else
            return;

        mHandler.post(new Runnable() {
            public void run() {
                Toast.makeText(Calender.this, DateUtils.getMonthString(mView.getMonth(), DateUtils.LENGTH_LONG) + " " + mView.getYear(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
