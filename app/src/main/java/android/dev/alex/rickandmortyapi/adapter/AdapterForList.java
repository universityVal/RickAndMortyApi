package android.dev.alex.rickandmortyapi.adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.dev.alex.rickandmortyapi.R;
import android.dev.alex.rickandmortyapi.model.Location;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


import java.util.List;

public class AdapterForList extends RecyclerView.Adapter<AdapterForList.ViewHolder> {

    private List<Location> listLocation;
    private Context context;

    public AdapterForList(List<Location> listLocation, Context context) {
        this.listLocation = listLocation ;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Location location = listLocation.get(position);

        viewHolder.textviewId.setText(String.valueOf(location.getId()));
        viewHolder.textviewName.setText(location.getName());
        viewHolder.textviewType.setText(location.getType());
        viewHolder.textviewDemension.setText(location.getDemension());
        viewHolder.textviewURl.setText(location.getURl());
        viewHolder.textviewCreated.setText(location.getCreated());


    }

    @Override
    public int getItemCount() {
        return listLocation.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textviewId;
        public TextView textviewName;
        public TextView textviewType;
        public TextView textviewDemension;
        public TextView textviewURl;
        public TextView textviewCreated;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textviewId= (TextView) itemView.findViewById(R.id.textviewId);
            textviewName= (TextView) itemView.findViewById(R.id.textviewName);
            textviewType= (TextView) itemView.findViewById(R.id.textviewType);
            textviewDemension= (TextView) itemView.findViewById(R.id.textviewDemension);
            textviewURl= (TextView) itemView.findViewById(R.id.textviewURl);
            textviewCreated= (TextView) itemView.findViewById(R.id.textviewCreated);
        }
    }
}
