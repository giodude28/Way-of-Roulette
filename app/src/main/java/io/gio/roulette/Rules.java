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

import io.gio.roulette.Adapter.DesignAdapter;
import io.gio.roulette.Model.DesignViewModel;

public class Rules extends Fragment {

    private DesignViewModel designViewModel;
    DesignAdapter designAdapter;
    public static RecyclerView recyclerView;
    View root;
    int counter;
    String[] dname={"Prediction Methods","Specific Betting System","Reverse Martingle System","Labouchère System","D'Alembert System","Other Systems"};
    String[] ddesc={"\n" +
            "The betting system is essentially trying to overcome the fact that over time, the geometric series with an initial value of 0.95 (American roulette) or 0.97 (European roulette) inevitably tends to zero, while engineers try to predict mechanical Sex to overcome the performance of the wheel on the edge of the house, the most famous is Joseph Jagger (Joseph Jagger) in Monte Carlo in 1873. If effective, they will increase the return rate of the game to more than 100%, thus overcoming the problem of the betting system.\n" +
            "\n" +
            "In 1961, Edward O. Thorp (a developer of Card Count and an early pioneer of hedge funds) and Claude Shannon (a mathematician and electronic engineer known for his contributions to information theory) ) Built the first wearable computer that predicts the landing of the ball. The system timed the ball and the wheel and used the information obtained to calculate the most likely octant that the ball would fall into. Ironically, this technique works best with unbiased roulette, although it can still be easily offset by simply closing the table before spinning.\n" +
            "In 1982, several British casinos began to lose large sums of money to American gamblers at roulette tables. After investigation by the police, it was discovered that they were using a legally biased round betting system. As a result, British roulette manufacturer John Huxley created roulette to solve this problem.\n" +
            "\n" +
            "The new wheel designed by George Melas is called \"low profile\" because the depth of the pocket has been greatly reduced, and various other design modifications have caused the ball to drop gradually closer to the pocket area. In 1986, when a professional gambling team led by Billy Walters used the system to win $3.8 million on the old roulette of Atlantic City’s Golden Nugget, every casino in the world noticed this, and In less than a year, he switched to a new low-key wheel.\n",
            "The countless tie bets in roulette over the years have inspired many players to try to beat the game by using one or more variations of the betting strategy, where the gambler doubles the bet after each loss so that the first win will be restored All previous losses, plus the profit equal to the original bet. The problem with this strategy is that remembering that past results will not affect the future, the player may lose many times in a row, so that the player who doubles or doubles his bet will either run out of money or hit the table limit. If players continue to use this strategy, it will definitely cause huge economic losses in the long run. Another strategy is the Fibonacci system, in which the bet is calculated according to the Fibonacci sequence. Regardless of the specific progress, this strategy cannot statistically overcome the advantage of the casino, because the expected value of each allowed bet is negative.",
            "\n" +
                    "The reverse Mar system (also known as the Paroli system) follows the idea of \u200B\u200Bthe betting strategy, but is reversed. Gamblers will double their bets every time they win, rather than double their bets after losing. This system creates a false sense that it eliminates the feeling of increasing the risk of betting when losing money, but in fact, it has the same problems as the strategy. By double betting after each win, a person continues to bet all the money he has won until he either stops the game or loses all.",
            "\n" +
                    "The Labouchère system is a progressive betting strategy like a mar game, but it does not require gamblers to bet as quickly as possible with amazing double odds. The Labouchere system involves the use of a series of numbers in a row to determine the bet amount after winning or losing. Usually, players add numbers at the beginning and end of the line to determine the size of the next bet. When he wins, he removes the numbers and continues to work on the smaller line. If he loses, then he will increase the previous bet to the end of the line and continue to work in the longer line. This is a more flexible progressive betting system, and players have a lot of room to design their first line according to their game preferences.\n" +
                    "\n" +
                    "The system is designed so that when a player wins more than one third of his bet (less than the expected 18/38), he will win. The sub will cause bankruptcy in continuous long-term losses, and the La Boucher system will cause the bet size to grow rapidly, even when the loser is broken by the winner. This happens because as the player loses, the average bet in the row increases.\n" +
                    "\n" +
                    "Like all other betting systems, the average value of this system is negative.","\n" +
            "This system is also called montant et demontant (from French, meaning up and down), and is often called the pyramid system. It is based on the mathematical balance theory designed by the French mathematician of the same name. Like the game, this system is mainly suitable for average betting under external money and is favored by players who want to keep their bets and bets at a minimum level. The betting process is very simple: every time you lose, you have to add a unit to the next bet, and every time you win, one unit will be deducted from the next bet. Starting from the initial bet (for example, 1 unit), a loss will increase the next bet to 2 units. If you win subsequently, the next bet will be 1 unit.\n" +
            "\n" +
            "This betting system relies on the gambler's fallacy-players are more likely to lose the game after winning, and more likely to win the game after losing money.",
            "There are many other betting systems that rely on this fallacy, or try to follow a \"streak\" (look for randomness patterns) and change the bet size accordingly.\n" +
                    "\n" +
                    "Many betting systems are sold online in order to enable players to \"beat\" the odds. Jason Gillon of Rotherham, UK, promoted such a system, claiming that you can “make £200 a day” by following his betting system (called a “loophole”). As the system was advertised in the British media, it was supervised by the Advertising Standards Agency, and after the complaint, the ASA ruled that Mr. Geelong failed to support his claim and that you could earn £200 a day, and he failed to show that it exists Any loopholes."};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_rules,container,false);
        initialize();
        return root;

    }



    private void initialize(){
        List<DesignViewModel> awit = new ArrayList<>();
        for(int i = 0; i < dname.length; i ++ ){
            awit.add(new DesignViewModel(dname[i],ddesc[i]));
        }

        recyclerView =root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
        designAdapter = new DesignAdapter(getActivity(),awit);
        recyclerView.setAdapter(designAdapter);
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