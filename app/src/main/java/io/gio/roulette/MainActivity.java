package io.gio.roulette;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import io.gio.roulette.Adapter.MahjongAdapter;
import io.gio.roulette.Model.MahjongViewModel;

public class MainActivity extends Fragment {
    private MahjongViewModel mahjongViewModel;
    private BottomNavigationView bottomNavigationView;
    MahjongAdapter mahjongAdapter;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    int counter;
    private CarouselView carousel;
    public List<Integer> llvpics = new ArrayList<>();
    public static RecyclerView recyclerView;
 String[] mname={"Roulette Single Zero Wheel","Roulette Double Zero Wheel","Roulette Triple Zero Wheel"};
 String[] mdesc={"Single zero roulette is another name for European roulette. A single zero roulette game uses roulette with only one \"0\" space instead of the \"0\" and \"00\" points on American roulette. The house edge difference between a single zero roulette wheel and a double zero roulette wheel is considerable. The addition of a single space on the steering wheel has a major impact on the advantages of the casino.To be precise, ‘even money’ bets have a 48.65% chance of winning in European Roulette",
         "American roulette has 38 divisions, including numbers between 1 and 36, 0 and 00. The numbers from 1 to 36 are displayed alternately in red and black, while single zeros and double zeros are marked in green.\n" +
         "\n" +
         "The main goal of any player is to predict which numbered pocket the roulette ball will fall into. In order to do this, all players place a specific number, and then the dealer turns the roulette in one direction, which in turn turns the roulette ball. Once the ball enters the pocket with that specific number, the corresponding player will be paid. and 47.37% in American roulette. Due to the high probability of those bets, the payout for them is 1:1.",
         "The vast majority of roulette wheels are European or American. European roulette has 37 pockets, while American roulette has 38 pockets.\n" +
         "\n" +
         "The rare three zero wheel has 39 pockets. The pocket includes numbers 1-36, zero, double zero and three zero.\n" +
         "\n" +
         "The latter is what really defines the game. Three zero roulette is the only variant that offers a pocket with three zeros.\n" +
         "The first thing to understand here is that each zero pocket or green pocket provides an advantage to the house for most bets.\n" +
         "\n" +
         "For example, if you choose \"black\" on the red/black bet, then you have 18 chances of winning. This is because pockets 1-36 have 18 black spaces.\n" +
         "\n" +
         "The triple zero wheel has 21 pockets, which may disorient you. Pocket 1-36 contains 18 red spaces. In addition, pockets 0, 00, and 000 may cause losses.\n" +
         "\n" +
         "You may not immediately notice how bad this deal is. However, when you calculate the chances of winning and the house advantage, you will fully understand.\n" +
         "\n" +
         "This is the math:\n" +
         "\n" +
         "18/39 = 46.15 chance of winning\n" +
         "3/39 = 7.69% of the house edge\n" +
         "Similarly, you have 18 chances of winning within the numbers 1-36. But the most important thing is that the three special spaces give the casino an extra advantage.\n" +
         "\n" +
         "The 7.69% betting advantage of triple zero roulette is the worst of all gambling. Its sole purpose is to deceive ignorant gamblers so that the casino can win more money."};
 Integer[] mimage={R.drawable.singlezero,R.drawable.doublezero,R.drawable.triplezero};
 View root;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_main,container,false);

//        bottomNavigationView = root.findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.home);
        carousel = root.findViewById(R.id.frontimg);
        initialize();
        showPics();
        return root;
    }

    private void initialize(){
        List<MahjongViewModel> awit = new ArrayList<>();
        for(int i = 0; i < mname.length; i ++ ){
            awit.add(new MahjongViewModel(mname[i],mdesc[i],mimage[i]));
        }

        recyclerView =root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
        mahjongAdapter = new MahjongAdapter(getActivity(),awit);
        recyclerView.setAdapter(mahjongAdapter);
    }

    public void showPics() {
        llvpics.add(R.drawable.b1);
        llvpics.add(R.drawable.b2);
        llvpics.add(R.drawable.b3);
        carousel.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {

                ArrayList<Integer> imageListTitle = new ArrayList<Integer>();

//               /llvpics.addAll(m);
                for(int i = 0; i < llvpics.size(); i++ ){
                    imageListTitle.add(llvpics.get(i));
                }
//                //imageView.setImageResource(imagelist[position]);
                Picasso.get().load(imageListTitle.get(position)).into(imageView);

            }
        });
        carousel.setPageCount(llvpics.size());

    }
}