package sg.edu.rp.c346.id19045083.myndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> SongList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);
        this.parent_context = context;
        this.layout_id = resource;
        this.SongList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewDisplayTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewDisplayYear);
        RatingBar rgStars = rowView.findViewById(R.id.ratingBarDisplayStars);
        TextView tvSingers = rowView.findViewById(R.id.textViewDisplaySingers);
        ImageView imgNew = rowView.findViewById(R.id.imageViewNew);

        // Obtain the Android Version information based on the position
        Song currentSong = SongList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentSong.getTitle());
        tvYear.setText(String.valueOf(currentSong.getYear()));
        rgStars.setRating(currentSong.getStars());
        tvSingers.setText(currentSong.getSingers());
        imgNew.setImageResource(R.drawable.newsong);

        if (currentSong.getYear() >= 2019){
            imgNew.setVisibility(View.VISIBLE);
        } else {
            imgNew.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }
}
