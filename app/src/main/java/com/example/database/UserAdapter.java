package com.example.database;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class UserAdapter extends FirestoreRecyclerAdapter <User, UserAdapter.UserHolder>{
    private OnItemClickListener listener;

    public UserAdapter(@NonNull FirestoreRecyclerOptions<User> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull UserHolder holder, int position, @NonNull User model) {
        holder.textViewName.setText(model.getName());
        Log.d("Holder", "Model " + model.toString());
        holder.textViewAge.setText(model.getAge());
        holder.textViewHeight.setText(Double.toString(model.getHeight()));
        holder.textViewWeight.setText(Double.toString(model.getWeight()));
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new UserHolder(v);
    }

    public void deleteItem(int position){
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class UserHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        TextView textViewAge;
        TextView textViewHeight;
        TextView textViewWeight;

        public BookHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.rec_name);
            textViewAge = itemView.findViewById(R.id.rec_age);
            textViewHeight = itemView.findViewById(R.id.rec_height);
            textViewWeight = itemView.findViewById(R.id.rec_weight);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getBindingAdapterPosition();
                    if(position != RecyclerView.NO_POSITION && listener != null)
                    {
                        listener.onItemClick(getSnapshots().getSnapshot(position), position);
                    }

                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

}
