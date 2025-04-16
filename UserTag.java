package edu.kunsan.cie.exam;

import java.util.Objects;
import java.util.regex.Pattern;

import com.thebuzzmedia.exiftool.Constants;
import com.thebuzzmedia.exiftool.Tag;

public enum UserTag implements Tag{

	MAKE("Make", Type.STRING),
	
	FOCAL_LENGTH("FocalLength", Type.DOUBLE),
	FOCAL_LENGTH_35MM("FocalLengthIn35mmFormat", Type.INTEGER),
	
	MODEL("Model", Type.STRING),
	
	GPS_LATITUDE_REF("GPSLatitudeRef", Type.STRING),
	GPS_LONGITUDE_REF("GPSLongitudeRef", Type.STRING),
	
	GPS_LATITUDE("GPSLatitude", Type.DOUBLE),
	GPS_LONGITUDE("GPSLongitude", Type.DOUBLE),
	
	GPS_ALTITUDE("GPSAltitude", Type.DOUBLE),
	GPS_ALTITUDE_REF("GPSAltitudeRef", Type.INTEGER),
	GIMBAL_YAW_DEGREE("GimbalYawDegree", Type.DOUBLE),
	GIMBAL_PITCH_DEGREE("GimbalPitchDegree", Type.DOUBLE),
	GIMBAL_ROLL_DEGREE("GimbalRollDegree", Type.DOUBLE);
	
	

	private final String name;

	/**
	 * Used to get a hint for the native type of this tag's value as
	 * specified by Phil Harvey's <a href="http://www.sno.phy.queensu.ca/~phil/exiftool/TagNames/index.html">ExifTool Tag Guide</a>.
	 */
	
	private final Type type;

	private UserTag(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String getName() {
		
		return this.name;
	}

	@Override
	public String getDisplayName() {
		
		return this.name;
	}

	@Override
	public <T> T parse(String value) {
		// TODO Auto-generated method stub
		return type.parse(value);
	}
	
	@SuppressWarnings("unchecked")
	private enum Type {
		INTEGER {
			@Override
			public <T> T parse(String value) {
				return (T) Integer.valueOf(Integer.parseInt(value));
			}
		},

		LONG {
			@Override
			public <T> T parse(String value) {
				return (T) Long.valueOf(Long.parseLong(value));
			}
		},

		DOUBLE {
			@Override
			public <T> T parse(String value) {
				if (Objects.equals("inf", value)) {
					return (T) Double.valueOf(Double.POSITIVE_INFINITY);
				}

				if (Objects.equals(value, "undef")) {
					return (T) Double.valueOf(Double.NaN);
				}

				return (T) Double.valueOf(Double.parseDouble(value));
			}
		},

		STRING {
			@Override
			public <T> T parse(String value) {
				return (T) value;
			}
		},

		ARRAY {
			@Override
			public <T> T parse(String value) {
				return (T) value.split(Pattern.quote(Constants.SEPARATOR));
			}
		};

		public abstract <T> T parse(String value);
	}
}
