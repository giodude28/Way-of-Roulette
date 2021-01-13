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

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import io.gio.roulette.Adapter.TipsAdapter;
import io.gio.roulette.Model.TipsViewModel;

public class Tips extends Fragment {
private TipsViewModel tipsViewModel;
    private TipsAdapter tipsAdapter;
    public static RecyclerView recyclerView;
    int counter;
    View root;
    private BottomNavigationView bottomNavigationView;
    String[] title={"Voisins du zéro (neighbors of zero)","Jeu zéro (zero game)","Le tiers du cylindre (third of the wheel)","Orphelins (orphans)","... and the neighbors","Final bets","Full completes/maximums"};
    String[] desc={"This is a name, more precisely \"grand voisins duzéro\", which refers to the 17 numbers between 22 and 25 on the wheel, including 22 and 25 themselves. The series is 22-18-29-7-28-12-35-3-26-0-32-15-19-4-21-2-25 (on a single zero round).\n" +
            "\n" +
            "Bet on nine chips or its multiples. Two chips are placed in the 0-2-3 trio; 4-7 one in; December 15; January 18-21; 19-22 years old; two on 25-26-28-29 On the corner; there is also a 32-35",
    "The game of zero, also known as zero spear (spear is the German for games or games), is the name of the number closest to zero. All numbers in the zero game are included in voisins, but the positions are different. The bet number is 12-35-3-26-0-32-15.\n" +
            "\n" +
            "The bet consists of four chips or their multiples. Betting with three chips, one up: one chip is 0-3 chips, one chip is 12-15 chips, one chip is 32-35 chips, and one chip is number 26.\n" +
            "\n" +
            "This type of betting is very popular in Germany and many European casinos. In many Eastern European casinos, it is also offered as 5 chips. As a 5-chip bet, it is called \"zero odds naca\", which includes a straight on 19 in addition to the chips placed as described above.",
    "This is the name of the 12 numbers between 27 and 33 on the other side of the wheel, including 27 and 33 themselves. On the single zero round, the sequence is 27-13-36-11-30-8-23-10-5-24-16-33. The full name of the bet (although it is rarely used, most players refer to it as \"tier\") is \"le tiers du cylindre\" (translated from French to English, meaning one-third of the wheel), because it covers 12 numbers (press 6 split), as close as possible to 1⁄3 of the wheel.\n" +
            "\n" +
            "Very popular in British casinos, the level bet greatly exceeds the voisins and orphelin bets.\n" +
            "\n" +
            "A bet of six chips or its multiples. Place a chip on each of the following divisions: 5-8, 10-11, 13-16, 23-24, 27-30 and 33-36.\n" +
            "\n" +
            "Tier betting is also called \"small series\" and in some casinos (most notably South Africa), it is called \"5-8 series\".\n" +
            "\n" +
            "A variant called \"5-8-10-11 layer\" has an extra chip placed directly on 5, 8, 10 and 11m, so it is a 10-piece bet. In some places, this variant is called \"gioco Ferrari\", straight up on 8, 11, 23 and 30, the bet is marked with a red G on the track.",
    "These numbers make up two parts besides hierarchy and voisins. They contain a total of 8 numbers, including 17-34-6 and 1-20-14-31-9.\n" +
            "\n" +
            "5 chips or their multiples bet on 4 divisions, and a straight bet: 1 chip is placed directly above 1 chip, and one chip in each division: 6-9, 14-17, 17-20 And 31-34.",
    "\n" +
            "In a 5-chip bet, one number may be supported by both sides of the number. For example, \"0 and neighbor\" is a 5-chip bet, and you bet directly on 3, 26, 0, 32, and 15. Neighbors’ bets are often used in combination, such as \"1, 9, 14, and \"Neighbor\" is a 15-chip bet covering 18, 22, 33, 16 (one chip), 9, 31, 20, 1 ( Two chips) and 14 (three chips).\n" +
            "\n" +
            "Any of the above bets can be combined, such as \"Orphelin is 1 and 0, and neighbor is 1.\" Hosts often think of \"...and neighbors.\"",
    "\n" +
            "Another bet offered in the single zero game is \"final\", \"final\" or \"final\".\n" +
            "\n" +
            "For example, the final 4 is a 4-chip bet consisting of a number ending in 4, namely 4, 14, 24, and 34. The final 7 is a 3-chip bet with each chip on 7, 17, and 27. The final bet from the last 0 (zero) to the last 6 cost 4 chips. In the end, bets 7, 8 and 9 cost 3 chips.\n" +
            "\n" +
            "Some casinos also offer semi-final betting. For example, the final 5-8 will be a 4-chip bet, one chip at 5-8, 15-18, 25-28, and one chip at 35.",
    "A complete bet will place all internal bets on a specific number. A complete bet is usually made with a high bet as the maximum bet.\n" +
            "\n" +
            "In European Roulette, the maximum bet allowed for a bet is based on the progressive betting model. If the casino allows a maximum bet of $1,000 in a 35-to-1 tie, then for every 17-to-1 split related to the tie, $2,000 may be bet. The bet amount for each 8-to-1 corner covering 4 numbers is $4,000. Each 11-to-1 street covering 3 numbers may bet $3,000 on it. Each 5 to 1 6 bet may bet $6,000. Each incremental bet of $1,000 will be indicated by a marker that specifically identifies the player and the bet amount.\n" +
            "\n" +
            "For example, if the customer wants to place a full bet on 17, the player will call \"Max 17\". This bet requires a total of 40 chips, which is $40,000. To place the same bet manually, players need to place a bet."};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_tips,container,false);
        initialize();
        return root;
    }

    //
//    private void navBottom()
//    {
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.home:
//                        Intent vid = new Intent(getApplicationContext(), MainActivity.class);
//                        startActivity(vid);
//                        overridePendingTransition(0,0);
//                        finish();
//                        break;
//                    case R.id.rules:
//                        Intent stad =  new Intent(getApplicationContext(), Rules.class);
//                        startActivity(stad);
//                        overridePendingTransition(0,0);
//                        finish();
//                        break;
//                    case R.id.design:
//                        Intent awd =  new Intent(getApplicationContext(), Design.class);
//                        startActivity(awd);
//                        overridePendingTransition(0,0);
//                        finish();
//                        break;
//                    case R.id.score:
//                        Intent aw =  new Intent(getApplicationContext(), Scores.class);
//                        startActivity(aw);
//                        overridePendingTransition(0,0);
//                        finish();
//                        break;
//                    case R.id.tips:
//                        return true;
//                }
//                return true;
//            }
//        });
//    }
    private void initialize(){
        List<TipsViewModel> awit = new ArrayList<>();
        for(int i = 0; i < title.length; i ++ ){
            awit.add(new TipsViewModel(title[i],desc[i]));
        }

        recyclerView =root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
        tipsAdapter = new TipsAdapter(getActivity(),awit);
        recyclerView.setAdapter(tipsAdapter);
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