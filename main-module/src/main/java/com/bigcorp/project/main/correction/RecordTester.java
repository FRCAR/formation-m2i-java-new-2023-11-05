package com.bigcorp.project.main.correction;

public class RecordTester {

	public static void main(String[] args) {
		MonRecordDto monRecordDto = new MonRecordDto(Long.valueOf(3), "salut");
		
		System.out.println(monRecordDto.name());
		System.out.println(monRecordDto);
		
		MonRecordDto monRecordDto2 = new MonRecordDto(Long.valueOf(3), "salut");
		System.out.println("egal avec == "  + (monRecordDto == monRecordDto2));
		System.out.println("egal avec equals() " + monRecordDto.equals(monRecordDto2));
		
		System.out.println(monRecordDto.hashCode());
		System.out.println(monRecordDto2.hashCode());
		
	}

}
