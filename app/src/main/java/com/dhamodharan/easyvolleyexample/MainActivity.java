package com.dhamodharan.easyvolleyexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.dhamodharan.easyvolley.InternetConnectionChecker;
import com.dhamodharan.easyvolley.VolleyCall;
import com.dhamodharan.easyvolley.VolleyCallback;
import java.util.HashMap;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.button1)
  Button button1;
  @BindView(R.id.button2)
  Button button2;
  @BindView(R.id.button3)
  Button button3;
  @BindView(R.id.button4)
  Button button4;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Developed by DJ", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }


  @OnClick(R.id.button1)
  public void onButton1Clicked() {
    if (InternetConnectionChecker.getInstance(this).isOnline()) {

      HashMap<String, String> payload = new HashMap<>();  // Dummy payload

      String url = "http://httpbin.org/get?param1=hello";
      VolleyCall.getResponse(MainActivity.this, url, 0, payload, new VolleyCallback() {
        @Override
        public void onSuccessResponse(JSONObject response) {

          Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(JSONObject result) {

          Toast.makeText(MainActivity.this, "No Response from server", Toast
              .LENGTH_SHORT).show();
        }

        @Override
        public void onVolleyError(String error) {

          Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();

        }


      });
    } else {

      Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
    }


  }

  @OnClick(R.id.button2)
  public void onButton2Clicked() {

    if (InternetConnectionChecker.getInstance(this).isOnline()) {

      // post data (ie: form data)
      HashMap<String, String> payload = new HashMap<>();
      payload.put("name", "Alif");
      payload.put("email", "http://itsalif.info");

      String url = "http://httpbin.org/post";
      VolleyCall.getResponse(MainActivity.this, url, 1, payload, new VolleyCallback() {
        @Override
        public void onSuccessResponse(JSONObject response) {

          Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(JSONObject result) {

          Toast.makeText(MainActivity.this, "No Response from server", Toast
              .LENGTH_SHORT).show();
        }

        @Override
        public void onVolleyError(String error) {

          Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();

        }


      });
    } else {

      Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
    }

  }

  @OnClick(R.id.button3)
  public void onButton3Clicked() {

    if (InternetConnectionChecker.getInstance(this).isOnline()) {

      // post data (ie: form data)
      HashMap<String, String> payload = new HashMap<>();
      payload.put("name", "Alif");
      payload.put("email", "http://itsalif.info");

      String url = "http://httpbin.org/put";
      VolleyCall.getResponse(MainActivity.this, url, 2, payload, new VolleyCallback() {
        @Override
        public void onSuccessResponse(JSONObject response) {

          Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(JSONObject result) {

          Toast.makeText(MainActivity.this, "No Response from server", Toast
              .LENGTH_SHORT).show();
        }

        @Override
        public void onVolleyError(String error) {

          Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();

        }


      });
    } else {

      Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
    }

  }

  @OnClick(R.id.button4)
  public void onButton4Clicked() {

    if (InternetConnectionChecker.getInstance(this).isOnline()) {

      HashMap<String, String> payload = new HashMap<>();  // Dummy payload

      String url = "http://httpbin.org/delete";
      VolleyCall.getResponse(MainActivity.this, url, 3, payload, new VolleyCallback() {
        @Override
        public void onSuccessResponse(JSONObject response) {

          Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(JSONObject result) {

          Toast.makeText(MainActivity.this, "No Response from server", Toast
              .LENGTH_SHORT).show();
        }

        @Override
        public void onVolleyError(String error) {

          Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();

        }


      });
    } else {

      Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
    }

  }
}
