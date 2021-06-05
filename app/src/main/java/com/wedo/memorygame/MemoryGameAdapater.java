package com.wedo.memorygame;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MemoryGameAdapater extends RecyclerView.Adapter<MemoryGameAdapater.ViewHolder> {

    private final  int CARD_MARGIN = 10;
    private Context currentContext;
    private MemoryLevel memoryLevel;
    private List<MemoryCard> selectedCards;
    LayoutInflater myInflater;
    private CardOnClickListener onClickListener;

    public MemoryGameAdapater(Context context, MemoryLevel memoryLevel, List<MemoryCard> selectedCards, CardOnClickListener listener) {
        this.currentContext = context;
        this.memoryLevel = memoryLevel;
        this.myInflater = LayoutInflater.from(context);
        this.selectedCards = selectedCards;
        this.onClickListener = listener;
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




        holder.myButton.setOnClickListener(v -> {
            if(!selectedCards.get(position).isFaceUp())
                holder.myButton.setImageResource(selectedCards.get(position).getIdentifier());
            else
                holder.myButton.setImageResource(R.drawable.ic_launcher_background);

            onClickListener.onCardClick(position, selectedCards.get(position));
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

    public interface CardOnClickListener{
        void onCardClick(int cardPosition, MemoryCard memoryCard);
    }
}
