package cl.telematica.httpjacksonparseexample.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DurationModel {
	
	@JsonProperty("text")
	public String distanceText;
	
	@JsonProperty("value")
	public long distanceValue;

}
