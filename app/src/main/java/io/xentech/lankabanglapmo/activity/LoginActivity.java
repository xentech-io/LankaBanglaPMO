package io.xentech.lankabanglapmo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.RotatingCircle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarException;

import io.xentech.lankabanglapmo.R;
import io.xentech.lankabanglapmo.helper.SessionManager;

public class LoginActivity extends AppCompatActivity {

    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";


    private TextView forgotPass;
    private Button loginBtn;

    private EditText userIdInput, passwordInput;
    private ProgressBar progressBar;
    private static String URL_LOGIN ="https://www.demo.sizramsolutions.com/product-1/php72/cms_mobile_app/login_info?user_name=pmo%40gmail.com&password=123456";

    private String userId;
    private String pass;

    private SessionManager session;
    private boolean isLoggedIn = false;

    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userIdInput = findViewById(R.id.login_userid);
        passwordInput = findViewById(R.id.login_password);

        forgotPass = findViewById(R.id.forgot_password);
        loginBtn = findViewById(R.id.loginBtn);

        progressBar = findViewById(R.id.progress);
        RotatingCircle rotatingCircle = new RotatingCircle();
        progressBar.setIndeterminateDrawable(rotatingCircle);


        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, ForgotPassActivity.class);
                startActivity(intent);
            }
        });


        // Session manager
        session = new SessionManager(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userId = userIdInput.getText().toString().trim();
                String pass = passwordInput.getText().toString().trim();

                if(!userId.isEmpty() || !pass.isEmpty()){
                    login(userId, pass);
                }else {
                    userIdInput.setError("Please Insert Your User ID");
                    passwordInput.setError("Please Insert Your Password");
                }
            }
        });
    }


    private void login(final String userId, final String pass){

        progressBar.setVisibility(View.VISIBLE);
        loginBtn.setVisibility(View.GONE);

        StringRequest request = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    // Check for error node in json
                    if (!error) {
                        // user successfully logged in
                        // Create login session
                        session.setLogin(true);

                        // Launch main activity
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {

                Toast.makeText(LoginActivity.this, "Error"+e.toString(), Toast.LENGTH_LONG).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("user", userId);
                params.put("pass", pass);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
}
