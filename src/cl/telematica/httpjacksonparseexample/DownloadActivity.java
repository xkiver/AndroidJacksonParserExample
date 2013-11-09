package cl.telematica.httpjacksonparseexample;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.telematica.httpjacksonparseexample.asynctask.DownloadManager;
import cl.telematica.httpjacksonparseexample.interfaces.DownloadListener;
import cl.telematica.httpjacksonparseexample.models.LegsModel;
import cl.telematica.httpjacksonparseexample.models.RouteDetailModel;
import cl.telematica.httpjacksonparseexample.models.RouteModel;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadActivity extends Activity implements DownloadListener {
	
	private ProgressBar progressBar;
	private TextView text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download);
		
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		text = (TextView) findViewById(R.id.textView1);
		
		new DownloadManager(this, 10000, 15000, "GET")
					.execute(getString(R.string.page_url));
	}

	@Override
	public void onRequestStart() {
		if(progressBar.getVisibility() == View.GONE)
			progressBar.setVisibility(View.VISIBLE);
	}

	@Override
	public void onRequestComplete(String data) {
		if(progressBar.getVisibility() == View.VISIBLE)
			progressBar.setVisibility(View.GONE);
		String textToShow = "";
		RouteModel model = (RouteModel) parseServiceResponse(data, RouteModel.class);
		if(model != null){
			List<RouteDetailModel> details = model.routesList;
			if(details != null && details.size() > 0){
				RouteDetailModel dModel = details.get(0);
				List<LegsModel> legsList = dModel.legsList;
				if(legsList != null && legsList.size() > 0){
					LegsModel lModel = legsList.get(0);
					textToShow = "Resultado: \n\n" +
										"status: " + model.status + "\n\n" +
										"copyright: " + dModel.copyrights + "\n\n" +
										"Steps length: " + dModel.legsList.size() + "\n\n" +
										"Start address: " + lModel.startAddress + "\n\n" +
										"End address: " + lModel.endAddress;
				} else {
					textToShow = "error";
				}
			} else {
				textToShow = "error";
			}
		} else {
			textToShow = "error";
		}
		text.setText(textToShow);
	}

	@Override
	public void onError(String error, int code) {
		if(progressBar.getVisibility() == View.VISIBLE)
			progressBar.setVisibility(View.GONE);
		text.setText(error);
	}	
	
	/**
	 * Parses the WebResponse.
	 * 
	 * @param reader
	 * @param expectedResponse
	 * @return
	 */
	public static Object parseServiceResponse(String reader, Class<?> type) {
		Object returnObj = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			returnObj = mapper.readValue(reader, type);
		} catch (JsonParseException errorException) {
			if (BuildConfig.DEBUG) {
				Log.e("JSON PARSE ERROR", errorException.getMessage());
				Log.e("JSON PARSE ERROR", reader);
			}
			return null;
		} catch (JsonMappingException ioexc) {

			if (BuildConfig.DEBUG) {
				Log.e("JSON MAPPING ERROR", ioexc.getMessage());
				Log.e("JSON MAPPING ERROR", reader);
			}
			return null;
		} catch (IOException e) {

			if (BuildConfig.DEBUG) {
				Log.e("IO ERROR", e.getMessage());
			}
			return null;
		}
		return returnObj;
	}

}
