package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.sun.management.VMOption.Origin;

// rename하기 위해선 인터페이스를 구현해야함
public class MyFileRenamePolicy implements FileRenamePolicy{
	// 반드시 미완성된 rename 메소드를 오버라이딩하여 구현해야함
	// 기존의 파일을 전달받아서 파일명 수정작업을 마친 후에 수정된 파일을 반환해주는 메소드
	@Override
	public File rename(File originFile) {
		
		// 원본파일명 알아내기
		String originName = originFile.getName();
		
		// 수정파일명(임의로설정하는것임) : 파일 업로드시간(년월일시분초) + 5자리 랜덤값(10000~99999) => 최대한 이름이 겹치지 않게끔 작성
		// 확장자 : 원본파일 그대로
		
		// ex) 원본파일명 : 구름폭포 => 수정파일명 : 20220512141300.jpg
		
		// 파일 업로드 시간 구하기(년월일시분초) : currentTime
		String currentTime = new SimpleDateFormat("yyyMMddHHmmss").format(new Date()); //util 패키지 Date 임포트
		
		// 5자리 랜덤값 ranNum 10000~99999
		int ranNum = (int)(Math.random()*90000)+10000;
		
		// 원본파일 확장자 ext
		// 확장자 같은 경우 .~~~로 작성 되어 있고 만약 파일명 중간에 . 기호가 있을수 있으니 마지막 . 기호 기준으로 잡아준다
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime+ranNum+ext; //ex)"20220512144554321.jpg"
		
		//원본파일을 수정된 파일명으로 적용시켜서 파일 객체 반환
		
		return new File(originFile.getParent(),changeName);
	}


}
