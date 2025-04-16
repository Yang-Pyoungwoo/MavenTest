package edu.kunsan.cie.exam;

import java.util.Objects;
import java.util.regex.Pattern;

import com.thebuzzmedia.exiftool.Constants;
import com.thebuzzmedia.exiftool.Tag;

public class StringTag implements Tag{

	private String name;
	private Type type;
	
	public StringTag(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
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
	public enum Type {
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
