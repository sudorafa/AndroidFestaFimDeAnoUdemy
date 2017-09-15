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

        //habilita para mostrar na action o Icon declarado
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mSeSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = (CheckBox) findViewById(R.id.check_participate);

        this.mViewHolder.checkParticipate.setOnClickListener(this);

        this.loadDataFromActivity();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        //Lógica para salvar a resposta
        if (id == R.id.check_participate) {
            if (this.mViewHolder.checkParticipate.isChecked()) {
                this.mSeSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE, FimDeAnoConstants.CONFIRMED_WILL_GO);
            } else {
                this.mSeSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE, FimDeAnoConstants.CONFIRMED_WONT_GO);
            }
        }
    }

    //pegar dados passados da activity que chamou essa
    private void loadDataFromActivity() {
        // gegando extras (dados passados da outra activity)
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //variável para saber o que tem em FimDeAnoConstants.PRESENCE
            String presence = extras.getString(FimDeAnoConstants.PRESENCE);
            // verifica status da variavel criada para marcar ou nao o check
            if (presence.equals(FimDeAnoConstants.CONFIRMED_WILL_GO)) {
                this.mViewHolder.checkParticipate.setChecked(true);
            } else {
                this.mViewHolder.checkParticipate.setChecked(false);
            }
        }
    }

    private static class ViewHolder {
        CheckBox checkParticipate;
    }
}
