package com.example.oheunji.chungmuro;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//implements OnMapReadyCallback
public class MainTabFragment2 extends Fragment {
    ArrayAdapter<String> list;
    String choice_do = "";
    String choice_se = "";
    View view;

    final String[] name={
            "다시 열린 하얀집",
            "등나무집, 동대닭한마리",
            "호남식당",
            "밥한술",
            "김치만선생",
            "솜이네 떡볶이",
            "동회루"
    };

    final String[] map={
            "서울 중구 서애로 12-20 ",
            "서울 중구 서애로 16-5",
            "서울 중구 퇴계로41길 9",
            "서울 중구 퇴계로42길 14",
            "서울 중구 필동로 30-1",
            "서울 중구 퇴계로42길 36",
            "서울 중구 퇴계로 200"
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

    String[] tell={
            "02-2278-5953",
            "02-2269-5596",
            "02-2273-1348",
            "02-2268-0263",
            "02-6052-5526",
            "02-2285-2478",
            "02-2265-3345"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment2, null, false);

        /*ListView listView = (ListView) view.findViewById(R.id.listview);
        //search2.CustomList adapter = new search2.CustomList(getActivity());
        list = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, name);
        list.setDropDownViewResource(android.R.layout.simple_list_item_1);
        listView.setAdapter(list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), shop_detail.class);
                intent.putExtra("image", image[position]);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });*/

        class CustomList extends ArrayAdapter<String> {
            private final Activity context;
            public CustomList(Activity context ) {
                super(context, R.layout.search_detail, name);
                this.context = context;
            }

            @Override
            public View getView(int position, View view, ViewGroup parent) {
                LayoutInflater inflater = context.getLayoutInflater();
                View rowView = null;

                rowView= inflater.inflate(R.layout.search_detail, null, true);
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
                TextView title = (TextView) rowView.findViewById(R.id.title);
                TextView address = (TextView) rowView.findViewById(R.id.address);
                TextView call = (TextView) rowView.findViewById(R.id.tell);
                call.setText(tell[position]);
                title.setText(name[position]);
                imageView.setImageResource(image[position]);
                address.setText(map[position]);

                return rowView;
            }
        }


        CustomList adapter = new CustomList(getActivity());
        ListView list = (ListView) view.findViewById(R.id.listview);
        list.setBackgroundColor(Color.WHITE);
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

        return view;
    }
}
