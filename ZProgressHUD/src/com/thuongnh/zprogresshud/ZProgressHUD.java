package com.thuongnh.zprogresshud;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zprogresshud.R;

public class ZProgressHUD extends Dialog {

	public static final int FADE_ROUND_SPINNER = 0;
	public static final int GEAR_SPINNER = 1;
	public static final int SIMPLE_ROUND_SPINNER = 2;

	static ZProgressHUD instance;
	View view;
	TextView tvMessage;
	ImageView ivSuccess;
	ImageView ivFailure;
	ImageView ivprogressSpinner;
	AnimationDrawable adProgressSpinner;

	public static ZProgressHUD getInstance(Context context) {
		if (instance == null) {
			instance = new ZProgressHUD(context);
		}
		return instance;
	}

	private ZProgressHUD(Context context) {
		super(context, R.style.DialogTheme);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setCanceledOnTouchOutside(false);
		view = getLayoutInflater().inflate(R.layout.dialog_progress, null);
		tvMessage = (TextView) view.findViewById(R.id.textview_message);
		ivSuccess = (ImageView) view.findViewById(R.id.imageview_success);
		ivFailure = (ImageView) view.findViewById(R.id.imageview_failure);
		ivprogressSpinner = (ImageView) view
				.findViewById(R.id.imageview_progress_spinner);

		setSpinnerType(FADE_ROUND_SPINNER);
		this.setContentView(view);
	}

	public void setSpinnerType(int spinnerType) {
		switch (spinnerType) {
		case 0:
			ivprogressSpinner.setImageResource(R.anim.round_spinner_fade);
			break;
		case 1:
			ivprogressSpinner.setImageResource(R.anim.gear_spinner);
			break;
		case 2:
			ivprogressSpinner.setImageResource(R.anim.round_spinner);
			break;
		default:
			ivprogressSpinner.setImageResource(R.anim.round_spinner_fade);
		}

		adProgressSpinner = (AnimationDrawable) ivprogressSpinner.getDrawable();
		adProgressSpinner.start();
	}
	
	public void setMessage(String message) {
		tvMessage.setText(message);
	}

	public void dismissWithSuccess() {
		tvMessage.setText("Success");
		showSuccessImage();
		dismissHUD();
	}

	public void dismissWithSuccess(String message) {
		showSuccessImage();
		if (message != null) {
			tvMessage.setText(message);
		} else {
			tvMessage.setText("");
		}
		dismissHUD();
	}

	public void dismissWithFailure() {
		showFailureImage();
		tvMessage.setText("Failure");
		dismissHUD();
	}

	public void dismissWithFailure(String message) {
		showFailureImage();
		if (message != null) {
			tvMessage.setText(message);
		} else {
			tvMessage.setText("");
		}
		dismissHUD();
	}

	protected void showSuccessImage() {
		ivprogressSpinner.setVisibility(View.GONE);
		ivSuccess.setVisibility(View.VISIBLE);
	}

	protected void showFailureImage() {
		ivprogressSpinner.setVisibility(View.GONE);
		ivFailure.setVisibility(View.VISIBLE);
	}

	protected void reset() {
		ivprogressSpinner.setVisibility(View.VISIBLE);
		ivFailure.setVisibility(View.GONE);
		ivSuccess.setVisibility(View.GONE);
		tvMessage.setText("Loading ...");
	}

	protected void dismissHUD() {
		AsyncTask<String, Integer, Long> task = new AsyncTask<String, Integer, Long>() {

			@Override
			protected Long doInBackground(String... params) {
				SystemClock.sleep(500);
				return null;
			}

			@Override
			protected void onPostExecute(Long result) {
				super.onPostExecute(result);
				dismiss();
				reset();
			}
		};
		task.execute();
	}

}
