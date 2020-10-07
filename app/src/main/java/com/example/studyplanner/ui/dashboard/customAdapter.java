package com.example.studyplanner.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studyplanner.R;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class customAdapter extends RecyclerView.Adapter<customAdapter.MyView> {

    List<Student> studentList;
    public customAdapter(List<Student> studentList)
    {
        this.studentList = studentList;
    }
    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
//        MyView mv = new MyView(view, mListener);

        return new MyView(view);
    }

    public void updateData(List<Student> newData) {
        this.studentList.clear();
        studentList.addAll(newData);
        notifyDataSetChanged();
    }

//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, List<Student> data) {
        studentList.addAll(position, data);
        notifyItemInserted(position);
    }

//    // Remove a RecyclerView item containing a specified Data object
//    public void remove(Data data) {
//        int position = list.indexOf(data);
//        list.remove(position);
//        notifyItemRemoved(position);
//    }


    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        Student student = studentList.get(position);
        holder.valSub.setText(student.getSubName());
        holder.valTest.setText(student.getTest());
        holder.valDate.setText(student.getDate());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }



    class MyView extends RecyclerView.ViewHolder
    {
        TextView  valSub,valTest,valDate;
        public MyView(@NonNull View itemView) {
            super(itemView);
            valSub = itemView.findViewById(R.id.subname);
            valTest = itemView.findViewById(R.id.test);
            valDate = itemView.findViewById(R.id.date);
        }
    }
}

