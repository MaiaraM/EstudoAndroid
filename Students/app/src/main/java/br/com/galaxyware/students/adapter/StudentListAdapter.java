package br.com.galaxyware.students.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

import br.com.galaxyware.students.R;
import br.com.galaxyware.students.model.Student;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {
    private final List<Student> mStudentsList;
    private final Context context;
    private OnItemClickListener onItemClickListener;

    public StudentListAdapter(List<Student> aStudentsList, Context context) {
        this.mStudentsList = aStudentsList;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewCreated =LayoutInflater.from(context).inflate(R.layout.activity_card_students, viewGroup, false);
        return new StudentViewHolder(viewCreated);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {
        System.out.println(mStudentsList);
        Student student = mStudentsList.get(i);
        studentViewHolder.link(student);
    }

    @Override
    public int getItemCount() {
        return mStudentsList.size();
    }



    public class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView telephono;
        ImageView foto;
        private Student student;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.card_image);
            name = itemView.findViewById(R.id.card_nome);
            telephono = itemView.findViewById(R.id.card_telefone);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(student, getAdapterPosition());
                }
            });
        }

        public void link(Student aStudent) {
            this.student = aStudent;
            name.setText(aStudent.getName());
            telephono.setText(aStudent.getTelephone());

        }

    }

    public void add(Student aStudent){
        mStudentsList.add(aStudent);
        notifyDataSetChanged();
    }

    public void update(int position, Student movie) {
        mStudentsList.set(position, movie);
        notifyItemChanged(position);
    }

    public void remove(int position) {
        mStudentsList.remove(position);
        notifyItemRemoved(position);
    }

    public void chage(int startPosition, int endPosition) {
        Collections.swap(mStudentsList, startPosition,endPosition );
        notifyItemMoved(startPosition,endPosition);
    }
}
