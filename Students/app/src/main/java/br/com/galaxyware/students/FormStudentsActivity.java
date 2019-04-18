package br.com.galaxyware.students;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import br.com.galaxyware.students.helper.U;
import br.com.galaxyware.students.model.Student;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FormStudentsActivity extends AppCompatActivity {

    private int positionReceived = U.INVALID_POSITION;

    @BindView(R.id.form_student_name)
    TextInputEditText txtName;
    @BindView(R.id.form_student_email)
    TextInputEditText txtEmail;
    @BindView(R.id.form_student_telephone)
    TextInputEditText txtTelephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_students);
        ButterKnife.bind(this);

        getEdited();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_menu_save) {
            Student student = new Student(txtName.getText().toString(),txtEmail.getText().toString() ,txtTelephone.getText().toString());
            Intent resultado = new Intent();
            resultado.putExtra(U.KEY_STUDENT, student);
            resultado.putExtra(U.POSITION, positionReceived);
            setResult(Activity.RESULT_OK, resultado);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getEdited() {
        Intent dataReceived = getIntent();
        if(dataReceived.hasExtra(U.KEY_STUDENT)){
            Student studentReceived = (Student) dataReceived.getSerializableExtra(U.KEY_STUDENT);
            positionReceived = dataReceived.getIntExtra(U.POSITION, U.INVALID_POSITION);
            txtName.setText(studentReceived.getName());
            txtEmail.setText(studentReceived.getEmail());
            txtTelephone.setText(studentReceived.getTelephone());
        }
    }
}
