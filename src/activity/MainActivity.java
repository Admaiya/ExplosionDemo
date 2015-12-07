package activity;

import android.app.Activity;
import android.os.Bundle;

import com.chinglimchan.explosion.R;

import definition.ExplosionField;
import factory.ExplodeParticleFactory;
import factory.FlyawayFactory;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ExplosionField explosionField = new ExplosionField(this, new FlyawayFactory());
		explosionField.addListener(findViewById(R.id.hello));
		
		ExplosionField explosionField2 = new ExplosionField(this, new ExplodeParticleFactory());
		explosionField2.addListener(findViewById(R.id.img));
	}
}
