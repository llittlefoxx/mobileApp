package rev.dali.mohamedalitlili;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClick(View v){
        Intent intent=new Intent(MenuActivity.this,Redaction.class);
        switch (v.getId()){
            case R.id.hightech:
                intent.putExtra("title","High-Tech");
                break;
            case R.id.politique:
                intent.putExtra("title","Politique");
                break;
            case R.id.culture:
                intent.putExtra("title","culture");
                break;
            case R.id.sport:
                intent.putExtra("title","Sport");
                break;
        }
        startActivity(intent);

    }
}
