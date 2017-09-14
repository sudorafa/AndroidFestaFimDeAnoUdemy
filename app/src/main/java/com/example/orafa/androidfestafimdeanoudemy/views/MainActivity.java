package com.example.orafa.androidfestafimdeanoudemy.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.orafa.androidfestafimdeanoudemy.R;
import com.example.orafa.androidfestafimdeanoudemy.constantes.FimDeAnoConstants;
import com.example.orafa.androidfestafimdeanoudemy.util.SecurityPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textToday = (TextView) findViewById(R.id.text_today);
        this.mViewHolder.textDaysLeft = (TextView) findViewById(R.id.text_days_left);
        this.mViewHolder.buttonConfirm = (Button) findViewById(R.id.button_confirm);

        this.mViewHolder.buttonConfirm.setOnClickListener(this);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.verifyPreference();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_confirm) {
            //pegar a key da rederida constant
            String presence = this.mSecurityPreferences.getStoredString(FimDeAnoConstants.PRESENCE);
            //diz qual activity chamará
            Intent intent = new Intent(this, DetailsActivity.class);

            //passar dados para a
            intent.putExtra(FimDeAnoConstants.PRESENCE, presence);

            //chama a activity
            startActivity(intent);
        }
    }

    private static class ViewHolder {
        TextView textToday;
        TextView textDaysLeft;
        Button buttonConfirm;
    }

    //Pegar valor do secPref... para mudar o valor do buuton
    private void verifyPreference() {
        String presence = this.mSecurityPreferences.getStoredString(FimDeAnoConstants.PRESENCE);
        if (presence.equals("")) {
            this.mViewHolder.buttonConfirm.setText(R.string.nao_confirmado);
        } else if (presence.equals(FimDeAnoConstants.CONFIRMED_WILL_GO)) {
            this.mViewHolder.buttonConfirm.setText(R.string.sim);
        } else {
            this.mViewHolder.buttonConfirm.setText(R.string.nao);
        }
    }
}