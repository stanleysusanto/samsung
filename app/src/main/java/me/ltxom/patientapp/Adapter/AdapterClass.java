package me.ltxom.patientapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import me.ltxom.patientapp.Profile;
import me.ltxom.patientapp.R;
import me.ltxom.patientapp.SearchQuery;
import me.ltxom.patientapp.service.PatientService;

public class AdapterClass extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private List<SearchQuery> searchQueries = null;
    private ArrayList<SearchQuery> arraylist;

    public AdapterClass(Context context, List<SearchQuery> searchQueries) {
        mContext = context;
        this.searchQueries = searchQueries;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<SearchQuery>();
        this.arraylist.addAll(searchQueries);
    }

    public class ViewHolder {
        TextView name;
        TextView email;
        ImageView image;
    }

    @Override
    public int getCount() {
        return searchQueries.size();
    }

    @Override
    public SearchQuery getItem(int position) {
        return searchQueries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_items, null);
            // Locate the TextViews in listview_item.xml
            holder.name = view.findViewById(R.id.name);
            holder.email = view.findViewById(R.id.email);
            holder.image = view.findViewById(R.id.image_icon);
            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PatientService patientService = new PatientService();
                    List<LinkedTreeMap> list = patientService.listPatients();
                    String firstName = holder.name.getText().toString().split(" ")[0];
                    for (LinkedTreeMap map : list) {
                        if (map.get("firstName").equals(firstName)) {
                            Profile.patientid = map.get("patientId").toString();
                            break;
                        }
                    }
                    Intent i1 = new Intent(mContext, Profile.class);
                    mContext.startActivity(i1);
                }
            });
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(searchQueries.get(position).getQuery().split(":")[0]);
        holder.email.setText(searchQueries.get(position).getQuery().split(":")[1]);
        byte[] imageBytes = Base64.decode(searchQueries.get(position).getQuery().split(":")[2], Base64.URL_SAFE);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        holder.image.setImageBitmap(decodedImage);

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        searchQueries.clear();
        if (charText.length() == 0) {
            searchQueries.addAll(arraylist);
        } else {
            for (SearchQuery wp : arraylist) {
                if (wp.getQuery().substring(0, 30).toLowerCase(Locale.getDefault()).contains(charText)) {
                    searchQueries.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}