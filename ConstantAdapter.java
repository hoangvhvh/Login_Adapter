package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.coolstyles.demologin.R;

public class ConstantAdapter extends RecyclerView.Adapter<ConstantAdapter.ViewHolder> {
    String dataList[];
    public ConstantAdapter(String dataList[]){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_constant, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(dataList[position]);
    }

    @Override
    public int getItemCount() {
        return dataList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvPrefix;
        public TextView tvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPrefix = itemView.findViewById(R.id.tv_prefix);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
