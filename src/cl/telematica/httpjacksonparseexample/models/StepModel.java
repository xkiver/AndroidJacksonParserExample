package cl.telematica.httpjacksonparseexample.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class StepModel {
	
	@JsonProperty("distance")
	public DistanceModel distance;
	
	@JsonProperty("duration")
	public DurationModel duration;
	
	@JsonProperty("end_location")
	public EndLocationModel endLocation;
	
	@JsonProperty("start_location")
	public StartLocationModel startLocation;
	
	@JsonProperty("html_instructions")
	public String htmlInstructions;
	
	@JsonProperty("polyline")
	public PolylineModel polyline;
	
	@JsonProperty("travel_mode")
	public String travel_mode;

}
