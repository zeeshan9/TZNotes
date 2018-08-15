package com.example.dell.tznotes.Controller.Notes;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.tznotes.Model.NotesContractProviderModel;
import com.example.dell.tznotes.R;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    Cursor mCursor;


    public TodoAdapter(Cursor cursor){
        mCursor = cursor;
    }

    @NonNull
    @Override
    public TodoAdapter.TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int IdOfLayout = R.layout.todo_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(IdOfLayout,parent,false);
        TodoViewHolder todoViewHolder = new TodoViewHolder(view);


        return todoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        holder.bind(position);
    }



    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        TextView detailOverviewTextView;

        public TodoViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.todo_title_text_view);
            detailOverviewTextView = (TextView) itemView.findViewById(R.id.todo_detail_overview_text_view);
        }
        void bind(int listIndex){
            if(mCursor!=null){
                mCursor.moveToPosition(0);
                mCursor.moveToPosition(listIndex);

                titleTextView.setText(mCursor.getString(mCursor.getColumnIndex(NotesContractProviderModel.TodoClass.COLUMN_TODO_TITLE)));
                detailOverviewTextView.setText(mCursor.getString(mCursor.getColumnIndex(NotesContractProviderModel.TodoClass.COLUMN_TODO_DETAILS)));

                mCursor.moveToPosition(0);
            }



        }
    }

}
