package com.ojn.gexf4j.core;

import java.util.Date;
import java.util.List;

import com.ojn.gexf4j.core.data.AttributeValue;

public interface Edge {

	String getId();
	
	String getLabel();
	void setLabel(String label);
	
	Node getSource();
	
	Node getTarget();
	void setTarget(Node target);
	
	float getWeight();
	void setWeight(float weight);
	
	EdgeType getEdgeType();
	void setEdgeType(EdgeType edgeType);
	
	List<AttributeValue> getAttributeValues();
	
	Date getStartDate();
	void setStartDate(Date startDate);
	
	Date getEndDate();
	void setEndDate(Date endDate);
	
	List<Slice> getSlices();
}