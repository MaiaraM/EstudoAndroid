package br.com.galaxyware.animationxp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.foguete)
    ImageView foguete;
    @BindView(R.id.nuvemG) ImageView nuvemG;
    @BindView(R.id.nuvemP) ImageView nuvemP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        Handler hander = new Handler();
        hander.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarInicial();
            }
        },6000);
        animacao();
    }

    private void animacao() {
        Animation animationFoguete = AnimationUtils.loadAnimation(this, R.anim.move_foguete);
        Animation animationNuvemG = AnimationUtils.loadAnimation(this, R.anim.move_nuvem_g);
        Animation animationNuvemP = AnimationUtils.loadAnimation(this, R.anim.move_nuvem_p);
        foguete.startAnimation(animationFoguete);
        nuvemG.startAnimation(animationNuvemG);
        nuvemP.startAnimation(animationNuvemP);
    }

    private void mostrarInicial() {
//        Intent intent = new Intent(SplashActivity.this,
//                MainActivity.class);
//        startActivity(intent);
//        finish();
    }

}
