package cl.telematica.httpjacksonparseexample.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PolylineModel {
	
	@JsonProperty("points")
	public String points;

}
