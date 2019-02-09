package com.example.oheunji.chungmuro;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import android.widget.TextView;
import android.widget.

        Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class shop_detail extends AppCompatActivity {
    String mystore="";

    final String[] store={
            "다시 열린 하얀집",
            "등나무집, 동대닭한마리",
            "호남식당",
            "밥한술",
            "김치만선생",
            "솜이네 떡볶이",
            "동회루"
    };

    String[] menu={
            "낙지떡볶이(7,000)",
            "닭한마리(22,000)",
            "돼지물갈비(13,000)",
            "오돌뼈 볶음(16,000)",
            "김치찌개(6,000)",
            "떡볶이(2인 14,000)",
            "수타 짜장(6,000)"
    };

    String[] tell={
            "02-2278-5953",
            "02-2269-5596",
            "02-2273-1348",
            "02-2268-0263",
            "02-6052-5526",
            "02-2285-2478",
            "02-2265-3345"
    };

    String[] map={
            "서울 중구 서애로 12-20 ",
            "서울 중구 서애로 16-5",
            "서울 중구 퇴계로41길 9",
            "서울 중구 퇴계로42길 14",
            "서울 중구 필동로 30-1",
            "서울 중구 퇴계로42길 36",
            "서울 중구 퇴계로 200"
    };

    String[] time={
            "매일 17:00 - 04:00",
            "매일 11:00 - 23:00 주말 11:00 - 22:00",
            "매일 12:00 - 22:30 일요일 휴무",
            "",
            "매일 11:00 - 23:30",
            "브레이크타임 15:00 - 17:00 일요일 휴무",
            "매일 11:00 - 22:00"
    };



    int[] code={
            0,
            0,
            0,
            0,
            0,
            0,
            0
    };



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_detail);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "MoneyBook.db", null, 1);
        //final DBHelper dbHelper = new DBHelper(getApplicationContext(),code[position].+"db",null,1);
        final TextView etresult = (TextView) findViewById(R.id.result);
        final EditText etDate = (EditText) findViewById(R.id.date);
        final EditText etitem = (EditText) findViewById(R.id.item);
        final RatingBar etprice = (RatingBar)findViewById(R.id.price);
        final TextView etstore= (TextView)findViewById(R.id.store);
        final TextView wait = (TextView) findViewById(R.id.wait);

        final SharedPreferences test = getSharedPreferences("test", MODE_PRIVATE);
        final String firstData = test.getString("store_reserv", "");

        Intent in=getIntent();
        int image=in.getIntExtra("image",0);
        final int position=in.getIntExtra("position",0);
        etstore.setText(store[position]);
        ImageView iv=(ImageView) findViewById(R.id.INFO_image);

        if(firstData.equals(store[position].toString())){
            wait.setText("1");
        }

        etresult.setText(dbHelper.getResult(etstore.getText().toString()));

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

        etDate.setText(simpleDateFormat.format(date));
        //Toast.makeText(getApplicationContext(),date+item+price+store,Toast.LENGTH_SHORT).show(); 날짜, 리뷰, 평점, 식당이름

        Button insert = (Button)findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = etDate.getText().toString();
                String item = etitem.getText().toString();
                int price = (int)etprice.getRating();
                String store = etstore.getText().toString();
                if (!item.equals("")){
                    dbHelper.insert(date,store,price,item);
                    etresult.setText(dbHelper.getResult(store));
                    Toast.makeText(getApplicationContext(),"별점 및 리뷰가 등록되었습니다.",Toast.LENGTH_SHORT).show();
                    etprice.setRating(0);
                    etitem.setText(null);
                }
                else {
                    Toast.makeText(getApplicationContext(),"리뷰를 등록해주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });


        TextView title1=(TextView) findViewById(R.id.INFO_title1);

        TextView info1=(TextView) findViewById(R.id.INFO_info1);
        TextView title2=(TextView) findViewById(R.id.INFO_title2);

        TextView info2=(TextView) findViewById(R.id.INFO_info2);
        TextView title3=(TextView) findViewById(R.id.INFO_title3);

        TextView info3=(TextView) findViewById(R.id.INFO_info3);
        TextView title4=(TextView) findViewById(R.id.INFO_title4);
        TextView info4=(TextView) findViewById(R.id.INFO_info4);

        TextView title5=(TextView) findViewById(R.id.INFO_title5);
        TextView info5=(TextView) findViewById(R.id.INFO_info5);



        title1.setText("");
        title2.setText("전화번호");
        title3.setText("위치");
        title4.setText("대표메뉴");
        title5.setText("영업시간");
        info1.setText("");

        info2.setText(tell[position]);
        info3.setText(map[position]);

        info4.setText(menu[position]);
        info5.setText(time[position]);

        // rating=ratingBar.getNumStars();
        //review=etitem.getText().toString();

        title3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv.setImageResource(image);

        iv.setMaxHeight(600);
        iv.setMaxWidth(500);
        iv.setMinimumHeight(600);
        iv.setMinimumWidth(500);


        Button reserve = (Button) findViewById(R.id.reservation);
        reserve.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick (View view){

                final SharedPreferences test = getSharedPreferences("test", MODE_PRIVATE);
                final String firstData = test.getString("store_reserv", "");

                if(firstData.equals(store[position])) {
                    Toast.makeText(getApplicationContext(), "이미 예약 되어있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!firstData.equals("예약된 식당이 없습니다")) {
                    Toast.makeText(getApplicationContext(), "다른가게에 예약이 되어있습니다.\n예약을 먼저 취소해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }


                code[position]++;
                //내가 예약한 식당 이름 저장변수
                mystore = store[position];

                final List<String> selectedItems = new ArrayList<>();
                selectedItems.add("예약 확인");
                selectedItems.add("예약 취소");
                final int pos = position;
                final CharSequence[] items = selectedItems.toArray(new String[selectedItems.size()]);
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(shop_detail.this);
                dialogBuilder.setTitle(mystore);
                dialogBuilder.setMessage("고객님의 대기 번호는 "+code[position]+"번 입니다. 한 팀당 예상 대기 시간은 각 15분입니다.\n"+"고객님의 대기 현황은 나의 대기 번호 메뉴에서 확인 가능합니다.");
                dialogBuilder.setCancelable(false);
                dialogBuilder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!firstData.equals(store[position])) {
                            SharedPreferences.Editor editor = test.edit();
                            editor.putString("store_reserv", store[position]); //First라는 key값으로 infoFirst 데이터를 저장한다.
                            editor.putInt("wait_num", code[position]); //Second라는 key값으로 infoSecond 데이터를 저장한다.
                            editor.putString("add_reserv",map[position]);
                            editor.putString("tell_reserv",tell[position]);
                            editor.putString("time_reserv",time[position]);
                            editor.commit();
                            Toast.makeText(shop_detail.this, "예약확인", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            //else문 필요없음 unreachable
                            Toast.makeText(getApplicationContext(), "이미 예약 되어있습니다.", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
                dialogBuilder.setNegativeButton("예약 취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(shop_detail.this, "예약이 취소되었습니다.", Toast.LENGTH_SHORT).show();
                        code[position] --;
                        dialog.cancel();
                    }
                });


                AlertDialog alertDialogObject = dialogBuilder.create();
                alertDialogObject.show();

            }
        });


    }

}

