package ahmety.pes2019realnames;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Players extends AppCompatActivity {
    WebView Browser;

    //End
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        // Geri tuþu için actionbar aktif etmek
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        Browser = (WebView)findViewById(R.id.webview_players);
        Browser.getSettings().setLoadWithOverviewMode(true); //sayfanýn overview modunda açýlmasýný saðlar
        Browser.getSettings().setUseWideViewPort(true); //genis aci ile görüntülenmesini ve sayfanýn tümünü göstermesini saðlar
        Browser.setInitialScale(1);  // ilk scale ayarlama webview için
        Browser.getSettings().setSupportMultipleWindows(true);  // responsive ekran deðiþimlerini yakalamak için
        Browser.getSettings().setBuiltInZoomControls(true); // zoom  yapmak için
        Browser.getSettings().setDisplayZoomControls(false); // zoom yapmak için

        Browser.setWebViewClient(new myWebViewClient());
        Browser.loadUrl("file:///android_asset/web/Players.html");
    }
    // Geri tuþunun fonksiyonunun yazýldýðý yer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, HomePage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                // app icon in action bar clicked; go home
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
