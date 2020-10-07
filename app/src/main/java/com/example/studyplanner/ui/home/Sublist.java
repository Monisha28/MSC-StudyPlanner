//package com.example.studyplanner.ui.home;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import com.example.studyplanner.MainActivity;
//import com.example.studyplanner.R;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.ListFragment;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.Toast;
//import android.widget.AdapterView;
//
//public class Sublist extends ListFragment {
//
////    public static Sublist createInstance() {
////        return new Sublist();
////    }
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.sublist, container, false);
//        return v;
//    }
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        String[] items = {"Unit 1", "Unit 2", "Unit 3", "Unit 4", "Unit 5", "Unit 6", "Unit 7", "Unit 8", "Unit 9", "Unit10", "Unit 11", "Unit 12", "Unit 13"};
//        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, items);
//
//        setListAdapter(adapter);
//        getListView().setOnItemClickListener((OnItemClickListener) this);
//    }
//
//    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
//        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
//    }
//
//}
//
