package io.gio.roulette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.gio.roulette.Adapter.MahjongAdapter;
import io.gio.roulette.Model.MahjongViewModel;

public class MahjongTiles extends AppCompatActivity {
    private MahjongViewModel mahjongViewModel;
    private BottomNavigationView bottomNavigationView;
    MahjongAdapter mahjongAdapter;
    public static RecyclerView recyclerView;
    String[] mname={"Suited Tiles","Circle Tiles","Bamboo Tiles","Character Tiles","Red Tiles","Honor Tiles","Wind Tiles","Dragon Tiles","Flower Tiles","Quartet Tiles","Animal Tiles","Joker Tiles"};
    String[] mdesc={"Suitable tiles (Chinese: serial number card; pinyin: xùshùpái; \"common number tile\"; also Chinese: digital card; pinyin: shùzìpái; Cantonese Jyutping: sou3zi6paai2; \"digital tile\"; and Japanese: number card; rōmaji : Shupai / suupai; \"number square\") has a suit and level. There are 3 types of money-based suits, ranging from 1 to 9. There are 4 tiles for each level and suit combination, so there are 36 tiles in the suit, for a total of 108 suitable tiles. To quote the appropriate block, the grade will be named, followed by the clothing. One and nine of each suit (Chinese: Chinese nine; Pinyin: yāojiǔ; Cantonese Jyutping: jiu1gau2; Japanese: ヤオ九; rōmaji: yaochū) are collectively called terminal bricks. Suitable bricks can be used to form the melds.",
    "A circle is usually a large circle with multiple colors, while the remaining blocks are composed of smaller circles, each of which is a color. The 2 circles are composed of green and blue circles, and the 3 circles are composed of a green, a red and a blue circle arranged diagonally (the order and direction of the circles in each group are different). The 4 circles have two blue circles and two green circles, arranged in a rectangle, with circles of similar colors at opposite corners. The 5 circle is similar to the 4 circle, with another circle in the middle (its color depends on the setting). The 6 circle consists of two green circles at the top and four red circles at the bottom (there is a space between the green and red circles). The 7 circle is similar to the 6 circle, but there are 3 green diagonal lines from the upper left corner to the lower right corner. There are eight blue circles arranged in a 2x4 rectangle. The 9 circles have three green, red and blue circles, each color occupies a row. There is a certain interval between each row, and the middle row is always a red circle (blue and green of course depend on the direction of the tiles).\n" +
            "\n" +
            "Because of the larger size of the circle in \"1 circle\", it is usually called da bing (big bing pinyin dàbǐng, literally meaning \"big pancake\").\n" +
            "\n" +
            "Starting from the currency source of this suit, the circle represents the copper coin, which is \"cash\" in English. (1 copper = one copper coin).",
    "Bamboo (sticks, lines, poles) suits (Chinese and Japanese: suozi; pinyin: suǒzi; Cantonese Jyutping: sok3zi2; rōmaji: sōzu; \"woven thread\"; also Chinese: strip/bar; Pinyin: tiáo; \"flatbread\") , But usually 1 bamboo represented by a bird (such as 1 bamboo, 1 bamboo or 1 bamboo) is represented by the outline of a wooden stick.\n" +
            "\n" +
            "\n" +
            "2, 3, 4, 6, and 8 bamboos are completely represented by green rods or blue and green rods, while the middle rods of 5 bamboos, the top rods of 7 bamboos and the rods in the middle column indicate that there is red in 9 bamboos. Some sets of 7 bamboos may have blue sticks in the bottom row or middle column. The sticks of No. 8 bamboo form an M shape with a mirror effect.\n" +
            "\n" +
            "Judging from the currency source of this suit, the wooden sticks are actually ropes (cords), which tie 100 Chinese copper coins together through a square hole in the middle. (1 cable = 100 copper) The repeated bumps on the stick depict individual coins in the strings, but they were mistaken for knots on the bamboo by Joseph Park Babcock, so Is the English name of the suit. 1 Bamboo, which usually represents a bird, is usually called a sparrow (麻雀-máquè); in Japan, the most common is the peacock. In the early games, there were no birds, only a curved cash line with a red knot on it",
    "Chinese characters (numerous, numbers, crack) suits (Chinese: Wanzi/万子; Pinyin: wànzi; Cantonese Jyutping: maan6zi2; Japanese: Wanzi; rōmaji: wanzu / manzu; \"myriad\") are represented by Chinese characters.\n" +
            "\n" +
            "The level of the tile is shown in blue at the top with Chinese numbers, and the character (10,000) below it is red. While the tiles were still hand-carved, earlier sets used the simplified character \"万\". The use of Fujian dialect (pǐn, rank). Most settings use the character Woods (5 characters) instead of five (5 characters).\n" +
            "\n" +
            "Judging from the currency source of this suit, countless (10,000) are actually 100 strings of coins described in the bamboo clothes section above. One million is equal to ten thousand coins or 100 strings of 100 coins. (10,000 = 100 cables × 100 copper).",
    "Red tiles (Japanese: 赤牌; rōmaji: akapai) are unique to the Japanese set. They appear as a red version of tiles from each suit and are not quadruplicated. They first appeared in the 1970s with the Red 5 Circle which were followed with red 5 tiles for the other suits.[6] Red 3s and 7s later appeared and were followed by red 1s and 9s although they are much less commonly found in sets than red 5s.[7] There is also a rare red white dragon (白ポッチ, shiro pocchi) which can act as a wild card if tsumo conditions are met.\n" +
            "\n" +
            "\n" +
            "These tiles are entirely optional. When inserted into play, one copy of its regular non-red counterpart is removed. They increase the score when melded. Japanese sets typically do not include the Four Gentlemen flower tiles to make room for the red tiles as flower tiles are rarely used in Japanese Mahjong anyway. Some mahjong parlours will have their own house tiles which may be red tiles for even ranks, even higher-scoring green or gold tiles, or colored wind tiles.",
    "Honor tiles (字牌, pinyin: zìpái, 'word tiles'; or 番子, jyutping: faan1zi2, 'exponentials') have neither rank nor suit but like suited tiles they are also formed into melds. They are divided into two categories: four Wind tiles (風牌/风牌, pinyin: fēngpái, jyutping: fung1paai2, Japanese romaji: fompai or kazehai) and three Dragon tiles (三元牌, pinyin: sānyuánpái, jyutping: saam1jyun4paai2, Japanese romaji: sangempai), each of which is quadruplicated. Thus, there are 16 wind tiles and 12 Dragon tiles for 28 honor tiles.",
    "The four types of wind bricks are: East (Chinese: East/East; Pinyin: dōng; Cantonese Jyutping: dung1; Japanese: East; rōmaji: ton), South (Chinese and Japanese: South; Pinyin: nán; Cantonese Jyutping: naam4 ) ;;Rōmaji: nan), West (Chinese and Japanese: West; Pinyin: xī; Cantonese Jyutping: sai1; rōmaji: shā), and North (Chinese and Japanese: North; Pinyin: běi; Cantonese Jyutping: bak1; rōmaji: pei / pē). Their Chinese characters are usually blue, such as east, south, west and north.\n" +
            "\n" +
            "\n" +
            "Each type of \"wind\" tile corresponds to a point on the compass, written in blue traditional Chinese characters (even for character sets written in \"Simplified Chinese\"). If the furnace matches the seat wind or prevailing wind or both, you will get bonus points. They are also called \"Four Xi Pai\" (Chinese: Four Xi Pai; Pinyin: sìxǐpái; Cantonese \"Jyutping\").",
    "The three types of dragon cards are:\n" +
            "\n" +
            "\tRed and White Dragon (白ポッチ, shiro pocchi)\n" +
            "Red (Chinese: 红中/红中; Pinyin: hóngzhōng; Cantonese Jyutping: hung4zung1; also Chinese and Japanese: Chinese; Pinyin: zhōng; Cantonese Jyutping: zung1; rōmaji: chun)-tiles with red traditional Chinese characters (middle) Represents center or middle. There may also be a black letter C on the corner of the tiles of the English-speaking suit, which represents the first letter in the (middle) Romanization of Wade-Giles. One of the earliest collections did not contain these tiles. [1] Some tiles have traditional Chinese characters \"龙\" (Red Dragon) or a red dragon icon.\n" +
            "\n" +
            "\tGreen (Chinese: Fa Cai/发财; Pinyin: fācái; Cantonese Jyutping: faat3coi4; Also Chinese: Qingfa/青发; Pinyin: qīngfā; Also Chinese: Fa/发; Pinyin: fā; Cantonese Jyutping: faat3; Japanese: Fa/ \uD853\uDF35;rōmaji: hats)-tiles with green traditional Chinese characters (发), even suitable for a collection of tiles written in simplified Chinese. The variant character U + 24F35\uD853\uDF35 is usually used (the 癶 on the bow arrow instead of the bow 癶). It is an abbreviation of pinyin/facai (pinyin: fācái), which means \"get rich\". Some combinations, especially the American combination, use the green dragon instead of this character, or there may also be a black letter F in the corner of the block, indicating the first letter of its transliteration. There are no such tiles in the earliest scenes. [8] Some tiles have the traditional Chinese character \"feng\" (green dragon) or the green dragon icon.\n" +
            "\n" +
            "\tWhite (Chinese: white board; pinyin: báibǎn; Cantonese Jyutping: baak6baan2; \"bucket\"; and Chinese and Japanese: white; pinyin: bái; Cantonese Jyutping: baak6; rōmaji: haku / shiro)-a tile image without any marks \"White dragon\" is the same, although most modern sets use tiles with blue borders (such as \"white dragon\" or \"white dragon\") to distinguish them from replacement tiles. The English kit may also have a black letter B in the center of the tile, which represents the first letter of the Wade-Giles Romanized Roman alphabet in white (bai). There are no markings on this Japanese tile and it is sometimes called tofu (tofu) in some Japanese Mahjong clubs. As mentioned above, there is a Japanese version of Red White Dragon (Red White Dragon).\n" +
            "The Chinese name of Dragon Brand is \"Sanyuan Brand\". They are also called Wrigley. The English name (Dragons) is the invention of Babcock. They are like wind-proof bricks, except for fusing them together, regardless of prevailing wind or seat wind, they will always get extra points. These tiles were invented after the windproof tiles, first white developed from replacement tiles, then red around 1870, and finally green in 1890.",
    "Tiles are not used in the mashup (Chinese and Japanese: Huapai; Pinyin: huāpái; Cantonese Jyutping: faa1paai2; rōmaji: hanahai / fapai). Put them aside when drawing, the player can redraw from the dead wall. These tiles usually depict stylized representations of flowers in multiple colors (hence the name). However, there are other non-floral themes that vary from theme to theme. In American Mahjong, they were regarded as honor cards, but from the 1930s to 1960, they were regarded as clowns. [9] [10] Some Japanese players regard it as a high scoring honor and cannot be used to form \"eyes\".\n",
    "If tiles are included, the average set will have two four tiles to distinguish the color and/or style of the label. Each quartet contains four unique tiles, numbered from 1 to 4 or clearly marked in other ways (the common Chinese group will have a quartet with blue Arabic numerals, and the other group will have red Chinese numerals) . Each number corresponds to a seat (1 = east, 2 = south, 3 = west, 4 = north). If the number on the flower matches the number of seats, the winner can double the score. There are some benefits to collecting the entire quartet, and in some variants, you can immediately win from collecting all the flowers. Since they reward points for pure luck, many games do not include them or are considered optional.\n" +
            "\n" +
            "The Four Seasons (Chinese: Four Seasons; Pinyin: sìjì; Cantonese Jyutping: sei3gwai3; Japanese: Season Card; rōmaji: kisetsuhai; Vietnamese: bốnmùa) The quartet is:\n" +
            "\n" +
            "\n" +
            "1.Spring Chinese: Chun; Pinyin Cantonese: ceon1; Vietnamese: xuân\n" +
            "2.Summer Chinese: Xia; Pinyin Cantonese: Vietnamese: hạ\n" +
            "3.Autumn Chinese: Autumn; Pinyin Cantonese: Vietnamese: Thursday\n" +
            "4.Winter Chinese: Winter; Pinyin Cantonese: Shit 1; Vietnamese: đông",
    "Animal cards (Chinese: animal cards/animal cards; Pinyin: dòngwùpái; Cantonese Jyutping: dung6mat6paai2) are unnumbered flowers that can be automatically matched with the player's seat. These tiles are usually paired with themes based on popular Chinese fables. If two tiles in pairs or all animals are collected, payment is made immediately. The Singaporean suit contains two pairs of animal cards, while the Thai and four-player Malaysian suits have four pairs. Some examples of tile pairs include:\n" +
            "\n" +
            "1.Cat (Chinese: 猫/猫; Pinyin: māo; Cantonese Jyutping: maau1) and Mouse (Chinese: mouse; Pinyin: láoshŭ; Cantonese Jyutping: lou5syu2)\n" +
            "2.Cock (Chinese: Cock); Pinyin: gōngjī; Cantonese Jyutping: gung1gai1) and C (Chinese: Centipede; Pinyin: wúgōng; Cantonese Jyutping: ng4gung1)\n" +
            "3.The God of Wealth (the god of wealth in Chinese folk religion and Taoism) and Sai Yi (an ancient custom gold or silver ingot)\n" +
            "4.Jiang Ziya (Military strategist in the 11th century BC, according to legend, he fished without bait, thinking that this fish will reproduce by itself) & Fish\n" +
            "5.Liu Haichan (a legendary Taoist fairy) and Jin Chan (a fabulous three-legged toad that attracts wealth)\n" +
            "6.Dragon and Fire Pearl (The legendary treasure is said to be able to fulfill the wish).\n" +
            "\n" +
            "The three-person game board in Malaysia has two pairs of animals with four identical animal tiles. These tiles are decorated with a face, usually the face of a clown. These are called human heads, human faces, clowns or snowmen. Sometimes, these four heads will be replaced by two pairs of male heads (male clown, male face) and female heads (female clown, female face).",
    "The wild card of pinkerinbǎidāpái can be used to replace any honor card suitable for local people or local residents. Four clowns are sometimes used in certain variations of Southeast Asian and Chinese Mahjong, including Shanghai Mahjong. There are eight clowns in American Mahjong."};
//    Integer[] mimage={R.drawable.suited,R.drawable.circles,R.drawable.bamboo,R.drawable.characters,R.drawable.redtiles,R.drawable.winds,R.drawable.winds,R.drawable.dragons,R.drawable.flowertiles,R.drawable.quartets,R.drawable.animaltiles,R.drawable.jokertiles};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahjong_tiles);
//        initialize();
    }
//    private void initialize(){
//        List<MahjongViewModel> awit = new ArrayList<>();
//        for(int i = 0; i < mname.length; i ++ ){
//            awit.add(new MahjongViewModel(mname[i],mdesc[i],mimage[i]));
//        }
//
//        recyclerView =findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
//        mahjongAdapter = new MahjongAdapter(MahjongTiles.this,awit);
//        recyclerView.setAdapter(mahjongAdapter);
//    }

}