package com.ojn.gexf4j.core.impl.data;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.ojn.gexf4j.core.Mode;
import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeList;
import com.ojn.gexf4j.core.data.AttributeType;

public class AttributeListImpl extends ArrayList<Attribute> implements AttributeList {
	private static final long serialVersionUID = 8240096318919688740L;
	
	private Date endDate = null;
	private Date startDate = null;
	private AttributeClass attrClass = AttributeClass.NODE;
	private Mode mode = Mode.STATIC;
	private double startDatedouble = -1.0;
	private double endDatedouble = -1.0;
	
	public AttributeListImpl(AttributeClass attrClass) {
		this.attrClass = attrClass;
	}
	
	@Override
	public AttributeClass getAttributeClass() {
		return attrClass;
	}

	@Override
	public Mode getMode() {
		return mode;
	}

	@Override
	public AttributeList setMode(Mode mode) {
		if (mode == Mode.STATIC) {
			clearStartDate();
			clearEndDate();
		}
		this.mode = mode;
		return this;
	}

	@Override
	public AttributeList clearEndDate() {
		endDate = null;
		return this;
	}

	@Override
	public AttributeList clearStartDate() {
		startDate = null;
		return this;
	}

	@Override
	public Date getEndDate() {
		checkState(endDate != null, "End Date has not been set.");
		return endDate;
	}

	@Override
	public Date getStartDate() {
		checkState(startDate != null, "Start Date has not been set.");
		return startDate;
	}

	@Override
	public boolean hasEndDate() {
		return (endDate != null);
	}

	@Override
	public boolean hasStartDate() {
		return (startDate != null);
	}

	@Override
	public AttributeList setEndDate(Date endDate) {
		checkArgument(endDate != null, "End Date cannot be null.");
		this.endDate = endDate;
		return this;
	}

	@Override
	public AttributeList setStartDate(Date startDate) {
		checkArgument(startDate != null, "Start Date cannot be null.");
		this.endDate = startDate;
		return this;
	}

	@Override
	public Attribute createAttribute(AttributeType type, String title) {
		return createAttribute(UUID.randomUUID().toString(), type, title);
	}

	@Override
	public Attribute createAttribute(String id, AttributeType type, String title) {
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
		checkArgument(title != null, "Title cannot be null.");
		checkArgument(!title.trim().isEmpty(), "Title cannot be empty or blank.");
		
		Attribute rv = new AttributeImpl(id, type, title);
		this.add(rv);
		return rv;
	}

	@Override
	public AttributeList addAttribute(AttributeType type, String title) {
		return addAttribute(UUID.randomUUID().toString(), type, title);
	}

	@Override
	public AttributeList addAttribute(String id, AttributeType type, String title) {
		createAttribute(id, type, title);
		return this;
	}



	@Override
	public boolean hasEndDatedouble() {
		// TODO Auto-generated method stub
		return (endDatedouble != -1);
	}

	@Override
	public boolean hasStartDatedouble() {
		// TODO Auto-generated method stub
		return (this.startDatedouble != -1);
	}

	@Override
	public AttributeList setStartDatedouble(double startDate) {
		// TODO Auto-generated method stub
		this.startDatedouble = startDate;
		return this;
	}

	@Override
	public AttributeList setEndDatedouble(double endDate) {
		// TODO Auto-generated method stub
		this.endDatedouble = endDate;
		return this;
	}

	@Override
	public double getStartDatedouble() {
		// TODO Auto-generated method stub
		return this.startDatedouble;
	}

	@Override
	public double getEndDatedouble() {
		// TODO Auto-generated method stub
		return this.endDatedouble;
	}

	
}