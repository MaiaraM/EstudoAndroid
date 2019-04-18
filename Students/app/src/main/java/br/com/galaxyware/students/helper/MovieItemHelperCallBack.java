package br.com.galaxyware.students.helper;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import br.com.galaxyware.students.adapter.StudentListAdapter;
import br.com.galaxyware.students.dao.DaoStudent;
import br.com.galaxyware.students.model.Student;

public class MovieItemHelperCallBack extends ItemTouchHelper.Callback {

    private final StudentListAdapter adapter;

    public MovieItemHelperCallBack(StudentListAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int markSwiped = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int markMove = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP;
        return makeMovementFlags(markMove, markSwiped);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        new DaoStudent().troca(viewHolder.getAdapterPosition(),target.getAdapterPosition() );
        adapter.chage(viewHolder.getAdapterPosition(),target.getAdapterPosition() );
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        new DaoStudent().remove(viewHolder.getAdapterPosition());
        adapter.remove(viewHolder.getAdapterPosition());
    }
}
