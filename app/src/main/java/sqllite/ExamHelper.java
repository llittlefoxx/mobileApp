package sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import basecolumn.ExamContract;

/**
 * Created by dali on 26/11/2016.
 */
public class ExamHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "myexam.db";
    public static final String TEXT_TYPE = " TEXT";

    public static final String CREATE_EXAM_ENTRY = "CREATE TABLE " + ExamContract.ExamEntity.TABLE_NAME +
            " (" + ExamContract.ExamEntity._ID + " INTEGER PRIMARY KEY, " + ExamContract.ExamEntity.COLUMN_TITLE +
            TEXT_TYPE + "," + ExamContract.ExamEntity.COLUMN_DESCRIPTION + TEXT_TYPE +  ","+ExamContract.ExamEntity.COLUMN_VISI + TEXT_TYPE + ")";


    public ExamHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EXAM_ENTRY);
        Log.d("reached","db");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
