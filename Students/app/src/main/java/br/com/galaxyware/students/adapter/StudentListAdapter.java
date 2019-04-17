package br.com.galaxyware.students.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.galaxyware.students.R;
import br.com.galaxyware.students.model.Student;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {
    private final List<Student> mStudentsList;
    private final Context context;

    public StudentListAdapter(List<Student> mStudentsList, Context context) {
        this.mStudentsList = mStudentsList;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewCreated = LayoutInflater.from(context).inflate(R.layout.activity_form_students, viewGroup, false);
        return new StudentViewHolder(viewCreated);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
