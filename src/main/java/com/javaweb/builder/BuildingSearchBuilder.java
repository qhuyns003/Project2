package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {

	private String name;
	private Long floorarea;
	private String ward;
	private String street;
	private String districtid;
	private Integer numberofbasement;
	private List<String> typecode = new ArrayList<>();
	private String managername;
	private String managerphonenumber;
	private Long priceFrom;
	private Long priceTo;
	private Long areaFrom;
	private Long areaTo;
	private Long staffid;

	private BuildingSearchBuilder (Builder builder){ 
		this.name = builder.name; 
		this.floorarea = builder.floorarea;
		this.ward = builder.ward;
		this.street = builder.street;
		this.districtid = builder.districtid; 
		this.numberofbasement = builder.numberofbasement;
		this.typecode = builder.typecode;
		this.managername = builder.managername;
		this.managerphonenumber = builder.managerphonenumber;
		this.priceFrom = builder.priceFrom;
		this.priceTo = builder.priceTo;
		this.areaFrom = builder.areaFrom;
		this.areaTo = builder.areaTo;
		this.staffid = builder.staffid;
	}

	public String getName() {
		return name;
	}

	public Long getFloorarea() {
		return floorarea;
	}

	public String getWard() {
		return ward;
	}

	public String getStreet() {
		return street;
	}

	public String getDistrictid() {
		return districtid;
	}

	public Integer getNumberofbasement() {
		return numberofbasement;
	}

	public List<String> getTypecode() {
		return typecode;
	}

	public String getManagername() {
		return managername;
	}

	public String getManagerphonenumber() {
		return managerphonenumber;
	}

	public Long getPriceFrom() {
		return priceFrom;
	}

	public Long getPriceTo() {
		return priceTo;
	}

	public Long getAreaFrom() {
		return areaFrom;
	}

	public Long getAreaTo() {
		return areaTo;
	}

	public Long getStaffid() {
		return staffid;
	}

	public static class Builder {
		private String name;
		private Long floorarea;
		private String ward;
		private String street;
		private String districtid;
		private Integer numberofbasement;
		private List<String> typecode = new ArrayList<>();
		private String managername;
		private String managerphonenumber;
		private Long priceFrom;
		private Long priceTo;
		private Long areaFrom;
		private Long areaTo;
		private Long staffid;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setFloorarea(Long floorarea) {
			this.floorarea = floorarea;
			return this;
		}

		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder setDistrictid(String districtid) {
			this.districtid = districtid;
			return this;
		}

		public Builder setNumberofbasement(Integer numberofbasement) {
			this.numberofbasement = numberofbasement;
			return this;
		}

		public Builder setTypecode(List<String> typecode) {
			this.typecode = typecode;
			return this;
		}

		public Builder setManagername(String managername) {
			this.managername = managername;
			return this;
		}

		public Builder setManagerphonenumber(String managerphonenumber) {
			this.managerphonenumber = managerphonenumber;
			return this;
		}

		public Builder setPriceFrom(Long priceFrom) {
			this.priceFrom = priceFrom;
			return this;
		}

		public Builder setPriceTo(Long priceTo) {
			this.priceTo = priceTo;
			return this;
		}

		public Builder setAreaFrom(Long areaFrom) {
			this.areaFrom = areaFrom;
			return this;
		}

		public Builder setAreaTo(Long areaTo) {
			this.areaTo = areaTo;
			return this;
		}

		public Builder setStaffid(Long staffid) {
			this.staffid = staffid;
			return this;
		}
		
		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}

	}
}
