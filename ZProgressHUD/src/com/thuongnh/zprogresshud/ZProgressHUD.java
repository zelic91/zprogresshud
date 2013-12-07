package com.thuongnh.zprogresshud;

import java.util.TimerTask;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.zprogresshud.R;

public class ZProgressHUD extends Dialog {
	static ZProgressHUD instance;
	View view;
	TextView tvMessage;
	ImageView ivSuccess;
	ImageView ivFailure;
	ProgressBar progress;
	
	public static ZProgressHUD getInstance(Context context) {
		if (instance==null) {
			instance = new ZProgressHUD(context);
		}
		
		
		
		return instance;
	}

	private ZProgressHUD(Context context) {
		super(context, R.style.DialogTheme);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setCanceledOnTouchOutside(false);
		view = getLayoutInflater().inflate(R.layout.dialog_progress, null);
		tvMessage = (TextView)view.findViewById(R.id.textview_message);
		ivSuccess = (ImageView)view.findViewById(R.id.imageview_success);
		ivFailure = (ImageView)view.findViewById(R.id.imageview_failure);
		progress = (ProgressBar)view.findViewById(R.id.progress);
		
		this.setContentView(view);
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
		progress.setVisibility(View.GONE);
		ivSuccess.setVisibility(View.VISIBLE);
	}

	protected void showFailureImage() {
		progress.setVisibility(View.GONE);
		ivFailure.setVisibility(View.VISIBLE);
	}
	
	protected void reset(){
		progress.setVisibility(View.VISIBLE);
		ivFailure.setVisibility(View.GONE);
		ivSuccess.setVisibility(View.GONE);
		tvMessage.setText("Loading ...");
		
	}
	
	protected void dismissHUD(){
		AsyncTask<String, Integer, Long> task = new AsyncTask<String, Integer, Long>(){

			@Override
			protected Long doInBackground(String... params) {
				SystemClock.sleep(500);
				return null;
			}

			@Override
			protected void onPostExecute(Long result) {
				super.onPostExecute(result);
				dismiss();
			}
		};
		task.execute();
	}

}
