package info.riemannhypothesis.android.random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String EXTRA_LOWER = "info.riemannhypothesis.android.random.LOWER";
	public final static String EXTRA_UPPER = "info.riemannhypothesis.android.random.UPPER";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void sendMessage(View view) {
		Intent intent = new Intent(this, GenerateActivity.class);
		EditText lowerBoundText = (EditText) findViewById(R.id.lower_bound);
		EditText upperBoundText = (EditText) findViewById(R.id.upper_bound);
		String lowerBoundString = lowerBoundText.getText().toString();
		String upperBoundString = upperBoundText.getText().toString();
		intent.putExtra(EXTRA_LOWER, lowerBoundString);
		intent.putExtra(EXTRA_UPPER, upperBoundString);
		startActivity(intent);
	}
}
