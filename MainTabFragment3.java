package com.example.oheunji.chungmuro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class MainTabFragment3 extends Fragment {
    View view;
    TextView Frag3_reservation, Frag3_address, Frag3_tell, Frag3_time, Frag3_mywait, Frag3_wait;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment3, container, false);

        //SharedPreferences test = getSharedPreferences("test", MODE_PRIVATE);
        final SharedPreferences test =  getActivity().getSharedPreferences("test",MODE_PRIVATE);
        final String firstData = test.getString("store_reserv", "");
        final int waiting = test.getInt("wait_num", 0);
        final String add_reserv = test.getString("add_reserv","");
        final String tell_reserv = test.getString("tell_reserv","");
        final String time_reserv = test.getString("time_reserv","");


        Frag3_reservation=(TextView) view.findViewById(R.id.Frag3_reservation);
        Frag3_address=(TextView) view.findViewById(R.id.Frag3_address);
        Frag3_tell=(TextView) view.findViewById(R.id.Frag3_tell);
        Frag3_time=(TextView) view.findViewById(R.id.Frag3_time);
        Frag3_mywait=(TextView) view.findViewById(R.id.Frag3_mywait);
        Frag3_wait=(TextView) view.findViewById(R.id.Frag3_wait);

        Frag3_reservation.setText(firstData);
        Frag3_mywait.setText(waiting+"번");
        Frag3_wait.setText(waiting+"명");
        Frag3_address.setText(add_reserv);
        Frag3_tell.setText(tell_reserv);
        Frag3_time.setText(time_reserv);
        Button cancel=(Button) view.findViewById(R.id.Frag3_resev_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = test.edit();
                editor.putString("store_reserv", "예약된 식당이 없습니다"); //First라는 key값으로 infoFirst 데이터를 저장한다.
                editor.putInt("wait_num", 0); //Second라는 key값으로 infoSecond 데이터를 저장한다.
                editor.putString("add_reserv",""); //주소 저장
                editor.putString("tell_reserv",""); // 전화번호 저장
                editor.putString("time_reserv",""); // 영업시간 저장
                editor.commit();

                Toast.makeText(getActivity(), "얘약이 취소되었습니다", Toast.LENGTH_LONG).show();
                Frag3_reservation.setText(firstData);
                Frag3_mywait.setText(waiting+"번");
                Frag3_wait.setText(waiting+"명");
                Frag3_address.setText(add_reserv);
                Frag3_tell.setText(tell_reserv);
                Frag3_time.setText(time_reserv);
                onStart();


            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        SharedPreferences test =  getActivity().getSharedPreferences("test",MODE_PRIVATE);
        String firstData = test.getString("store_reserv", "");
        int waiting = test.getInt("wait_num", 0);
        final String add_reserv = test.getString("add_reserv","");
        final String tell_reserv = test.getString("tell_reserv","");
        final String time_reserv = test.getString("time_reserv","");

        Frag3_reservation.setText(firstData);
        Frag3_mywait.setText(waiting+"번");
        Frag3_wait.setText(waiting+"명");
        Frag3_address.setText(add_reserv);
        Frag3_tell.setText(tell_reserv);
        Frag3_time.setText(time_reserv);
        //textView.setText(firstData);

    }

}