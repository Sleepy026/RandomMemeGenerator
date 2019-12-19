package com.codecool.imageflipservice.model.generatedmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResponseModel {

	@JsonProperty("data")
	private DataModel dataModel;

	@JsonProperty("success")
	private boolean success;

	public void setDataModel(DataModel dataModel){
		this.dataModel = dataModel;
	}

	public DataModel getDataModel(){
		return dataModel;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"data = '" + dataModel + '\'' +
			",success = '" + success + '\'' + 
			"}";
		}
}
