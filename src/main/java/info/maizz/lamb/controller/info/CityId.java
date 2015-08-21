
package info.maizz.lamb.controller.info;

import org.apache.commons.lang3.StringUtils;


public enum CityId {

	BEI_JING("BEI_JING","101010100"),

	SHANG_HAI("SHANG_HAI","101020100"),

	TIAN_JING ("TIAN_JING", "101030100"),

	CHONG_QING("CHONG_QING","101040100"),

	CHENG_DU ("CHENG_DU","101270101"),

	NAN_JING("NAN_JING", "101270101");


	private String name;

	private String cityId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	CityId(String name,String cityId){
		this.name=name;
		this.cityId=cityId;
	}

	public static String getCityIdByName(String name){
		String cityId = null;
		if(StringUtils.isBlank(name)){
			return null;
		}
		for (CityId c : values()) {
			if(StringUtils.equals(c.getName(),name)){
				cityId= c.getCityId();
			}
		}
		return cityId;
	}

}
