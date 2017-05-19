package rev.dali.mohamedalitlili;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import dao.ExamDAO;
import model.ExamModel;

public class Articles extends AppCompatActivity {
    ListView lstExam;
    java.util.List<ExamModel> examList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        lstExam=(ListView)findViewById(R.id.examList);

        ExamDAO examDAO=new ExamDAO(this);
        examList=examDAO.getAllRes();
        ArrayAdapter<ExamModel> adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, examList);
        lstExam.setAdapter(adapter);
    }
}
