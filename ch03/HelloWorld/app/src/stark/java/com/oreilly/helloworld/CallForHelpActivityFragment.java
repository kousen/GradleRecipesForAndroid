package com.oreilly.helloworld;

import android.app.ListFragment;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CallForHelpActivityFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        List<Data> values = Data.VALUES;
        List<Map<String, Spanned>> list = new ArrayList<>();
        for (Data d : values) {
            Map<String, Spanned> map = new HashMap<>();
            map.put("title", Html.fromHtml(d.getTitle()));
            map.put("detail", Html.fromHtml(d.getDetail()));
            list.add(map);
        }

        String[] columns = {"title", "detail"};
        int[] resources = {android.R.id.text1, android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), list,
                android.R.layout.simple_list_item_2, columns, resources);
        adapter.setViewBinder(new SimpleAdapter.ViewBinder() {
                                  public boolean setViewValue(View view, Object data, String textRepresentation) {
                                      if (data instanceof Spanned && view instanceof TextView) {
                                          ((TextView) view).setText((Spanned) data);
                                      } else {
                                          ((TextView) view).setText(String.valueOf(data));
                                      }
                                      return true;
                                  }
                              }
        );

        setListAdapter(adapter);

        return view;
    }

}
