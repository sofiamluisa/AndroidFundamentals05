package com.android.androidfundamentalsgroup1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private List<Student> students;
    private Context context;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.students = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {

        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFAF8FD"));
        }

        Student currentStudent = students.get(position);
        holder.getTextViewFirstName().setText(currentStudent.getFirstName());
        holder.getTextViewLastName().setText(currentStudent.getLastName());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
