package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSONObject;

public class LoginFragment extends Fragment {

    private Button button;
    private EditText user_edit;
    private EditText password_edit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_login,container,false);

        return  view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = (Button) getActivity().findViewById(R.id.Login_Btn);
        user_edit = getActivity().findViewById(R.id.accountEt1);
        password_edit = getActivity().findViewById(R.id.pwdEt1);
        button.setOnClickListener(view -> {
            String flag = "login";
            Intent intent = new Intent(getActivity(),LoginWait.class);
            intent.putExtra("flag",flag);
           startActivity(intent);

        });
    }

}
