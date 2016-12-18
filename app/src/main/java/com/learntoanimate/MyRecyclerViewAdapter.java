package com.learntoanimate;

/**
 * Created by shashank on 8/6/2016.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learntoanimate.api.RepositoryDetails;

import java.io.FileInputStream;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;


public class MyRecyclerViewAdapter extends
        RealmRecyclerViewAdapter<RepositoryDetails, MyRecyclerViewAdapter.MyViewHolder>
{


    private Context context;
    private OnItemClickListener onItemClickHandler;

    public MyRecyclerViewAdapter(@Nullable Context context, OrderedRealmCollection<RepositoryDetails> data,
                                 OnItemClickListener onItemClickHandler) {
        super(context, data, true);
        this.context = context;
        this.onItemClickHandler = onItemClickHandler;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main_recycler,
                parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String name = getItem(position).getName();
        holder.title.setText(name);
        holder.forks.setText(getItem(position).getForks()+"");
        holder.stars.setText(getItem(position).getStargazersCount()+"");
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Nullable
    @Override
    public RepositoryDetails getItem(int index) {
        return super.getItem(index);
    }

//    public Bitmap getImageBitmap(Context context, String name, String extension){
//        name=name+"."+extension;
//        try(FileInputStream fis = context.openFileInput(name)){
//            Bitmap b = BitmapFactory.decodeStream(fis);
//            return b;
//        }
//        catch(Exception e){
//        }
//        return null;
//    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title, forks, stars;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.repo_name);
            forks = (TextView) view.findViewById(R.id.repo_fork);
            stars = (TextView) view.findViewById(R.id.repo_stars);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            RepositoryDetails data = getItem(adapterPosition);
            onItemClickHandler.onItemClick(adapterPosition, data, view);
        }
    }

    public static interface OnItemClickListener {
        public void onItemClick(int position, RepositoryDetails data, View currentView);
    }

}