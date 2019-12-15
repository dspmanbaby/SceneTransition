package asdf.zxcv.scenetransition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    private ViewGroup paintingContainter;
    private Scene activeScene;
    private Scene passiveScene;
    private Transition transition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        paintingContainter = findViewById(R.id.painting_container);
        transition = TransitionInflater.from(this).inflateTransition(R.transition.transition);

        activeScene = Scene.getSceneForLayout(paintingContainter,R.layout.scene1,this);
        passiveScene = Scene.getSceneForLayout(paintingContainter,R.layout.scene2,this);

        activeScene.enter();
    }

    public void changeScenes(View view){
        Scene temp = passiveScene;
        passiveScene =activeScene;
        activeScene = temp;

        TransitionManager.go(activeScene, transition);
    }
}
