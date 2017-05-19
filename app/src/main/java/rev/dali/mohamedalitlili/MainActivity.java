package rev.dali.mohamedalitlili;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText motdepasse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.email);
        motdepasse=(EditText)findViewById(R.id.mdp);

    }

    public void onClick(View v){
        Intent intent=new Intent(MainActivity.this,MenuActivity.class);
        switch (v.getId()){
            case R.id.valider:
                startActivity(intent);
                break;
            case R.id.Annuler:
                email.setText("");
                motdepasse.setText("");
                break;

        }


    }
}
