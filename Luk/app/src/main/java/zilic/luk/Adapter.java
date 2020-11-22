package zilic.luk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Red> {

    private List<Luk> luka;
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;

    public Adapter(Context context){
        layoutInflater = LayoutInflater.from(context);
        luka=new ArrayList<>();
    }

    public void setLuka(List<Luk> luka) {
        this.luka = luka;
    }

    @NonNull
    @Override
    public Red onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.red_layout, parent, false);
        return new Red(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Red holder, int position) {
        Luk l = this.luka.get(position);

        for (int i = 0; i <= l.getSlojevi(); i++) {
            if( i == 11){
                holder.slojevi.setText(")))))))))))");
            }
            if( i == 12){
                holder.slojevi.setText(")))))))))))");
            }
            if( i == 13){
                holder.slojevi.setText(")))))))))))))");
            }
            if( i == 14){
                holder.slojevi.setText("))))))))))))))");
            }
            if( i == 15){
                holder.slojevi.setText(")))))))))))))))");
            }
        }


    }

    @Override
    public int getItemCount() {
        return this.luka==null ? 0 : this.luka.size();
    }

    public class Red extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView slojevi;

        public Red(@NonNull View itemView) {
            super(itemView);
            slojevi = itemView.findViewById(R.id.slojevi);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemClickListener!=null){
                itemClickListener.onItemClick(luka.get(getAdapterPosition()));
            }
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(Luk luk);
    }

}
