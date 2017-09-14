package com.example.orafa.androidfestafimdeanoudemy.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.orafa.androidfestafimdeanoudemy.R;
import com.example.orafa.androidfestafimdeanoudemy.constantes.FimDeAnoConstants;
import com.example.orafa.androidfestafimdeanoudemy.util.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSeSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSeSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = (CheckBox) findViewById(R.id.check_participate);

        this.mViewHolder.checkParticipate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        //Lógica para salvar a resposta
        if (id == R.id.check_participate) {
            if(this.mViewHolder.checkParticipate.isChecked()){
                this.mSeSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE, FimDeAnoConstants.CONFIRMED_WILL_GO);
            }else{
                this.mSeSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE, FimDeAnoConstants.CONFIRMED_WONT_GO);
            }
        }
    }

    private static class ViewHolder {
        CheckBox checkParticipate;
    }
}
