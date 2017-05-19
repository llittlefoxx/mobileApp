package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import basecolumn.ExamContract;
import model.ExamModel;
import sqllite.ExamHelper;

/**
 * Created by dali on 26/11/2016.
 */
public class ExamDAO {
    ExamHelper examHelper;

    public ExamDAO(Context context) {
        examHelper = new ExamHelper(context);
    }

    public long insertGuess(ExamModel exam){
        SQLiteDatabase db = examHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ExamContract.ExamEntity.COLUMN_TITLE, exam.getTitle());
        cv.put(ExamContract.ExamEntity.COLUMN_DESCRIPTION, exam.getDescription());
        cv.put(ExamContract.ExamEntity.COLUMN_VISI, exam.getVisibility());
        return db.insert(ExamContract.ExamEntity.TABLE_NAME, null, cv);

    }


    public List<ExamModel> getAllRes() {
        SQLiteDatabase db = examHelper.getReadableDatabase();
        Cursor cursor = db.query(ExamContract.ExamEntity.TABLE_NAME, null, null, null, null, null, null, null);
        cursor.moveToFirst();
        List<ExamModel> allres = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            if(cursorToReservation(cursor).getVisibility().equals("visible")){
                allres.add(cursorToReservation(cursor));
            }

            cursor.moveToNext();
        }
        cursor.close();
        return allres;
    }



    private ExamModel cursorToReservation(Cursor cursor) {
        ExamModel res = new ExamModel();
        res.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(ExamContract.ExamEntity.COLUMN_TITLE)));
        res.setDescription(cursor.getString(cursor.getColumnIndexOrThrow(ExamContract.ExamEntity.COLUMN_DESCRIPTION)));
        res.setVisibility(cursor.getString(cursor.getColumnIndexOrThrow(ExamContract.ExamEntity.COLUMN_VISI)));
        return res;
    }
}
