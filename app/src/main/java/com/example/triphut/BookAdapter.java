package com.example.triphut;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class BookAdapter extends FirebaseRecyclerAdapter<BookModel,BookAdapter.myviewholder> {


    public BookAdapter(@NonNull FirebaseRecyclerOptions<BookModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull BookModel model) {
        holder.bnametext.setText(model.getName());
        holder.bnumtext.setText(model.getPhone());
        holder.bstatustext.setText(convertCodetoStatus(model.getStatus()));

    }

    private String convertCodetoStatus(String status) {
        if(status.equals("0"))
            return "Booking Placed. Please Wait For Confirmation";
        else if(status.equals("1"))
            return "To be Confirmed";
        else
            return "Confirmed";
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_layout,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        TextView bnametext,bnumtext,bstatustext;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            bnametext=itemView.findViewById(R.id.order_name);
            bnumtext=itemView.findViewById(R.id.order_phone);
            bstatustext=itemView.findViewById(R.id.order_status);
        }
    }
}
