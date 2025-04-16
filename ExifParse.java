package edu.kunsan.cie.exam;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thebuzzmedia.exiftool.ExifTool;
import com.thebuzzmedia.exiftool.ExifToolBuilder;
import com.thebuzzmedia.exiftool.Tag;
import com.thebuzzmedia.exiftool.core.StandardTag;

public class ExifParse {
	
	public static final File[] IMAGES = new File("c:/test/1")
			.listFiles();
	
	public static Map<Tag, String> parse(File image) throws Exception {
		
		Map<Tag, String> tags = new HashMap<Tag, String>();
		
		tags.put(new StringTag("GpsLatitude", StringTag.Type.DOUBLE), "111.111");
		try (ExifTool exifTool = new ExifToolBuilder().build()){
			
//			Map<Tag, String> addvalue = new HashMap<Tag, String>();
//			Tag tag = new Tag();
			
			StringTag tag = new StringTag("test", StringTag.Type.STRING);
			
			exifTool.setImageMeta(image, tags);
			
			return exifTool.getImageMeta(image, Arrays.asList(
				StandardTag.ISO,
				StandardTag.X_RESOLUTION,
				StandardTag.Y_RESOLUTION,
				UserTag.GPS_LATITUDE,
				UserTag.GPS_LONGITUDE,
				UserTag.FOCAL_LENGTH,
				UserTag.GIMBAL_YAW_DEGREE,
				UserTag.GIMBAL_ROLL_DEGREE,
				UserTag.GIMBAL_PITCH_DEGREE
			));
		}
	}
	
	public static void main(String[] args) throws Exception{
			
		
	}
}
