package info.riemannhypothesis.android.random;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.TextView;

public class GenerateActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupActionBar();

		Intent intent = getIntent();
		String lowerBoundString = intent
				.getStringExtra(MainActivity.EXTRA_LOWER);
		String upperBoundString = intent
				.getStringExtra(MainActivity.EXTRA_UPPER);
		int lowerBound;
		try {
			lowerBound = Integer.parseInt(lowerBoundString, 10);
		} catch (NumberFormatException e) {
			lowerBound = 0;
		}
		int upperBound;
		try {
			upperBound = Integer.parseInt(upperBoundString, 10);
		} catch (NumberFormatException e) {
			upperBound = lowerBound + 1;
		}

		if (upperBound <= lowerBound) {
			upperBound = lowerBound + 1;
		}
		upperBound++;

		int random = ((int) (Math.random() * (upperBound - lowerBound)))
				+ lowerBound;

		TextView textView = new TextView(this);
		textView.setTextSize(30);
		textView.setPadding(8, 8, 8, 8);
		textView.setText("Lower bound: " + lowerBound + "\nUpper bound: "
				+ (upperBound - 1) + "\n\nRandom: " + random);

		setContentView(textView);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
