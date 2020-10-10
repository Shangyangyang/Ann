package cn.ainannan.base.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class TongjiBean implements Serializable {
	private String s1;
	private String s2;
	private Integer n1;
	private Integer n2;
	private Integer n3;
	private Integer n4;

	private Long l1;
	private Date d1;
}
