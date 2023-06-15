package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

/* Anotações:
*
* As Shared Preferences são um mecanismo de armazenamento leve e simples fornecido pelo Android para armazenar
* pequenas quantidades de dados-chave em pares de valor. Elas são amplamente utilizadas para armazenar configurações
* e preferências de um aplicativo.
*
* Com as Shared Preferences, você pode armazenar dados primitivos, como inteiros, strings, booleanos, floats e longs.
* Elas são armazenadas como um arquivo XML no sistema de arquivos do aplicativo, tornando-as persistentes mesmo depois
* que o aplicativo é fechado. As Shared Preferences são geralmente usadas para armazenar preferências do usuário, como
* configurações de idioma, informações de login, preferências de exibição e outras opções personalizadas.
*
* */