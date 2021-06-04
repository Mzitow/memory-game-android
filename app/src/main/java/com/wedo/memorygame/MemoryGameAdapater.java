package com.wedo.memorygame;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MemoryGameAdapater extends RecyclerView.Adapter<MemoryGameAdapater.ViewHolder> {

    private final  int CARD_MARGIN = 10;
    private Context currentContext;
    private MemoryLevel memoryLevel;
    private List<Integer> images;
    LayoutInflater myInflater;

    public MemoryGameAdapater(Context context, MemoryLevel memoryLevel, List<Integer> images) {
        this.currentContext = context;
        this.memoryLevel = memoryLevel;
        this.myInflater = LayoutInflater.from(context);
        this.images = images;

    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        int width = parent.getWidth() / memoryLevel.getWidh();
        int  height = parent.getHeight() / memoryLevel.getHeight();

        int cardLenght =   150;      //Math.min(width, height);

        Log.i("ONEtWO", "onCreateViewHolder: " + parent.getHeight());

        View view = myInflater.inflate(R.layout.card_item, parent, false);

        CardView cardView = (CardView) view.findViewById(R.id.memory_cell);
        ViewGroup.MarginLayoutParams cardViewMargin = (ViewGroup.MarginLayoutParams) cardView.getLayoutParams();
        ViewGroup.LayoutParams params = cardView.getLayoutParams();

        cardViewMargin.setMargins(CARD_MARGIN,CARD_MARGIN,CARD_MARGIN,CARD_MARGIN);
        params.height = cardLenght;
        params.width = cardLenght;

        cardView.requestLayout();
        cardView.setLayoutParams(params);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MemoryGameAdapater.ViewHolder holder, int position) {


        holder.myButton.setImageResource(images.get(position));

        holder.myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(currentContext, "Clicked : " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return memoryLevel.getPieces();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageButton myButton;

        public ViewHolder(View itemView) {
            super(itemView);

            myButton = itemView.findViewById(R.id.image_button);
        }
    }
}
