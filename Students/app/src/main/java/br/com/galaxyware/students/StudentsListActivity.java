package br.com.galaxyware.students;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import br.com.galaxyware.students.adapter.OnItemClickListener;
import br.com.galaxyware.students.adapter.StudentListAdapter;
import br.com.galaxyware.students.dao.DaoStudent;
import br.com.galaxyware.students.helper.MovieItemHelperCallBack;
import br.com.galaxyware.students.helper.U;
import br.com.galaxyware.students.model.Student;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentsListActivity extends AppCompatActivity {
    @BindView(R.id.insert_student)
    TextView btnInsertStudent;
    @BindView(R.id.students_list)
    RecyclerView studentsList;

    private StudentListAdapter adapter;
    private List<Student> todos;
    DaoStudent daoStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);
        ButterKnife.bind(this);

        setRecyclerView();
        btnInsert();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode != RESULT_CANCELED){
            if(requestCode == U.REQUEST_CODE_NEW_STUDENT && data.hasExtra(U.KEY_STUDENT)){
                if(resultCode == Activity.RESULT_OK){
                Student student = getSerializableStudent(data);
                new DaoStudent().insere(student);
                adapter.add(student);
                }
            }

            if(requestCode == U.REQUEST_CODE_EDIT_STUDENT && data.hasExtra(U.KEY_STUDENT) && data.hasExtra(U.POSITION)){
                if(resultCode == Activity.RESULT_OK){
                    Student student = getSerializableStudent(data);
                    int positionReceived = data.getIntExtra(U.POSITION, U.INVALID_POSITION);
                    if (positionReceived > U.INVALID_POSITION){
                        new DaoStudent().altera(positionReceived
                                , student);
                        adapter.update(positionReceived, student);
                    }
                }
            }

        }
    }

    private Student getSerializableStudent(Intent data) {
        return (Student) data.getSerializableExtra(U.KEY_STUDENT);
    }


    private void btnInsert() {
        btnInsertStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult( new Intent(StudentsListActivity.this, FormStudentsActivity.class),U.REQUEST_CODE_NEW_STUDENT);
            }
        });
    }

    private void setRecyclerView() {
        daoStudent = new DaoStudent();
        todos = daoStudent.todos();
        adapter = new StudentListAdapter(daoStudent.todos(), StudentsListActivity.this);
        studentsList.setAdapter(adapter);
        adapterListener();
        (new ItemTouchHelper(new MovieItemHelperCallBack(adapter))).attachToRecyclerView(studentsList);
    }

    private void adapterListener() {
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Student aMovie, int position) {
                goFormEdit(aMovie, position);
            }
        });
    }

    private void goFormEdit(Student aStudent, int position) {
        Intent openEditForm = new Intent(StudentsListActivity.this, FormStudentsActivity.class);
        openEditForm.putExtra(U.KEY_STUDENT, aStudent);
        openEditForm.putExtra(U.POSITION, position);
        startActivityForResult(openEditForm, U.REQUEST_CODE_EDIT_STUDENT);
    }


}
