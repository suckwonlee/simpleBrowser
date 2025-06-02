package kr.ac.kopo.simplebrowser;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editUrl;
    Button btnGo,btnBack;
    WebView web1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.browser);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editUrl = findViewById(R.id.editUrl);
        btnGo   = findViewById(R.id.btnGo);
        btnBack = findViewById(R.id.btnBack);
        web1    = findViewById(R.id.web1);


        web1.setWebViewClient(new AIWebViewClient());

        WebSettings settings=web1.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);

        btnGo.setOnClickListener(btnListener);
        btnBack.setOnClickListener(btnListener);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    View.OnClickListener btnListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btnEvent=(Button) v;
            if(btnEvent==btnGo){
                web1.loadUrl(editUrl.getText().toString());
            }else {
                web1.goBack();
            }
        }
    };
    class AIWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            return super.shouldOverrideUrlLoading(view, url);
        }

    }


}