package tareqalgaori.fictapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class NormalAdapter extends BaseAdapter {

    String[] leftN;
    String[] rightN;
    Context context;
    private static LayoutInflater inflater=null;

    public NormalAdapter(Context c, String[] r, String[] l) {
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



        return rowView;
    }
}
