package io.gio.roulette;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.gio.roulette.Adapter.ScoreAdapter;
import io.gio.roulette.Model.ScoreViewModel;

public class Design extends Fragment {

    private ScoreViewModel scoreViewModel;
    private ScoreAdapter scoreAdapter;

    int counter;
    public static RecyclerView recyclerView;
    String[] title={"Straight/Single","Split","Street","Corner/Square","Six Line/Double Street","Trio","First Four","Basket",};
    String[] desc={"Bet on a single number","Bet on two vertically/horizontally adjacent numbers (11-12 or 2-3)","Bet on three consecutive numbers in a horizontal line (2-3-4)","Bet on four numbers that meet at one corner (8-9-10-11)",
            "Bet on six consecutive numbers that form two horizontal lines (30-31-32-33-34-35)","A three-number bet that involves at least one zero: 0-1-2 (either layout); 0-2-3 (single-zero only) 00-2-3 (double-zero only)","Bet on 0-1-2-3 (Single-zero layout only)","Bet on 0-00-1-2-3 (Double-zero layout only)"};
    String[] place={"Entirely within the square for the chosen number","On the edge shared by the numbers","On the outer edge of the number at either end of the line","On the common corner","On the outer corner shared by the two leftmost or the two rightmost numbers","On the corner shared by the three chosen numbers",
            "On the outer corner shared by 0-1 or 0-3","On the outer corner shared by 0-1 or 00-3"};
    Integer[] image={R.drawable.straightsingle,R.drawable.split,R.drawable.street,R.drawable.cornersquare,R.drawable.sixlinedoublestreet,R.drawable.trio,R.drawable.firstfour,R.drawable.basket};
//Integer[] dimage={R.drawable.};
View root;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_design,container,false);
        initialize();
        return root;
    }

    private void initialize(){
        List<ScoreViewModel> awit = new ArrayList<>();
        for(int i = 0; i < title.length; i ++ ){
            awit.add(new ScoreViewModel(title[i],desc[i],place[i],image[i]));
        }

        recyclerView =root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
        scoreAdapter = new ScoreAdapter(getActivity(),awit);
        recyclerView.setAdapter(scoreAdapter);
    }
//    @Override
//    public void onBackPressed() {
//        if (counter == 0) {
//            counter = 1;
//            Toast.makeText(this, "Press Again To Exit.", Toast.LENGTH_SHORT).show();
//        } else {
//            finish();
//        }
//    }
}