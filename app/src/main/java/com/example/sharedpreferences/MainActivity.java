package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSalvar;
    private TextInputEditText editNome;
    private TextView textResultado;

    /*Fornece um nome para as preferências - vamos declarar que o valor vai ser o mesmo para todas as intâncias (static)
    e final para ser um valor fixo ou imutável. Será esse nome de arquivo que irá salvar pequenos dados no aparelho
    do usuário. É esse arquivo que vai ser salvo ou recuperado (para recuperar alguma informação) no aparelho do usuário. */
    private static final String ARQUIVO_PREFERENCE = "ArquivoPreferencia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        editNome = findViewById(R.id.editNome);
        textResultado = findViewById(R.id.textResultado);

        // Evento de Click
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* Salva dados diretamente no aparalho do usuário - Essa classe cria um arquivo xml e dentro
                   desse arquivo salva as informações. Essa funcionalidade é utilizada para salvar pequenos dados,
                   como por exemplo, salvar algumas configurações do app feita pelo usuário ou informações básicas
                   como por exemplo, o nome da pessoa ...
                   É passado por parâmetro o nome para as preferencias e o modo de acesso, que no caso, o modo
                   0 (zero) é privado*/
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCE, 0);

                // Retorna um objeto para poder fazer a edição. Ele é do tipo Editor.
               SharedPreferences.Editor editor = preferences.edit();

               // Validar o nome para o caso do usuário não digitar nada
                if(editNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Preencha o nome", Toast.LENGTH_LONG);
                }else{
                    String nome = editNome.getText().toString();

                    // Chave única como o primeiro argumento (key) - para recuperar o valor armazenado.
                    editor.putString("nome", nome);

                    // Salva os dados.
                    editor.commit();

                    // Gerando o nome na tela
                    textResultado.setText("Olá, " + nome);
                }
            }
        });
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
 * Para começar a usar as Shared Preferences em um aplicativo Android, siga estes passos:
 *
 * Criar as Shared Preferences: No contexto da sua atividade ou fragmento, você pode chamar o método
 * getSharedPreferences() para obter uma instância das Shared Preferences. Você precisa fornecer um nome para as
 * preferências e um modo de acesso, que geralmente é MODE_PRIVATE (ou 0) para indicar que somente o seu aplicativo
 * pode acessar essas preferências.
 *
 * Editar as Shared Preferences: Para editar as preferências e adicionar pares de valores, você pode usar o método
 * edit() para obter um objeto Editor.
 *
 * Os métodos putString(), putInt() e putBoolean() são utilizados para armazenar diferentes tipos de valores nas
 * Shared Preferences no Android. Aqui está uma explicação de cada um deles:
 *
 * -> putString(String key, String value): Esse método é usado para armazenar uma string nas Shared Preferences.
 *    Você precisa fornecer uma chave única como o primeiro argumento (key), que será usada posteriormente para
 *    recuperar o valor armazenado. O segundo argumento (value) é a string que você deseja armazenar. Por exemplo,
 *    acima estamos salvando a recuperação de um nome, mas poderiamos recuperar um configuração estabelecida pelo
 *    o usuario, como por exemplo um argumento para salvar uma cor, logo o name seria "cor":
 *    editor.putString("cor", cor);
 *
 * -> putInt(String key, int value): Esse método é usado para armazenar um valor inteiro nas Shared Preferences.
 *    Assim como o método putString(), você precisa fornecer uma chave única (key) e o valor inteiro (value) que
 *    deseja armazenar. Por exemplo:
 *    editor.putInt("chave_int", 123);
 *
 * -> putBoolean(String key, boolean value): Esse método é usado para armazenar um valor booleano nas Shared
 *    Preferences. Novamente, você precisa fornecer uma chave única (key) e o valor booleano (value) que deseja
 *    armazenar. Por exemplo:
 *    editor.putBoolean("chave_boolean", true);
 *
 * Esses métodos são usados ​​juntamente com um objeto Editor (retornado pelo método edit() das Shared Preferences)
 * para adicionar ou atualizar pares de valores nas preferências. Depois de adicionar todos os valores desejados,
 * você deve chamar o método commit() ou apply() no objeto Editor para confirmar as alterações e torná-las
 * persistentes nas Shared Preferences.
 *
 * É importante lembrar que, ao recuperar os valores das Shared Preferences, você precisa usar a mesma chave fornecida
 * durante o armazenamento para obter o valor correto. Além disso, é possível fornecer um valor padrão como segundo
 * argumento nos métodos de recuperação (getString(), getInt(), getBoolean()) para ser retornado caso a chave fornecida
 * não seja encontrada nas preferências. Isso é útil para evitar possíveis erros caso uma chave ainda não tenha sido
 * adicionada ou tenha sido removida.
 *
 *
 * */