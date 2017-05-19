package rev.dali.mohamedalitlili;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import dao.ExamDAO;
import model.ExamModel;

public class Redaction extends AppCompatActivity {

    TextView title;
    Switch aSwitch;
    EditText titreArticle;
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redaction);
        title = (TextView) findViewById(R.id.mytitle);
        aSwitch = (Switch) findViewById(R.id.switch1);
        titreArticle=(EditText) findViewById(R.id.titrearticle);
        description=(EditText) findViewById(R.id.desc);

        String titleIntent = getIntent().getStringExtra("title");
        title.setText(titleIntent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.save:
                ExamModel em=new ExamModel();
                em.setTitle(titreArticle.getText().toString());
                em.setDescription(description.getText().toString());
                if (aSwitch.isChecked()){
                    em.setVisibility("visible");
                }else{
                    em.setVisibility("not-visible");
                }
                ExamDAO dao=new ExamDAO(this);
                long itemID=dao.insertGuess(em);
                Toast.makeText(this,"id is : "+itemID,Toast.LENGTH_LONG).show();
                break;
            case R.id.show:
                Intent intent=new Intent(Redaction.this,Articles.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}
