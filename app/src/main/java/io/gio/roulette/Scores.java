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

import io.gio.roulette.Adapter.RulesAdapter;
import io.gio.roulette.Model.RuleViewModel;

public class Scores extends Fragment {
    private RuleViewModel ruleViewModel;
    RulesAdapter rulesAdapter;
    public static RecyclerView recyclerView;
    int counter;
    String[] rulename={"Low or Manque","High or Passe","Red or Black","Even or Odd","Dozen Bet","Column Bet","Snake Bet"};
    String[] ruledesc={"A bet that the number will be in the chosen range.(1 to 18)","A bet that the number will be in the chosen range.(19 to 36)","A bet that the number will be the chosen color.","A bet that the number will be of the chosen type.","A bet that the number will be in the chosen dozen: first (1-12, Première douzaine or P12), second (13-24, Moyenne douzaine or M12), or third (25-36, Dernière douzaine or D12).","A bet that the number will be in the chosen vertical column of 12 numbers, such as 1-4-7-10 on down to 34. The chip is placed on the space below the final number in this sequence.",
            "A special bet that covers the numbers 1, 5, 9, 12, 14, 16, 19, 23, 27, 30, 32, and 34. It has the same payout as the dozen bet and takes its name from the zigzagging, snakelike pattern traced out by these numbers. The snake bet is not available in all casinos; when it is allowed, the chip is placed on the lower corner of the 34 square that borders the 19-36 betting box. Some layouts mark the bet with a two-headed snake that winds from 1 to 34, and the bet can be placed on the head at either end of the body."};
    Integer[] image={R.drawable.lowormanque,R.drawable.highorpasse,R.drawable.red,R.drawable.even,R.drawable.dozenbet,R.drawable.columnbet,R.drawable.snakebet};
    View root;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_scores,container,false);
        initialize();

        return root;
    }
    private void initialize(){
        List<RuleViewModel> awit = new ArrayList<>();
        for(int i = 0; i < rulename.length; i ++ ){
            awit.add(new RuleViewModel(rulename[i],ruledesc[i],image[i]));
        }

        recyclerView =root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        rulesAdapter = new RulesAdapter(getActivity(),awit);
        recyclerView.setAdapter(rulesAdapter);
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