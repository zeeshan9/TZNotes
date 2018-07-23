package com.example.dell.tznotes.Controller.Notes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.dell.tznotes.R;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    String[] names = {"Tahir","Zeeshan","Ali"};
    String[] courses = {"SE","CS","EE"};


    public NotesAdapter(){


    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int IdOfLayout = R.layout.note_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(IdOfLayout,parent,false);
        NotesViewHolder notesViewHolder = new NotesViewHolder(view);

        return notesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        TextView detailOverviewTextView;

        public NotesViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.title_text_view);
            detailOverviewTextView = (TextView) itemView.findViewById(R.id.detail_overview_text_view);
        }
        void bind(int listIndex){

            titleTextView.setText(names[listIndex]);
            detailOverviewTextView.setText(courses[listIndex]);

        }
    }
}
