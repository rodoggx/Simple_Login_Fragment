package com.example.simplefragmentlogin;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mFrame, new LoginFragment())
                .commit();
    }

    public static class WelcomeFragment extends Fragment {

        private TextView welcomeView;

        public WelcomeFragment() {

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater,
                                 @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.welcome,
                    container, false);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            welcomeView = (TextView) view.findViewById(R.id.welcomeTxt);
            welcomeView.setText("Welcome " + userName + "!");
        }
    }

    public static class LoginFragment extends Fragment {

        private EditText loginTxt;
        private Button loginBtn;

        public LoginFragment() {

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.login,
                    container, false);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            loginBtn = (Button) view.findViewById(R.id.loginBtn);
            loginTxt = (EditText) view.findViewById(R.id.loginUser);

            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    userName = loginTxt.getText().toString();
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.mFrame, new WelcomeFragment())
                            .commit();
                }
            });
        }
    }
}
