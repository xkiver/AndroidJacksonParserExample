package cl.telematica.httpjacksonparseexample.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class StartLocationModel {
	
	@JsonProperty("lat")
	public double lat;
	
	@JsonProperty("lng")
	public double lng;

}
