package tareqalgaori.fictapp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class CustomAdapter extends BaseAdapter {


    String[] leftN;
    String[] rightN;
    Context context;
    private static LayoutInflater inflater=null;

    public CustomAdapter(Context c, String[] r, String[] l) {
        context = c;
        leftN = l;
        rightN = r;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return leftN.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder{

        TextView left;
        TextView right;

    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.custom,null);
        holder.left = (TextView)rowView.findViewById(R.id.left);
        holder.right = (TextView)rowView.findViewById(R.id.right);

        holder.left.setText(leftN[position]);
        holder.right.setText(rightN[position]);

        // set up listeners
        holder.left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // make a phone call
                //Toast.makeText(context, "You Clicked " + leftN[position], Toast.LENGTH_LONG).show();
                callMethod();
            }
        });

        holder.right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send email
                //Toast.makeText(context, "You Clicked " + rightN[position], Toast.LENGTH_LONG).show();
                sendEmail(rightN[position]);
            }
        });

        return rowView;
    }


    public void callMethod() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:006-018-281-6156"));

        try{

            context.startActivity(intent);

        }catch (ActivityNotFoundException e){
            Toast.makeText(context,"yourActivity is not founded", Toast.LENGTH_SHORT).show();
        }
    }

    public void sendEmail(String tos) {
        //Log.i("Send email", "");
        String[] TO = {""+tos+""};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
       // emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello");

        try {
            context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            //context.finish();
            //Log.i("Finished sending email...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }




}
