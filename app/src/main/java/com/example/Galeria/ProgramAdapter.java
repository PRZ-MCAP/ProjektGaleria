package com.example.Galeria;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> implements View.OnClickListener {

    Context context;
    int[] images;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView rowImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowImage = itemView.findViewById(R.id.imageView);
        }
        public ImageView getImage(){
            return this.rowImage;
        }
    }

    public ProgramAdapter(Context context, int[] images){
        this.context=context;
        this.images=images;
    }

    @NonNull
    @Override
    public ProgramAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        //set click listener on picture
        viewHolder.getImage().setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramAdapter.ViewHolder holder, int position) {
        holder.rowImage.setImageResource(images[position]);
        //set imageID as ImageView tag
        holder.rowImage.setTag(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    @Override
    public void onClick(View v) {
        // View v is clicked object
        if(v.getId()==R.id.imageView){
                //get tag of imageID from view
                Integer imageID = (Integer)v.getTag();
                launchViewPhoto(v, imageID);
        }
    }

    //launches ViewPhotoActivity activity
    public void launchViewPhoto(View v, int imageID){
        Intent i = new Intent(v.getContext(), ViewPhotoActivity.class);
        //sends id of clicked image to ViewPhotoActivity activity
        i.putExtra("id", imageID);
        v.getContext().startActivity(i);
    }
}
