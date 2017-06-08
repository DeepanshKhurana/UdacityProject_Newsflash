package in.thepolymath.newsflash;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.content.ContentValues.TAG;

/**
 * This adapter creates an Array List for News
 */

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Activity context, ArrayList<News> news) {
        super(context, 0, news);
    }

    /**
     * This lets us connect to the view list_item
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News thisNews = getItem(position);

        String newsTitle = thisNews.getNewsTitle();
        String newsSection = thisNews.getNewsSection();
        String newsDate = thisNews.getNewsDate();

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);
        if (newsTitle.equals("")) {
            titleTextView.setText(R.string.no_title);
        } else titleTextView.setText(newsTitle);

        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section);
        if (newsSection.equals("")) {
            sectionTextView.setText(R.string.no_section);
        } else sectionTextView.setText(newsSection);

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);

        String date = newsDate.substring(0,10);
        String time = newsDate.substring(11,16);


        if (newsDate.equals("")) {
            dateTextView.setText(R.string.no_date);
        } else{
            dateTextView.setText(formateDateFromstring("yyyy-MM-dd","MMM, dd yyyy", date));
            timeTextView.setText(formateDateFromstring("HH:mm","hh:mm a",time));
        }

        return listItemView;
    }

    private static String formateDateFromstring(String inputFormat, String outputFormat, String inputDate){

        Date parsed;
        String outputDate = "";

        SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, java.util.Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, java.util.Locale.getDefault());

        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);

        } catch (ParseException e) {
            Log.e(TAG, "ParseException - dateFormat");
        }

        return outputDate;

    }
}
