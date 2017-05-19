package basecolumn;

import android.provider.BaseColumns;

/**
 * Created by dali on 26/11/2016.
 */
public class ExamContract {
    private ExamContract(){

    }
    public static class ExamEntity implements BaseColumns {

        public static final String TABLE_NAME="examen";
        public static final String  COLUMN_TITLE="title";
        public static final String COLUMN_DESCRIPTION="desc";
        public static final String COLUMN_VISI="visiblility";
    }
}
