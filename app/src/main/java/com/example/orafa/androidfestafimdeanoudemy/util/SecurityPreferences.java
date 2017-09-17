package com.example.orafa.androidfestafimdeanoudemy.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by o Rafa on 13/09/2017.
 */

public class SecurityPreferences {

    private final SharedPreferences mSharedPreferences;

    //Context.MODE_PRIVATE == Apenas essa app ter as informações
    public SecurityPreferences(Context context) {
        this.mSharedPreferences = context.getSharedPreferences("FimDeAno", Context.MODE_PRIVATE);
    }

    //Salvar valor enviado pra cá a partir da key
    public void storeString(String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    //Recuperar o método armazenado aqui
    public String getStoredString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }
}
