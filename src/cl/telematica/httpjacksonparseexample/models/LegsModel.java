package cl.telematica.httpjacksonparseexample.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LegsModel {
	
	@JsonProperty("distance")
	public DistanceModel distance;
	
	@JsonProperty("duration")
	public DurationModel duration;
	
	@JsonProperty("end_address")
	public String endAddress;
	
	@JsonProperty("end_location")
	public EndLocationModel endLocation;
	
	@JsonProperty("start_address")
	public String startAddress;
	
	@JsonProperty("start_location")
	public StartLocationModel startLocation;
	
	@JsonProperty("steps")
	public List<StepModel> steps;

}
