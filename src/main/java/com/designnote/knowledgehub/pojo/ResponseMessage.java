package com.designnote.knowledgehub.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
@Getter
@Setter
public class ResponseMessage<T> {

    private Integer code;
    private String message;
    private List<T> data;

    public ResponseMessage(Integer code, String message,List<T> data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseMessage<T> success(List<T> data){
        return new ResponseMessage<T>(HttpStatus.OK.value(), "success",data);
    }
}
