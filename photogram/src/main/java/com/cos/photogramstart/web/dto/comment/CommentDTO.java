package com.cos.photogramstart.web.dto.comment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CommentDTO {

	@NotBlank	// 빈값이거나 공백이거나 null 체크
	private String content;
	@NotNull
	private Integer imageId;
	
	// toEntity가 필요없다.
	
}
