package com.example.studyplanner.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyplanner.MainActivity2;
import com.example.studyplanner.R;
import com.example.studyplanner.User;

public class HomeFragment extends Fragment  implements View.OnClickListener {

    Activity context;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        //just change the fragment_dashboard
//        //with the fragment you want to inflate
//        //like if the class is HomeFragment it should have R.layout.home_fragment
//        //if it is DashboardFragment it should have R.layout.fragment_dashboard
//


//        final CardView cardview = root.findViewById(R.id.text_home);
//        cardview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction fragmentTransaction = getActivity()
//                        .getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.text_dashboard, new Homefragment());
//                fragmentTransaction.commit();
//            }
//        });

//    private HomeViewModel homeViewModel;

//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_home, null);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        Fragment newFragment = new HomeFragment();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//// Replace whatever is in the fragment_container view with this fragment,
//// and add the transaction to the back stack
//        transaction.replace(R.id.navigation_dashboard, newFragment);
//        transaction.addToBackStack(null);
//
//// Commit the transaction
//        transaction.commit();

//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final CardView cardView = root.findViewById(R.id.sem1);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
//    }
//    public HomeFragment() {
//    }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            context=getActivity();

            CardView cardview1 = (CardView) rootView.findViewById(R.id.sem1);
            CardView cardview2 = (CardView) rootView.findViewById(R.id.sem2);
            CardView cardview3 = (CardView) rootView.findViewById(R.id.sem3);
            CardView cardview4 = (CardView) rootView.findViewById(R.id.sem4);
            CardView cardview5 = (CardView) rootView.findViewById(R.id.sem5);
            CardView cardview6 = (CardView) rootView.findViewById(R.id.sem6);
            CardView cardview7 = (CardView) rootView.findViewById(R.id.sem7);
            CardView cardview8 = (CardView) rootView.findViewById(R.id.sem8);
            CardView cardview9 = (CardView) rootView.findViewById(R.id.sem9);
            CardView cardview10 = (CardView) rootView.findViewById(R.id.sem10);

//            User u = User.getInstance();
//            String sem = u.getsem();
//            if(sem.substring(0,2) == "Sem")
//            {
//                activity2Intent.putExtra("sem",sem);
////                u.setsem(null);
//                startActivity(activity2Intent);
//            }

            cardview1.setOnClickListener(this);
            cardview2.setOnClickListener(this);
            cardview3.setOnClickListener(this);
            cardview4.setOnClickListener(this);
            cardview5.setOnClickListener(this);
            cardview6.setOnClickListener(this);
            cardview7.setOnClickListener(this);
            cardview8.setOnClickListener(this);
            cardview9.setOnClickListener(this);
            cardview10.setOnClickListener(this);

            return rootView;
        }

        @Override
        public void onClick(View view) {
            Intent activity2Intent = new Intent(context, MainActivity2.class);
            switch (view.getId()) {
                case R.id.sem1:
                    activity2Intent.putExtra("sem", "Sem1" );
                    startActivity(activity2Intent);
                    break;
                case R.id.sem2:
                    activity2Intent.putExtra("sem", "Sem2" );
                    startActivity(activity2Intent);
                    break;
                case R.id.sem3:
                    activity2Intent.putExtra("sem", "Sem3" );
                    startActivity(activity2Intent);
                    break;
                case R.id.sem4:
                    activity2Intent.putExtra("sem", "Sem4" );
                    startActivity(activity2Intent);
                    break;
                case R.id.sem5:
                    activity2Intent.putExtra("sem", "Sem5" );
                    startActivity(activity2Intent);
                    break;
                case R.id.sem6:
                    activity2Intent.putExtra("sem", "Sem6" );
                    startActivity(activity2Intent);
                    break;
                case R.id.sem7:
                    activity2Intent.putExtra("sem", "Sem7" );
                    startActivity(activity2Intent);
                    break;
                case R.id.sem8:
                    activity2Intent.putExtra("sem", "Sem8" );
                    startActivity(activity2Intent);
                    break;
                case R.id.sem9:
                    activity2Intent.putExtra("sem", "Sem9" );
                    startActivity(activity2Intent);
                    break;
                case R.id.sem10:
                    activity2Intent.putExtra("sem", "Sem10" );
                    startActivity(activity2Intent);
                    break;
            }
        }

//        public void replaceFragment(Fragment someFragment) {
//            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
//            transaction.replace(R.id.nav_host_fragment, someFragment);
//            transaction.addToBackStack(null);
//            transaction.commit();
//        }

}