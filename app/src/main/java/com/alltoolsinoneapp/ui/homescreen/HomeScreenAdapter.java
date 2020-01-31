package com.alltoolsinoneapp.ui.homescreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alltoolsinoneapp.R;
import com.alltoolsinoneapp.Utils.Utill;
import com.alltoolsinoneapp.model.HomeScreenData;
import com.alltoolsinoneapp.ui.OnFragmentListItemSelectListener;

import java.util.List;

/**
 * Created by Kishan Thakkar on 2/1/2020.

 * KishanPujara127@gmail.com
 */
public class HomeScreenAdapter extends RecyclerView.Adapter<HomeScreenAdapter.HomeScreenHolder> {

    private Context context;
    private List<HomeScreenData> homeScreenDataList;
    private OnFragmentListItemSelectListener listener;


    public HomeScreenAdapter(Context context, List<HomeScreenData> homeScreenDataList) {
        this.context = context;
        this.homeScreenDataList = homeScreenDataList;
    }

    public void setListner(OnFragmentListItemSelectListener listner) {
        this.listener = listner;
    }

    @NonNull
    @Override
    public HomeScreenHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_homescreen, parent, false);
        HomeScreenHolder homeScreenHolder = new HomeScreenHolder(view);
        return homeScreenHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull HomeScreenHolder holder, int position) {
        final HomeScreenData homeScreenData=homeScreenDataList.get(position);
        Utill.setText(holder.tv_feature_name,homeScreenData.getFeatureName());
        holder.iv_feature_icon.setImageResource(homeScreenData.getFeatureIconId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onListItemSelected(R.id.tv_feature_name,homeScreenData);
            }
        });


    }

    @Override
    public int getItemCount() {
        return null != homeScreenDataList ? homeScreenDataList.size() : 0;
    }

    class HomeScreenHolder extends RecyclerView.ViewHolder {
        private TextView tv_feature_name;
        private ImageView iv_feature_icon;

        public HomeScreenHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_feature_name = itemView.findViewById(R.id.tv_feature_name);
            this.iv_feature_icon = itemView.findViewById(R.id.iv_feature_icon);
        }
    }
}
