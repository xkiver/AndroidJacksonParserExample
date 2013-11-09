package cl.telematica.httpjacksonparseexample.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RouteDetailModel {
	
	@JsonProperty("copyrights")
	public String copyrights;
	
	@JsonProperty("legs")
	public List<LegsModel> legsList;
	
	@JsonProperty("overview_polyline")
	public PolylineModel overviewPolyline;
	
	@JsonProperty("summary")
	public String summary;

}
