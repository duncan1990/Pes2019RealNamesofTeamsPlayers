package ahmety.pes2019realnames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class HomePage extends AppCompatActivity {
    Button buttonTeams;
    Button buttonPlayers;
    //Admob TamBoyReklam Gecis Reklam
    private InterstitialAd interstitial;
    private static final String REKLAM_ID = "ca-app-pub-6942374915516583/6089332915";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Admob Banner BottomAd reklam
        AdView adView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        buttonTeams = (Button) findViewById(R.id.btn_teams);
        buttonPlayers = (Button) findViewById(R.id.btn_players);

        //button Teams a baildiği zaman yapilacaklar
        buttonTeams.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Admob TamBoyReklam Gecis Reklam
                interstitial = new InterstitialAd(HomePage.this);
                interstitial.setAdUnitId(REKLAM_ID);

                AdRequest adRequestgecis = new AdRequest.Builder().build();

                interstitial.loadAd(adRequestgecis);
                if (interstitial.isLoaded()) {
                    interstitial.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                    Intent intent=new Intent(HomePage.this,Teams.class);
                    startActivity(intent);
                }
                interstitial.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        Intent intent=new Intent(HomePage.this,Teams.class);
                        startActivity(intent);
                        }
                });
                //Admob TamBoyReklam Gecis Reklam End
            }
        });

        //button Players a baildiği zaman yapilacaklar
        buttonPlayers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Admob TamBoyReklam Gecis Reklam
                interstitial = new InterstitialAd(HomePage.this);
                interstitial.setAdUnitId(REKLAM_ID);

                AdRequest adRequestgecis = new AdRequest.Builder().build();

                interstitial.loadAd(adRequestgecis);
                if (interstitial.isLoaded()) {
                    interstitial.show();
                }
                else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                        Intent intent=new Intent(HomePage.this,Players.class);
                        startActivity(intent);
                    }
                interstitial.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                            Intent intent=new Intent(HomePage.this,Players.class);
                            startActivity(intent);
                    }
                });
                //Admob TamBoyReklam Gecis Reklam End
            }
        });
    }
}
