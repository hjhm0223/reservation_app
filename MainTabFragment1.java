package com.example.oheunji.chungmuro;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.List;

public class MainTabFragment1 extends Fragment {
    ListView list;
    ArrayAdapter<CharSequence> adspin1, adspin2;
    String choice_do = "";
    String choice_se = "";
    View view;
    boolean btn_on=false;

    final String[] dasi= {"다시 열린 하얀집"};
    final String[] dongde = {"등나무집, 동대닭한마리"};
    final String[] honam={"호남식당"};
    final String[] babhan={"밥한술"};
    final String[] kimchi={"김치만선생"};
    final String[] somyee={"솜이네 떡볶이"};
    final String[] donhwa={"동회루"};
    final String[] deado={"대도식당"};
    final String[] gangnam={"강남식당"};


    final String[] name={
            "다시 열린 하얀집",
            "등나무집, 동대닭한마리",
            "호남식당",
            "밥한술",
            "김치만선생",
            "솜이네 떡볶이",
            "동회루"
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

    String[] map1={
            "서울 강남구 신사동 634-6",
            "서울 강남구 강남대로 567"
    };

    final String[] name0={
            "등록된 식당이 없습니다."
    };

    final String[] name1={
            "대도식당",
            "강남식당"
    };

    final Integer[] image={
            R.drawable.store1,
            R.drawable.store2,
            R.drawable.store3,
            R.drawable.store4,
            R.drawable.store5,
            R.drawable.store6,
            R.drawable.store7
    };

    final Integer[] image1={
            R.drawable.store8,
            R.drawable.store9
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

    String[] tell1= {
            "02-561-2283",
            "02-321-0442"
    };



    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment1, container, false);
        final CustomList   adapter = new CustomList(getActivity()); //중구 리스트
        final CustomList0   adapter0 = new CustomList0(getActivity());//없는 리스트
        final CustomList1   adapter1 = new CustomList1(getActivity());//강남구 1개 리스트
        final Spinner spin1 = (Spinner) view.findViewById(R.id.spinner1);
        final Spinner spin2 = (Spinner) view.findViewById(R.id.spinner2);
        final Button btn_refresh = (Button) view.findViewById(R.id.button);

        // 이중 스피너
        adspin1=ArrayAdapter.createFromResource(getActivity(),R.array.spinner_do,android.R.layout.simple_spinner_dropdown_item);
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adspin1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected (AdapterView < ? > adapterView, View view,int i, long l){
                if (adspin1.getItem(i).equals("서울")) {
                    choice_do = "서울";
                    adspin2 = ArrayAdapter.createFromResource(getActivity(), R.array.spinner_do_seoul, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("인천")) {
                    choice_do = "인천";
                    adspin2 = ArrayAdapter.createFromResource(getActivity(), R.array.spinner_do_incheon, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else {
                    choice_do = adspin1.getItem(i).toString();
                    choice_se = "";
                    adspin2 = ArrayAdapter.createFromResource(getActivity(), R.array.spinner_none, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            //choice_se = "";
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected (AdapterView < ? > adapterView){
            }
        });



        btn_refresh.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick (View view){
                //Toast.makeText(getActivity(), choice_do + "=>" + choice_se, Toast.LENGTH_SHORT).show();
                btn_on=true;
                //list.setBackgroundColor(Color.WHITE);
                if (choice_se.equals("중구")){
                    list.setAdapter(adapter);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //Toast.makeText(getActivity(), choice_do + "=" + choice_se, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), shop_detail.class);
                            intent.putExtra("image", image[position]);
                            intent.putExtra("position", position);
                            startActivity(intent);
                        }
                    });
                }

                else if(choice_se.equals("강남구")) {
                    list.setAdapter(adapter1);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(getActivity(), "서비스 준비중입니다.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else if (choice_do.equals("선택")){
                    Toast.makeText(getActivity(),"시, 군/구를 선택해주세요.",Toast.LENGTH_LONG).show();
                }
                else {
                    list.setAdapter(adapter0);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(getActivity(), "등록된 식당이 없습니다.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

        list = (ListView) view.findViewById(R.id.searchlist);

        //search_text_store
        final Button buttonsearch =(Button)view.findViewById(R.id.Frag1_searchbtn);
        final EditText textsearch =(EditText)view.findViewById(R.id.Frag1_search);
        final Customdasi   Customdasi = new Customdasi(getActivity());//다시열린 1개 리스트
        final Customdongde   Customdongde = new Customdongde(getActivity());//동대닭한마리 1개 리스트
        final Customhonam   Customhonam = new Customhonam(getActivity());//호남식당 1개 리스트
        final Custombabhan   Custombabhan = new Custombabhan(getActivity());//밥한끼 1개 리스트
        final Customkimchi   Customkimchi = new Customkimchi(getActivity());//김치만 1개 리스트
        final Customsomyee   Customsomyee = new Customsomyee(getActivity());//솜이네 1개 리스트
        final Customdonhwa   Customdonhwa = new Customdonhwa(getActivity());//동회루 1개 리스트
        final Customdeado   Customdeado = new Customdeado(getActivity());//동회루 1개 리스트
        final Customgangnam   Customgangnam = new Customgangnam(getActivity());//동회루 1개 리스트



        buttonsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_on=true;
                String searchtext = textsearch.getText().toString();
                Toast.makeText(getActivity(), searchtext, Toast.LENGTH_SHORT).show();
                if(searchtext.equals("white house")||searchtext.equals("다시 열린 하얀집")){
                    list.setAdapter(Customdasi);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //Toast.makeText(getActivity(), choice_do + "=" + choice_se, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), shop_detail.class);
                            intent.putExtra("image", R.drawable.store1);
                            intent.putExtra("position", 0);
                            startActivity(intent);
                        }
                    });
                }
                else if(searchtext.equals("chicken")||searchtext.equals("등나무집, 동대닭한마리")){
                    list.setAdapter(Customdongde);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //Toast.makeText(getActivity(), choice_do + "=" + choice_se, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), shop_detail.class);
                            intent.putExtra("image", R.drawable.store2);
                            intent.putExtra("position", 1);
                            startActivity(intent);
                        }
                    });
                }
                else if(searchtext.equals("honam")||searchtext.equals("호남식당")){
                    list.setAdapter(Customhonam);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //Toast.makeText(getActivity(), choice_do + "=" + choice_se, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), shop_detail.class);
                            intent.putExtra("image", R.drawable.store3);
                            intent.putExtra("position", 2);
                            startActivity(intent);
                        }
                    });
                }
                else if(searchtext.equals("babhansul")||searchtext.equals("밥한술")){
                    list.setAdapter(Custombabhan);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //Toast.makeText(getActivity(), choice_do + "=" + choice_se, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), shop_detail.class);
                            intent.putExtra("image", R.drawable.store4);
                            intent.putExtra("position", 3);
                            startActivity(intent);
                        }
                    });
                }
                else if(searchtext.equals("kimchi")||searchtext.equals("김치만선생")){
                    list.setAdapter(Customkimchi);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //Toast.makeText(getActivity(), choice_do + "=" + choice_se, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), shop_detail.class);
                            intent.putExtra("image", R.drawable.store5);
                            intent.putExtra("position", 4);
                            startActivity(intent);
                        }
                    });
                }
                else if(searchtext.equals("tteokbokki")||searchtext.equals("솜이네 떡볶이")){
                    list.setAdapter(Customsomyee);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //Toast.makeText(getActivity(), choice_do + "=" + choice_se, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), shop_detail.class);
                            intent.putExtra("image", R.drawable.store6);
                            intent.putExtra("position", 5);
                            startActivity(intent);
                        }
                    });
                }
                else if(searchtext.equals("dong")||searchtext.equals("동회루")){
                    list.setAdapter(Customdonhwa);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //Toast.makeText(getActivity(), choice_do + "=" + choice_se, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), shop_detail.class);
                            intent.putExtra("image", R.drawable.store7);
                            intent.putExtra("position", 6);
                            startActivity(intent);
                        }
                    });
                }
                else if(searchtext.equals("daedo")||searchtext.equals("대도식당")){
                    list.setAdapter(Customdeado);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(getActivity(), "서비스 준비중입니다.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else if(searchtext.equals("gangnam")||searchtext.equals("강남식당")){
                    list.setAdapter(Customgangnam);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(getActivity(), "서비스 준비중입니다.", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
                else{
                    Toast.makeText(getActivity(), "등록된 식당이 없습니다.", Toast.LENGTH_SHORT).show();
                }


            }
        });



        return view;
    }

    class CustomList extends ArrayAdapter<String> {
        private final Activity context;

        public CustomList(Activity context ) {
            super(context, R.layout.search_detail,name);
            this.context = context;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = null;

            if (btn_on) {
                rowView = inflater.inflate(R.layout.search_detail, null, true);
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
                TextView title = (TextView) rowView.findViewById(R.id.title);
                TextView address = (TextView) rowView.findViewById(R.id.address);
                TextView call = (TextView) rowView.findViewById(R.id.tell);
                call.setText("" +tell[position]);
                title.setText(name[position]);
                imageView.setImageResource(image[position]);
                address.setText("" +map[position]);
                notifyDataSetChanged();
            }
            else {
                rowView = inflater.inflate(R.layout.search_detail, null, true);
            }
            return rowView;
        }
    }

    class CustomList0 extends ArrayAdapter<String> {
        private final Activity context;

        public CustomList0(Activity context ) {
            super(context, R.layout.search_detail,name0);
            this.context = context;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = null;

            if (btn_on) {

                rowView = inflater.inflate(R.layout.search_detail, null, true);
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
                TextView title = (TextView) rowView.findViewById(R.id.title);
                TextView address = (TextView) rowView.findViewById(R.id.address);
                TextView call = (TextView) rowView.findViewById(R.id.tell);
                call.setText("");
                title.setText(name0[position]);
                imageView.setImageResource(R.drawable.ic_launcher_background);
                address.setText("");
                notifyDataSetChanged();

            }
            else {
                rowView = inflater.inflate(R.layout.search_detail, null, true);
            }
            return rowView;
        }
    }


    class CustomList1 extends ArrayAdapter<String> {
        private final Activity context;

        public CustomList1(Activity context ) {
            super(context, R.layout.search_detail,name1);
            this.context = context;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = null;

            if (btn_on) {

                rowView = inflater.inflate(R.layout.search_detail, null, true);
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
                TextView title = (TextView) rowView.findViewById(R.id.title);
                TextView address = (TextView) rowView.findViewById(R.id.address);
                TextView call = (TextView) rowView.findViewById(R.id.tell);
                call.setText("" +tell1[position]);
                title.setText(name1[position]);
                imageView.setImageResource(image1[position]);
                address.setText(map1[position]);
                notifyDataSetChanged();

            }
            else {
                rowView = inflater.inflate(R.layout.search_detail, null, true);
            }
            return rowView;
        }
    }

    //이 아래애있는건 전부 상점 리스트 하나씩 따로 있음
    //databinding 못해서 노가다
    class Customdasi extends ArrayAdapter<String> {
        private final Activity context;

        public Customdasi(Activity context ) {
            super(context, R.layout.search_detail,dasi);
            this.context = context;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = null;

            if (btn_on) {

                rowView = inflater.inflate(R.layout.search_detail, null, true);
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
                TextView title = (TextView) rowView.findViewById(R.id.title);
                TextView address = (TextView) rowView.findViewById(R.id.address);
                TextView call = (TextView) rowView.findViewById(R.id.tell);
                call.setText("" +tell[0]);
                title.setText(name[0]);
                imageView.setImageResource(image[0]);
                address.setText("" +map[0]);
                notifyDataSetChanged();

            }
            else {
                rowView = inflater.inflate(R.layout.search_detail, null, true);
            }
            return rowView;
        }
    }


    class Customdongde extends ArrayAdapter<String> {
        private final Activity context;

        public Customdongde(Activity context ) {
            super(context, R.layout.search_detail,dongde);
            this.context = context;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = null;

            if (btn_on) {

                rowView = inflater.inflate(R.layout.search_detail, null, true);
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
                TextView title = (TextView) rowView.findViewById(R.id.title);
                TextView address = (TextView) rowView.findViewById(R.id.address);
                TextView call = (TextView) rowView.findViewById(R.id.tell);
                call.setText("" +tell[1]);
                title.setText(name[1]);
                imageView.setImageResource(image[1]);
                address.setText("" +map[1]);
                notifyDataSetChanged();

            }
            else {
                rowView = inflater.inflate(R.layout.search_detail, null, true);
            }
            return rowView;
        }
    }

    class Customhonam extends ArrayAdapter<String> {
        private final Activity context;

        public Customhonam(Activity context ) {
            super(context, R.layout.search_detail,honam);
            this.context = context;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = null;

            if (btn_on) {

                rowView = inflater.inflate(R.layout.search_detail, null, true);
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
                TextView title = (TextView) rowView.findViewById(R.id.title);
                TextView address = (TextView) rowView.findViewById(R.id.address);
                TextView call = (TextView) rowView.findViewById(R.id.tell);
                call.setText("" +tell[2]);
                title.setText(name[2]);
                imageView.setImageResource(image[2]);
                address.setText("" +map[2]);
                notifyDataSetChanged();

            }
            else {
                rowView = inflater.inflate(R.layout.search_detail, null, true);
            }
            return rowView;
        }
    }
    class Custombabhan extends ArrayAdapter<String> {
        private final Activity context;

        public Custombabhan(Activity context ) {
            super(context, R.layout.search_detail,babhan);
            this.context = context;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = null;

            if (btn_on) {

                rowView = inflater.inflate(R.layout.search_detail, null, true);
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
                TextView title = (TextView) rowView.findViewById(R.id.title);
                TextView address = (TextView) rowView.findViewById(R.id.address);
                TextView call = (TextView) rowView.findViewById(R.id.tell);
                call.setText("" +tell[3]);
                title.setText(name[3]);
                imageView.setImageResource(image[3]);
                address.setText("" +map[3]);
                notifyDataSetChanged();

            }
            else {
                rowView = inflater.inflate(R.layout.search_detail, null, true);
            }
            return rowView;
        }
    }

    class Customkimchi extends ArrayAdapter<String> {
        private final Activity context;

        public Customkimchi(Activity context ) {
            super(context, R.layout.search_detail,kimchi);
            this.context = context;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = null;

            if (btn_on) {

                rowView = inflater.inflate(R.layout.search_detail, null, true);
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
                TextView title = (TextView) rowView.findViewById(R.id.title);
                TextView address = (TextView) rowView.findViewById(R.id.address);
                TextView call = (TextView) rowView.findViewById(R.id.tell);
                call.setText("" +tell[4]);
                title.setText(name[4]);
                imageView.setImageResource(image[4]);
                address.setText("" +map[4]);
                notifyDataSetChanged();

            }
            else {
                rowView = inflater.inflate(R.layout.search_detail, null, true);
            }
            return rowView;
        }
    }

    class Customsomyee extends ArrayAdapter<String> {
        private final Activity context;

        public Customsomyee(Activity context ) {
            super(context, R.layout.search_detail,somyee);
            this.context = context;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = null;

            if (btn_on) {

                rowView = inflater.inflate(R.layout.search_detail, null, true);
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
                TextView title = (TextView) rowView.findViewById(R.id.title);
                TextView address = (TextView) rowView.findViewById(R.id.address);
                TextView call = (TextView) rowView.findViewById(R.id.tell);
                call.setText("" +tell[5]);
                title.setText(name[5]);
                imageView.setImageResource(image[5]);
                address.setText("" +map[5]);
                notifyDataSetChanged();

            }
            else {
                rowView = inflater.inflate(R.layout.search_detail, null, true);
            }
            return rowView;
        }
    }


    class Customdonhwa extends ArrayAdapter<String> {
        private final Activity context;

        public Customdonhwa(Activity context ) {
            super(context, R.layout.search_detail,donhwa);
            this.context = context;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = null;

            if (btn_on) {

                rowView = inflater.inflate(R.layout.search_detail, null, true);
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
                TextView title = (TextView) rowView.findViewById(R.id.title);
                TextView address = (TextView) rowView.findViewById(R.id.address);
                TextView call = (TextView) rowView.findViewById(R.id.tell);
                call.setText("" +tell[6]);
                title.setText(name[6]);
                imageView.setImageResource(image[6]);
                address.setText("" +map[6]);
                notifyDataSetChanged();

            }
            else {
                rowView = inflater.inflate(R.layout.search_detail, null, true);
            }
            return rowView;
        }
    }


    class Customdeado extends ArrayAdapter<String> {
        private final Activity context;

        public Customdeado(Activity context ) {
            super(context, R.layout.search_detail,deado);
            this.context = context;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = null;

            if (btn_on) {

                rowView = inflater.inflate(R.layout.search_detail, null, true);
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
                TextView title = (TextView) rowView.findViewById(R.id.title);
                TextView address = (TextView) rowView.findViewById(R.id.address);
                TextView call = (TextView) rowView.findViewById(R.id.tell);
                call.setText("" +tell1[0]);
                title.setText(name1[0]);
                imageView.setImageResource(image1[0]);
                address.setText("" +map1[0]);
                notifyDataSetChanged();

            }
            else {
                rowView = inflater.inflate(R.layout.search_detail, null, true);
            }
            return rowView;
        }
    }

    class Customgangnam extends ArrayAdapter<String> {
        private final Activity context;

        public Customgangnam(Activity context ) {
            super(context, R.layout.search_detail,gangnam);
            this.context = context;

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = null;

            if (btn_on) {

                rowView = inflater.inflate(R.layout.search_detail, null, true);
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
                TextView title = (TextView) rowView.findViewById(R.id.title);
                TextView address = (TextView) rowView.findViewById(R.id.address);
                TextView call = (TextView) rowView.findViewById(R.id.tell);
                call.setText("" +tell1[1]);
                title.setText(name1[1]);
                imageView.setImageResource(image1[1]);
                address.setText("" +map1[1]);
                notifyDataSetChanged();

            }
            else {
                rowView = inflater.inflate(R.layout.search_detail, null, true);
            }
            return rowView;
        }
    }
}