
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1, button2, button3,buttonmul,buttondiv,buttoncos,buttontan;
    private TextView result;
    private EditText fn, sn;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void init() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        buttonmul = (Button) findViewById(R.id.buttonmul);
        buttondiv = (Button) findViewById(R.id.buttondiv);
        buttoncos = (Button) findViewById(R.id.buttoncos);
        buttontan = (Button) findViewById(R.id.buttontan);
        fn = (EditText) findViewById(R.id.fn);
        sn = (EditText) findViewById(R.id.sn);
        result = (TextView) findViewById(R.id.result);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        buttonmul.setOnClickListener(this);
        buttondiv.setOnClickListener(this);
        buttoncos.setOnClickListener(this);
        buttontan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
     {
        String num1=fn.getText().toString();
        String num2=sn.getText().toString();

        switch (v.getId())
         {
            case R.id.button1:
                int add = Integer.parseInt(num1)+Integer.parseInt(num2);
                result.setText(String.valueOf(add));
                break;

            case R.id.button2:
                int sub = Integer.parseInt(num1)- Integer.parseInt(num2);
                result.setText(String.valueOf(sub));
                break;
            case R.id.buttondiv:
                try {
                    int div = Integer.parseInt(num1) / Integer.parseInt(num2);
                    result.setText(String.valueOf(div));
                }
                catch(Exception e){
                    result.setText("Cannot divide by 0");
                }
                break;

            case R.id.buttonmul:
                int mul = Integer.parseInt(num1)* Integer.parseInt(num2);
                result.setText(String.valueOf(mul));
                break;


            case R.id.button3:
                       double ss=Math.sin(Math.toRadians(Double.parseDouble(num2)));
                result.setText(String.valueOf(ss));
                break;
            case R.id.buttoncos:
                if(Double.parseDouble(num2)==0)
                {
                    result.setText("The result is infinite");
                }

                { 
                 double sc = Math.cos(Math.toRadians(Double.parseDouble(num2)));
                    result.setText(String.valueOf(sc));
                }

                break;
            case R.id.buttontan:

                    if(Double.parseDouble(num2)==90)
                    {
                        result.setText("The result is infinite");
                    }
                    else {
                        double st = Math.tan(Math.toRadians(Double.parseDouble(num2)));
                        result.setText(String.valueOf(st));

                    }
                break;
        }

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.sagar_mamdapure.neha/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.sagar_mamdapure.neha/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
