package com.cos.photogramstart.web.dto.image;

import org.springframework.web.multipart.MultipartFile;

import com.cos.photogramstart.domain.image.Image;
import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class ImageUploadDTO {
	
	private MultipartFile file;
	private String caption;
	
	public Image toEntity(String postImaegUrl, User user) {
		return Image.builder()
				.caption(caption)
				.postImageUrl(postImaegUrl)
				.user(user)
				.build();
	}
	
}
