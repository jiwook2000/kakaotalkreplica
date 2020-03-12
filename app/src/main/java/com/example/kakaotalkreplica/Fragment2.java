package com.example.kakaotalkreplica;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootVIew = (ViewGroup) inflater.inflate(R.layout.fragment2,container,false);

        Bundle extra = this.getArguments();
        final String id = extra.getString("id");
        final String pw = extra.getString("pw");


        Button btn = rootVIew.findViewById(R.id.Button_Chat);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChattingActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("pw",pw);


                startActivity(intent);

            }
        });


        return rootVIew;

    }


}
