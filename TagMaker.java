package edu.kunsan.cie.exam;

import java.util.HashMap;
import java.util.Map;



import com.thebuzzmedia.exiftool.Tag;

public class TagMaker {
	String maker;
	String model;
	Double forcalLength;
	int forcalLength35m;
	String latitudeRef;
	String longitudeRef;

	double latitude;
	double longitude;
	double altitude;
	double yaw;
	double pitch;
	double roll;
	
	public TagMaker(double lati, double longi, double alt, double yaw, double pitch, double roll) {
		this.maker = "Hasselblad";
		this.model = "L2D-20c";
		this.forcalLength = 12.0;
		this.forcalLength35m = 24;
		this.latitudeRef = "N";
		this.longitudeRef = "E";
		
		this.latitude = lati;
		this.longitude = longi;
		this.altitude = alt;
		this.yaw = yaw;
		this.pitch = pitch;
		this.roll = roll;
	}
	
	
	
	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getForcalLength() {
		return forcalLength;
	}

	public void setForcalLength(Double forcalLength) {
		this.forcalLength = forcalLength;
	}

	public String getLatitudeRef() {
		return latitudeRef;
	}

	public void setLatitudeRef(String latitudeRef) {
		this.latitudeRef = latitudeRef;
	}

	public String getLongitudeRef() {
		return longitudeRef;
	}

	public void setLongitudeRef(String longitudeRef) {
		this.longitudeRef = longitudeRef;
	}



	public int getForcalLength35m() {
		return forcalLength35m;
	}

	public void setForcalLength35m(int forcalLength35m) {
		this.forcalLength35m = forcalLength35m;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public double getYaw() {
		return yaw;
	}

	public void setYaw(double yaw) {
		this.yaw = yaw;
	}

	public double getPitch() {
		return pitch;
	}

	public void setPitch(double pitch) {
		this.pitch = pitch;
	}

	public double getRoll() {
		return roll;
	}

	public void setRoll(double roll) {
		this.roll = roll;
	}

	public Map<Tag, String> getTag(TagMaker t){
		HashMap<Tag, String> tag = new HashMap<Tag, String>();
		
//		tags.put(new StringTag("GpsLatitude", StringTag.Type.DOUBLE), "111.111");
//		MAKE("Make", Type.STRING),
//		
//		FOCAL_LENGTH("FocalLength", Type.DOUBLE),
//		FOCAL_LENGTH_35MM("FocalLengthIn35mmFormat", Type.INTEGER),
//		
//		MODEL("Model", Type.STRING),
//		
//		GPS_LATITUDE_REF("GPSLatitudeRef", Type.STRING),
//		GPS_LONGITUDE_REF("GPSLongitudeRef", Type.STRING),
//		
//		GPS_LATITUDE("GPSLatitude", Type.DOUBLE),
//		GPS_LONGITUDE("GPSLongitude", Type.DOUBLE),
//		
//		GPS_ALTITUDE("GPSAltitude", Type.DOUBLE),
//		GPS_ALTITUDE_REF("GPSAltitudeRef", Type.INTEGER),
//		GIMBAL_YAW_DEGREE("GimbalYawDegree", Type.DOUBLE),
//		GIMBAL_PITCH_DEGREE("GimbalPitchDegree", Type.DOUBLE),
//		GIMBAL_ROLL_DEGREE("GimbalRollDegree", Type.DOUBLE);
		
		tag.put(new StringTag("Make", StringTag.Type.STRING), this.maker);
		tag.put(new StringTag("FocalLength", StringTag.Type.DOUBLE), String.valueOf(this.forcalLength));
		tag.put(new StringTag("FOCAL_LENGTH_35MM", StringTag.Type.INTEGER), String.valueOf(this.forcalLength35m));
		tag.put(new StringTag("MODEL", StringTag.Type.STRING), this.model);
		tag.put(new StringTag("GPSLatitudeRef", StringTag.Type.STRING), this.latitudeRef);
		tag.put(new StringTag("GPSLongitudeRef", StringTag.Type.STRING), this.longitudeRef);
		tag.put(new StringTag("GPSLatitude", StringTag.Type.DOUBLE), String.valueOf(this.latitude));
		tag.put(new StringTag("GPSLongitude", StringTag.Type.DOUBLE), String.valueOf(this.longitude));
		tag.put(new StringTag("GPSAltitude", StringTag.Type.DOUBLE), String.valueOf(this.altitude));
		tag.put(new StringTag("GimbalYawDegree", StringTag.Type.DOUBLE), String.valueOf(this.yaw));
		tag.put(new StringTag("GimbalPitchDegree", StringTag.Type.DOUBLE), String.valueOf(this.pitch));
		tag.put(new StringTag("GimbalRollDegree", StringTag.Type.DOUBLE), String.valueOf(this.roll));

		return tag;
	}
	
}
